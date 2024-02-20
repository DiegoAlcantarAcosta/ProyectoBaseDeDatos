CREATE DATABASE BANCO;
USE BANCO;

create table if not exists Usuarios(
	idUsuario int primary key auto_increment,
    nombreUsuario varchar(20) not null,
    contraseña varchar(10) not null
    );
-- Crear la tabla DIRECCIONES
CREATE TABLE IF NOT EXISTS DIRECCIONES (
    idDireccion INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(50) NOT NULL,
    colonia VARCHAR(50) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    codigoPostal VARCHAR(10) NOT NULL
);

-- Crear la tabla CLIENTES
CREATE TABLE IF NOT EXISTS CLIENTES (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidoPaterno VARCHAR(50) NOT NULL,
    apellidoMaterno VARCHAR(50),
    fechaNacimiento DATE NOT NULL,
    edad INT,
    idUsuario INT,
    idDireccion INT,
    FOREIGN KEY (idUsuario) REFERENCES USUARIOS(idUsuario),
    FOREIGN KEY (idDireccion) REFERENCES DIRECCIONES(idDireccion)
);
    CREATE TABLE IF NOT EXISTS CUENTAS (
    idCuenta INT PRIMARY KEY NOT NULL auto_increment,
    numCuenta int,
    saldo DECIMAL(10, 2) DEFAULT 0,
    fechaApertura DATE NOT NULL,
    estado VARCHAR(10) DEFAULT 'ACTIVO' CHECK (estado IN ('ACTIVO', 'CANCELADA')),
    idCliente int,
    FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
);
-- Crear la tabla OPERACIONES
CREATE TABLE IF NOT EXISTS OPERACIONES (
    idTransaccion INT PRIMARY KEY AUTO_INCREMENT,
    idCuenta_origen int not null,
    tipo VARCHAR(30) CHECK (tipo IN ('TRANSFERENCIA','RETIRO SIN CUENTA')),
    fecha DATETIME NOT NULL,
    monto DECIMAL(10, 2) NOT NULL CHECK (monto BETWEEN 1 AND 10000),
    FOREIGN KEY (idCuenta_origen) REFERENCES Cuentas(idCuenta)
);
Create table if not exists Transferencia(
	idTransferencia int primary key auto_increment,
    idCuenta_destino int not null,
    idOperacion int not null,
    FOREIGN KEY (idCuenta_destino) REFERENCES Cuentas(idCuenta),
    FOREIGN KEY (idOperacion) REFERENCES Operaciones(idTransaccion)
    );
    Create table if not exists SinCuentas(
	idSinCuentas int primary key auto_increment,
    folio int,
    contraseña int not null,
    estado VARCHAR(30) DEFAULT 'Procesando' CHECK (estado IN ('Procesando', 'NO COBRADO', 'COBRADO')),
    idOperacion int not null,
    FOREIGN KEY (idOperacion) REFERENCES Operaciones(idTransaccion)
    );
    
DELIMITER //
CREATE TRIGGER actualizar_idCliente
AFTER INSERT ON Usuarios
FOR EACH ROW
BEGIN
    DECLARE lastDireccionId INT;
    DECLARE lastUsuarioId INT;
    
    -- Obtener el último id insertado en la tabla Direcciones
    SELECT idDireccion INTO lastDireccionId FROM Direcciones ORDER BY idDireccion DESC LIMIT 1;
    
    -- Obtener el último id insertado en la tabla Usuarios
    SELECT idUsuario INTO lastUsuarioId FROM Usuarios ORDER BY idUsuario DESC LIMIT 1;
    
    -- Actualizar la tabla Clientes con los nuevos ids
    UPDATE Clientes SET idUsuario = lastUsuarioId WHERE idUsuario IS NULL;
    UPDATE Clientes SET idDireccion = lastDireccionId WHERE idDireccion IS NULL;
END;
//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE calcularEdadCliente()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE idClienteVar INT;
    DECLARE fechaNacimientoVar DATE;
    DECLARE edadVar INT;
    
    -- Declarar un cursor para iterar sobre los registros de la tabla Clientes
    DECLARE cur CURSOR FOR SELECT idCliente, fechaNacimiento FROM Clientes;
    
    -- Declarar un manejador para errores
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    
    -- Iniciar la iteración sobre los registros de la tabla Clientes
    calculo: LOOP
        FETCH cur INTO idClienteVar, fechaNacimientoVar;
        IF done THEN
            LEAVE calculo;
        END IF;
        
        -- Calcular la edad en base a la fecha de nacimiento
        SET edadVar = TIMESTAMPDIFF(YEAR, fechaNacimientoVar, CURDATE());
        
        -- Actualizar el campo edad en la tabla Clientes
        UPDATE Clientes SET edad = edadVar WHERE idCliente = idClienteVar;
    END LOOP;

    CLOSE cur;
END;
//
DELIMITER ;

DELIMITER //

CREATE PROCEDURE transferencia_entre_cuentas (
    IN cuenta_origen INT,
    IN cuenta_destino INT,
    IN monto_transferencia DECIMAL(10, 2)
)
BEGIN
    DECLARE saldo_origen DECIMAL(10, 2);
    DECLARE saldo_destino DECIMAL(10, 2);
    DECLARE idOperacion INT;

    START TRANSACTION;

    -- Obtener saldo de la cuenta de origen
    SELECT saldo INTO saldo_origen FROM CUENTAS WHERE idCuenta = cuenta_origen;

    -- Obtener saldo de la cuenta de destino
    SELECT saldo INTO saldo_destino FROM CUENTAS WHERE idCuenta = cuenta_destino;

    -- Verificar que el saldo de la cuenta de origen sea suficiente
    IF saldo_origen >= monto_transferencia THEN
        -- Actualizar saldo de la cuenta de origen
        UPDATE CUENTAS SET saldo = saldo - monto_transferencia WHERE idCuenta = cuenta_origen;

        -- Actualizar saldo de la cuenta de destino
        UPDATE CUENTAS SET saldo = saldo + monto_transferencia WHERE idCuenta = cuenta_destino;

        -- Registrar la transferencia en la tabla de operaciones
        INSERT INTO OPERACIONES (idCuenta_origen, tipo, fecha, monto)
        VALUES (cuenta_origen, 'TRANSFERENCIA', CURDATE(), monto_transferencia);

        -- Obtener el id de la operación recién insertada
        SELECT LAST_INSERT_ID() INTO idOperacion;

        -- Registrar la transferencia en la tabla de transferencia
        INSERT INTO TRANSFERENCIA (idCuenta_destino, idOperacion)
        VALUES (cuenta_destino, idOperacion);

        COMMIT;
    ELSE
        -- Si el saldo de la cuenta de origen no es suficiente, lanzar un error
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El saldo de la cuenta de origen no es suficiente para realizar la transferencia';
    END IF;
END;
//

DELIMITER ;


DELIMITER //

CREATE PROCEDURE depositar_en_cuenta (
    IN cuenta INT,
    IN monto DECIMAL(10, 2)
)
BEGIN
    DECLARE saldo_actual DECIMAL(10, 2);
    
    -- Verificar que el monto sea mayor que $1 y menor o igual que $10,000
    IF monto < 1 OR monto > 10000 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El monto del depósito debe ser mínimo $1 y máximo $10,000.';
    END IF;
    
    -- Verificar que el monto sea múltiplo de $100 para montos mayores a $1
    IF monto > 1 AND monto % 100 != 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Los depósitos mayores a $1 deben ser de $100 en $100.';
    END IF;

    START TRANSACTION;

    -- Obtener el saldo actual de la cuenta
    SELECT saldo INTO saldo_actual FROM CUENTAS WHERE numCuenta = cuenta FOR UPDATE;

    -- Añadir el monto al saldo actual
    UPDATE CUENTAS SET saldo = saldo_actual + monto WHERE numCuenta = cuenta;

    -- No registrar la operación en la tabla de operaciones ya que no se guarda en el historial

    COMMIT;
END //
CREATE PROCEDURE restar_monto_solicitado(
    IN operacion_id INT
)
BEGIN
    DECLARE monto_solicitado DECIMAL(10, 2);
    DECLARE saldo_cuenta DECIMAL(10, 2);
    DECLARE cuenta_origen INT;

    -- Obtener el monto solicitado de la operación
    SELECT monto INTO monto_solicitado FROM OPERACIONES WHERE idTransaccion = operacion_id;

    -- Obtener la cuenta de origen asociada a la operación
    SELECT idCuenta_origen INTO cuenta_origen FROM OPERACIONES WHERE idTransaccion = operacion_id;

    -- Obtener el saldo actual de la cuenta de origen
    SELECT saldo INTO saldo_cuenta FROM CUENTAS WHERE idCuenta = cuenta_origen;

    -- Verificar si hay fondos suficientes
    IF saldo_cuenta < monto_solicitado THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El saldo de la cuenta de origen no es suficiente para realizar la transferencia';
    ELSE
        -- Restar el monto solicitado de la cuenta del usuario
        UPDATE CUENTAS SET saldo = saldo - monto_solicitado WHERE idCuenta = cuenta_origen;
    END IF;
END;
//
DELIMITER //
CREATE TRIGGER trigger_cambiar_estado
AFTER UPDATE ON SinCuentas
FOR EACH ROW
BEGIN
    IF OLD.estado = 'Procesando' AND NEW.estado = 'COBRADO' THEN
        CALL restar_monto_solicitado(NEW.idOperacion);
    END IF;
END;
//
DELIMITER ;
DELIMITER //
CREATE TRIGGER incrementar_folio_sin_cuenta
BEFORE INSERT ON SinCuentas
FOR EACH ROW
BEGIN
    DECLARE ultimo_folio INT;
    -- Obtener el último folio registrado en la tabla SinCuentas
    SELECT folio INTO ultimo_folio FROM SinCuentas ORDER BY idSinCuentas DESC LIMIT 1;
    -- Incrementar el folio del nuevo registro
    SET NEW.folio = IFNULL(ultimo_folio, 999) + 1;
END;
//
DELIMITER ;
DELIMITER //
CREATE EVENT IF NOT EXISTS verificar_estado_sincuentas
ON SCHEDULE EVERY 10 SECOND
DO
BEGIN
    Update sincuentas s inner join operaciones o on s.idOperacion = o.idTransaccion
    set s.estado= 'NO COBRADO'
    where s.estado = 'Procesando' AND timestampdiff(minute, o.fecha, now()) >= 10;
END;
//
DELIMITER ;
INSERT INTO CLIENTES (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento) VALUES ('Hector', 'Espinoza', 'Duarte', '1990-01-01');
INSERT INTO CLIENTES (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento) VALUES ('Enrique', 'Rodriguez', 'Angulo', '1985-05-15');
INSERT INTO CLIENTES (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento) VALUES ('Victor', 'Encinas', 'Guzman', '2000-12-30');
INSERT INTO DIRECCIONES (calle, colonia, numero, codigoPostal) VALUES ('Avenida Itson', 'Villa Itson', '2443', 'CP12345');
INSERT INTO DIRECCIONES (calle, colonia, numero, codigoPostal) VALUES ('Ochoa', 'Misiones', '456', 'CP67890');
INSERT INTO DIRECCIONES (calle, colonia, numero, codigoPostal) VALUES ('Colosio', 'Casa Blanca', '789', 'CP13579');
INSERT INTO Usuarios (nombreUsuario, contraseña) VALUES ('beto', 'pass1');
INSERT INTO Usuarios (nombreUsuario, contraseña) VALUES ('kike', 'pass2');
INSERT INTO Usuarios (nombreUsuario, contraseña) VALUES ('toro', 'pass3');
INSERT INTO CUENTAS (numCuenta, fechaApertura, estado, idCliente) VALUES (123456, '2024-01-01', 'ACTIVO', 1);
INSERT INTO CUENTAS (numCuenta, fechaApertura, estado, idCliente) VALUES (987654, '2024-02-01', 'ACTIVO', 2);
INSERT INTO CUENTAS (numCuenta, fechaApertura, estado, idCliente) VALUES (555555, '2024-02-15', 'ACTIVO', 3);

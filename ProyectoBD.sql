CREATE TABLE BANCO;
USE BANCO;

CREATE TABLE CUENTAS (
numCuenta int primary key NOT NULL,
saldo decimal default "0",
fechaApertura date NOT NULL,
contraseña varchar(20) NOT NULL,
estado varchar(10) default "ACTIVO", CHECK (estado IN ('ACTIVO', 'CANCELADA'))
);

CREATE TABLE DIRECCIONES (
idDireccion int primary key auto_increment,
calle varchar(50) NOT NULL,
colonia varchar(50) NOT NULL,
numero varchar(10) NOT NULL,
codigoPostal varchar(10) NOT NULL
);

CREATE TABLE CLIENTES (
idCliente int primary key auto_increment,
nombre varchar(50) NOT NULL,
apellidoPaterno varchar(50) NOT NULL,
apellidoMaterno varchar(50),
fechaNacimiento date NOT NULL,
edad int NOT NULL,
idCuenta int,
idDireccion int NOT NULL,
foreign key (idCuenta) REFERENCES CUENTAS(numCuenta),
foreign key (idDireccion) REFERENCES DIRECCIONES(idDireccion)
);

CREATE TABLE OPERACIONES (
idTransaccion int primary key auto_increment,
tipo varchar(30) CHECK (tipo IN ('TRANSFERENCIA', 'RETIRO SIN CUENTA')) NOT NULL,
fecha date NOT NULL,
monto decimal NOT NULL,
folio varchar(8) NOT NULL,
numCuenta int NOT NULL,
foreign key (numCuenta) REFERENCES CUENTAS(numCuenta)
);
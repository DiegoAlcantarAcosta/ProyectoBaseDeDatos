/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

import DTO.ClienteDTO;
import DTO.CuentaDTO;
import DTO.DireccionDTO;
import DTO.RetiroSinDTO;
import DTO.TransferenciaDTO;
import DTO.UsuariosDTO;
import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Direccion;
import Entidades.Operaciones;
import Entidades.SinCuenta;
import Entidades.Transferencia;
import Entidades.Usuario;
import Excepciones.PersistenciaExcepcion;
import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define las operaciones que puede realizar el controlador en el sistema bancario.
 * Cada método tiene su descripción detallada en la documentación.
 * Implementada por la clase Controlador.
 * 
 * @author lv1821
 */
public interface IControlador {
    
     /**
     * Autentica un nuevo usuario en el sistema.
     * 
     * @param usuario Objeto de la clase Usuario a registrar.
     * @return True si el registro es exitoso, false en caso contrario.
     */
    boolean autenticarUsuario(String usuario, String contraseña);
    
    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param usuario Objeto de la clase Usuario a registrar.
     * @return True si el registro es exitoso, false en caso contrario.
     */
    public boolean registrarUsuario(Usuario usuario);
    
    /**
     * Actualiza la información de un usuario en el sistema.
     * 
     * @param usuario Objeto de la clase UsuariosDTO con la información actualizada.
     * @param idUsuario Identificador único del usuario a actualizar.
     * @return True si la actualización es exitosa, false en caso contrario.
     */
    boolean actualizarUsuario(UsuariosDTO usuario, int idUsuario);
    
    /**
     * Obtiene la información de un cliente por su identificador único.
     * 
     * @param idCliente Identificador único del cliente.
     * @return Objeto ClienteDTO con la información del cliente.
     * @throws PersistenciaExcepcion Excepción en caso de error al obtener la información.
     */
    ClienteDTO obtenerCliente(int idCliente) throws PersistenciaExcepcion;
    
    /**
     * Actualiza la información de un cliente en el sistema.
     * 
     * @param cliente Objeto de la clase ClienteDTO con la información actualizada.
     * @param idCliente Identificador único del cliente a actualizar.
     * @return True si la actualización es exitosa, false en caso contrario.
     * @throws PersistenciaExcepcion Excepción en caso de error al actualizar la información.
     */
    boolean actualizarCliente(ClienteDTO cliente, int idCliente) throws PersistenciaExcepcion;
    
    /**
     * Registra un nuevo cliente en el sistema.
     * 
     * @param cliente Objeto de la clase Cliente a registrar.
     * @return True si el registro es exitoso, false en caso contrario.
     * @throws PersistenciaExcepcion Excepción en caso de error al registrar al cliente.
     */
    boolean registrarCliente(Cliente cliente) throws PersistenciaExcepcion;
    
    /**
     * Obtiene la lista de cuentas asociadas a un cliente.
     * 
     * @param idCliente Identificador único del cliente.
     * @return Lista de objetos Cuenta con la información de las cuentas del cliente.
     * @throws PersistenciaExcepcion Excepción en caso de error al obtener la información.
     */
    List<Cuenta> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion;
    
    /**
     * Obtiene la información de una cuenta por su número.
     * 
     * @param numeroCuenta Número de la cuenta.
     * @return Objeto CuentaDTO con la información de la cuenta.
     */
    CuentaDTO obtenerCuenta(int numeroCuenta);

    /**
     * Obtiene el número de una cuenta.
     * 
     * @param cuenta Objeto de la clase Cuenta.
     * @return Número de la cuenta.
     */
    int numeroCuenta(Cuenta cuenta);

    /**
     * Actualiza el estado de una cuenta en el sistema.
     * 
     * @param cuenta Número de la cuenta a actualizar.
     * @return True si la actualización es exitosa, false en caso contrario.
     */
    boolean actualizarEstadoCuenta(int cuenta);

    /**
     * Crea una nueva cuenta en el sistema.
     * 
     * @param cuenta Objeto de la clase Cuenta con la información de la nueva cuenta.
     * @param num Número de la nueva cuenta.
     * @return True si la creación es exitosa, false en caso contrario.
     */
    boolean crearCuenta(Cuenta cuenta, int num);
    
    /**
     * Crea una nueva cuenta en el sistema asociada a un cliente.
     * 
     * @param cuenta Objeto de la clase Cuenta con la información de la nueva cuenta.
     * @param id Identificador único del cliente asociado a la cuenta.
     * @param num Número de la nueva cuenta.
     * @return True si la creación es exitosa, false en caso contrario.
     */
    boolean crearCuentaNueva(Cuenta cuenta, int id, int num);

    /**
     * Obtiene el identificador único de un cliente asociado a un usuario.
     * 
     * @param idUsuario Identificador único del usuario.
     * @return Identificador único del cliente asociado al usuario.
     */
    int idClienteUsuario(int idUsuario);
    
    /**
     * Obtiene el identificador único de un cliente asociado a una dirección.
     * 
     * @param idDireccion Identificador único de la dirección.
     * @return Identificador único del cliente asociado a la dirección.
     */
    int idClienteDireccion(int idDireccion);
    
    /**
     * Suma un monto a una cuenta.
     * 
     * @param cuenta Número de la cuenta.
     * @param monto Monto a sumar.
     */
    void sumarMonto(int cuenta, float monto);
    
    /**
     * Obtiene la información de una dirección por su identificador único.
     * 
     * @param idDireccion Identificador único de la dirección.
     * @return Objeto DireccionDTO con la información de la dirección.
     */
    DireccionDTO obtenerDireccion(int idDireccion);
    
    /**
     * Actualiza la información de una dirección en el sistema.
     * 
     * @param direccion Objeto de la clase DireccionDTO con la información actualizada.
     * @param idDireccion Identificador único de la dirección a actualizar.
     * @return True si la actualización es exitosa, false en caso contrario.
     */
    boolean actualizarDireccion(DireccionDTO direccion, int idDireccion);
    
    /**
     * Registra una nueva dirección en el sistema.
     * 
     * @param direccion Objeto de la clase Direccion a registrar.
     * @return True si el registro es exitoso, false en caso contrario.
     */
    boolean registrarDireccion(Direccion direccion);
    
    /**
     * Autentica el cobro de un retiro sin cuenta.
     * 
     * @param folio Folio del retiro sin cuenta.
     * @param contraseña Contraseña asociada al retiro sin cuenta.
     * @return True si la autenticación es exitosa, false en caso contrario.
     */
    public boolean autenticarCobro(int folio, int contraseña);
    
    /**
     * Genera un retiro sin cuenta en el sistema.
     * 
     * @param sin Objeto de la clase RetiroSinDTO con la información del retiro sin cuenta.
     * @param num Número asociado al retiro sin cuenta.
     * @return True si la generación es exitosa, false en caso contrario.
     */
    public boolean generarSinCuenta(RetiroSinDTO sin, int num);
    
    /**
     * Genera una contraseña para un retiro sin cuenta.
     * 
     * @return Contraseña generada.
     */
    public int generarContraseña();
    
    /**
     * Actualiza el estado de una cuenta.
     * 
     * @param numCuenta Número de la cuenta.
     * @throws SQLException Excepción en caso de error al actualizar el estado.
     */
    public void actualizarEstado(int numCuenta) throws SQLException;
    
    /**
     * Realiza una transferencia entre cuentas.
     * 
     * @param trans Objeto de la clase TransferenciaDTO con la información de la transferencia.
     * @return Objeto TransferenciaDTO con la información de la transferencia realizada.
     * @throws SQLException Excepción en caso de error al realizar la transferencia.
     */
    TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) throws SQLException;
    
    /**
     * Obtiene el identificador único de un cliente por su nombre y apellido paterno.
     * 
     * @param nombre Nombre del cliente.
     * @param paterno Apellido paterno del cliente.
     * @return Identificador único del cliente.
     */
    int idCliente(String nombre, String paterno);
    
    /**
     * Obtiene el identificador único de una cuenta por su fecha de creación.
     * 
     * @param fecha Fecha de creación de la cuenta.
     * @return Identificador único de la cuenta.
     */
    int idCuenta(String fecha);
    
    /**
     * Obtiene el identificador único de una dirección por sus datos.
     * 
     * @param calle Calle de la dirección.
     * @param colonia Colonia de la dirección.
     * @param numero Número de la dirección.
     * @return Identificador único de la dirección.
     */
    int idDireccion(String calle, String colonia, String numero);
    
    /**
     * Obtiene el identificador único de un usuario por su contraseña y nombre de usuario.
     * 
     * @param contraseña Contraseña del usuario.
     * @param usuario Nombre de usuario del usuario.
     * @return Identificador único del usuario.
     */
    int idUsuario(String contraseña, String usuario);
    
    /**
     * Obtiene el identificador único de una cuenta por su número.
     * 
     * @param numCuenta Número de la cuenta.
     * @return Identificador único de la cuenta.
     */
    public int idCuenta(int numCuenta);
    
    /**
     * Agrega una operación al sistema.
     * 
     * @param op Objeto de la clase Operaciones con la información de la operación.
     */
    public void agregarOperacion(Operaciones op);
    
    /**
     * Obtiene el identificador único de una operación por su fecha.
     * 
     * @param fecha Fecha de la operación.
     * @return Identificador único de la operación.
     */
    public int idOperacion(String fecha);
    
    /**
     * Obtiene el número de folio para un retiro sin cuenta.
     * 
     * @return Número de folio.
     */
    public int obtenerFolio();
    
    /**
     * Ejecuta un evento.
     */
    public void evento();
    
    /**
     * Obtiene el identificador único de un retiro por su folio y contraseña.
     * 
     * @param folio Folio del retiro.
     * @param contraseña Contraseña asociada al retiro.
     * @return Identificador único del retiro.
     */
    public int idRetiro(int folio, int contraseña);
    
    /**
     * Obtiene el historial de transferencias realizadas en un rango de fechas.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos Transferencia con la información de las transferencias.
     */
    List<Transferencia> obtenerHistorialTransferencia(String desde, String hasta);
    
    /**
     * Obtiene el historial de retiros sin cuenta realizados en un rango de fechas.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos SinCuenta con la información de los retiros sin cuenta.
     */
    List<SinCuenta> obtenerHistorialSinCuenta(String desde, String hasta);
    
    /**
     * Obtiene el historial completo de retiros sin cuenta.
     * 
     * @return Lista de objetos SinCuenta con la información de los retiros sin cuenta.
     */
    List<SinCuenta> obtenerTodaSInCuenta();
    
    /**
     * Obtiene el historial completo de transferencias realizadas.
     * 
     * @return Lista de objetos Transferencia con la información de las transferencias.
     */
    List<Transferencia> obtenerTodasTransferencia();
    
    /**
     * Realiza un depósito en una cuenta.
     * 
     * @param cuenta Número de la cuenta.
     * @param monto Monto a depositar.
     * @return True si el depósito es exitoso, false en caso contrario.
     * @throws SQLException Excepción en caso de error al realizar el depósito.
     */
    public boolean depositar(int cuenta, float monto) throws SQLException ;
}

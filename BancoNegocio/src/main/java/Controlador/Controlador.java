/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Conexion.IConexion;
import DAO.ClienteDAO;
import DAO.CuentaDAO;
import DAO.DireccionDAO;
import DAO.IClienteDAO;
import DAO.ICuentaDAO;
import DAO.IDireccionDAO;
import DAO.IOperacionesDAO;
import DAO.IRetiroSinDAO;
import DAO.ITransferenciaDAO;
import DAO.IUsuarioDAO;
import DAO.OperacionesDAO;
import DAO.RetiroSinDAO;
import DAO.TransferenciaDAO;
import DAO.UsuarioDAO;
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
import javax.swing.JOptionPane;

/**
 * El controlador actúa como una interfaz entre la interfaz de usuario y los
 * objetos del modelo. Maneja las solicitudes de la interfaz de usuario, realiza
 * la lógica de negocio y actualiza el modelo según sea necesario.
 *
 * @author lv1821
 */
public class Controlador implements IControlador {

    String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    String usuario = "root";
    String contrasenia = "2608jlml";
    IConexion conexionBD = new Conexion(cadenaConexion, usuario, contrasenia);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
    IDireccionDAO direccion = new DireccionDAO(conexionBD);
    IOperacionesDAO operacionesDAO = new OperacionesDAO(conexionBD);
    IRetiroSinDAO retiro = new RetiroSinDAO(conexionBD);
    ITransferenciaDAO transferencia = new TransferenciaDAO(conexionBD);
    IUsuarioDAO usuario2 = new UsuarioDAO(conexionBD);

    /**
     * Autentica a un usuario en el sistema.
     *
     * @param usuario Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     * @return `true` si la autenticación es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean autenticarUsuario(String usuario, String contraseña) {
        if (usuario2.autenticarUsuario(usuario, contraseña)) {
            return true;
        }
        return false;
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario Objeto Usuario a registrar.
     * @return `true` si el registro es exitoso, `false` en caso contrario.
     */
    @Override
    public boolean registrarUsuario(Usuario usuario) {
        if (usuario2.registrarUsuario(usuario)) {
            return true;
        }
        return false;
    }

    /**
     * Actualiza la información de un usuario en el sistema.
     *
     * @param usuario Objeto UsuariosDTO con la información actualizada.
     * @param idUsuario Identificador único del usuario a actualizar.
     * @return `true` si la actualización es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean actualizarUsuario(UsuariosDTO usuario, int idUsuario) {
        if (usuario2.actualizarUsuario(usuario, idUsuario)) {
            return true;
        }
        return false;
    }

    /**
     * Obtiene la información de un cliente por su identificador único.
     *
     * @param idCliente Identificador único del cliente.
     * @return Objeto ClienteDTO con la información del cliente.
     * @throws PersistenciaExcepcion Si hay un error al obtener la información
     * del cliente.
     */
    @Override
    public ClienteDTO obtenerCliente(int idCliente) throws PersistenciaExcepcion {
        ClienteDTO c = clienteDAO.obtenerCliente(idCliente);
        return c;
    }

    /**
     * Actualiza la información de un cliente en el sistema.
     *
     * @param cliente Objeto ClienteDTO con la información actualizada.
     * @param idCliente Identificador único del cliente a actualizar.
     * @return `true` si la actualización es exitosa, `false` en caso contrario.
     * @throws PersistenciaExcepcion Si hay un error al actualizar la
     * información del cliente.
     */
    @Override
    public boolean actualizarCliente(ClienteDTO cliente, int idCliente) throws PersistenciaExcepcion {
        if (clienteDAO.actualizarCliente(cliente, idCliente)) {
            return true;
        }
        return false;
    }

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param cliente Objeto Cliente a registrar.
     * @return `true` si el registro es exitoso, `false` en caso contrario.
     * @throws PersistenciaExcepcion Si hay un error al registrar el cliente.
     */
    @Override
    public boolean registrarCliente(Cliente cliente) throws PersistenciaExcepcion {
        if (clienteDAO.registrarCliente(cliente)) {
            return true;
        }
        return false;
    }

    /**
     * Obtiene la lista de cuentas asociadas a un cliente por su identificador
     * único.
     *
     * @param idCliente Identificador único del cliente.
     * @return Lista de objetos Cuenta asociadas al cliente.
     * @throws PersistenciaExcepcion Si hay un error al obtener las cuentas del
     * cliente.
     */
    @Override
    public List<Cuenta> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion {
        List<Cuenta> c = clienteDAO.obtenerCuentasCliente(idCliente);
        return c;
    }

    /**
     * Obtiene la información de una cuenta por su número.
     *
     * @param numeroCuenta Número de cuenta.
     * @return Objeto CuentaDTO con la información de la cuenta.
     */
    @Override
    public CuentaDTO obtenerCuenta(int numeroCuenta) {
        CuentaDTO c = cuentaDAO.obtenerCuenta(numeroCuenta);
        return c;
    }

    /**
     * Obtiene el número de cuenta asociado a una cuenta.
     *
     * @param cuenta Objeto Cuenta del que se desea obtener el número.
     * @return Número de cuenta asociado.
     */
    @Override
    public int numeroCuenta(Cuenta cuenta) {
        int c = cuentaDAO.numeroCuenta(cuenta);
        return c;
    }

    /**
     * Actualiza el estado de una cuenta en el sistema.
     *
     * @param cuenta Número de cuenta.
     * @return `true` si la actualización es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean actualizarEstadoCuenta(int cuenta) {
        if (cuentaDAO.actualizarEstadoCuenta(cuenta)) {
            return true;
        }
        return false;
    }

    /**
     * Crea una nueva cuenta en el sistema.
     *
     * @param cuenta Objeto Cuenta a crear.
     * @param num Número de cuenta.
     * @return `true` si la creación es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean crearCuenta(Cuenta cuenta, int num) {
        if (cuentaDAO.crearCuenta(cuenta, num)) {
            return true;
        }
        return false;
    }

    /**
     * Crea una nueva cuenta en el sistema asociada a un cliente.
     *
     * @param cuenta Objeto Cuenta a crear.
     * @param id Identificador único del cliente asociado.
     * @param num Número de cuenta.
     * @return `true` si la creación es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean crearCuentaNueva(Cuenta cuenta, int id, int num) {
        if (cuentaDAO.crearCuentaNueva(cuenta, id, num)) {
            return true;
        }
        return false;
    }

    /**
     * Suma un monto a la cuenta especificada.
     *
     * @param cuenta Número de cuenta.
     * @param monto Monto a sumar.
     */
    @Override
    public void sumarMonto(int cuenta, float monto) {
        sumarMonto(cuenta, monto);
    }

    /**
     * Obtiene la información de una dirección por su identificador único.
     *
     * @param idDireccion Identificador único de la dirección.
     * @return Objeto DireccionDTO con la información de la dirección.
     */
    @Override
    public DireccionDTO obtenerDireccion(int idDireccion) {
        DireccionDTO d = direccion.obtenerDireccion(idDireccion);
        return d;
    }

    /**
     * Actualiza la información de una dirección en el sistema.
     *
     * @param direccion Objeto DireccionDTO con la información actualizada.
     * @param idDireccion Identificador único de la dirección a actualizar.
     * @return `true` si la actualización es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean actualizarDireccion(DireccionDTO direccion, int idDireccion) {
        if (this.direccion.actualizarDireccion(direccion, idDireccion)) {
            return true;
        }
        return false;
    }

    /**
     * Registra una nueva dirección en el sistema.
     *
     * @param direccion Objeto Direccion a registrar.
     * @return `true` si el registro es exitoso, `false` en caso contrario.
     */
    @Override
    public boolean registrarDireccion(Direccion direccion) {
        if (this.direccion.registrarDireccion(direccion)) {
            return true;
        }
        return false;
    }

    /**
     * Autentica un cobro por retiro sin cuenta.
     *
     * @param folio Folio del retiro sin cuenta.
     * @param contraseña Contraseña del retiro sin cuenta.
     * @return `true` si la autenticación es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean autenticarCobro(int folio, int contraseña) {
        if (retiro.autenticarCobro(folio, contraseña)) {
            return true;
        }
        return false;
    }

    /**
     * Genera un retiro sin cuenta en el sistema.
     *
     * @param sin Objeto RetiroSinDTO con la información del retiro sin cuenta.
     * @param num Número de cuenta asociado al retiro sin cuenta.
     * @return `true` si la generación es exitosa, `false` en caso contrario.
     */
    @Override
    public boolean generarSinCuenta(RetiroSinDTO sin, int num) {
        if (retiro.generarSinCuenta(sin, num)) {
            return true;
        }
        return false;
    }

    /**
     * Genera una contraseña aleatoria para retiro sin cuenta.
     *
     * @return Contraseña generada.
     */
    @Override
    public int generarContraseña() {
        int s = retiro.generarContraseña();
        return s;
    }

    /**
     * Actualiza el estado de la cuenta especificada.
     *
     * @param numCuenta Número de cuenta.
     * @throws SQLException Si hay un error al actualizar el estado de la
     * cuenta.
     */
    @Override
    public void actualizarEstado(int numCuenta) throws SQLException {
        try {
            retiro.actualizarEstado(numCuenta);
        } catch (SQLException e) {
            if (e.getMessage().contains("El monto del depósito debe ser mínimo $1 y máximo $10,000.")) {
                JOptionPane.showMessageDialog(null, "El monto del depósito debe ser mínimo $1 y máximo $10,000.", "Error de depósito", JOptionPane.ERROR_MESSAGE);

            } else if (e.getMessage().contains("Los depósitos mayores a $1 deben ser de $100 en $100.")) {
                JOptionPane.showMessageDialog(null, "Los depósitos mayores a $1 deben ser de $100 en $100.", "Error de depósito", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la transferencia o el depósito.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    /**
     * Realiza una transferencia en el sistema.
     *
     * @param trans Objeto TransferenciaDTO con la información de la
     * transferencia.
     * @return Objeto TransferenciaDTO con la información actualizada.
     * @throws SQLException Si hay un error al realizar la transferencia.
     */
    @Override
    public TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) throws SQLException {
        try {
            TransferenciaDTO t = transferencia.realizarTransferencia(trans);
            return t;
        } catch (SQLException e) {
            if (e.getMessage().contains("El monto del depósito debe ser mínimo $1 y máximo $10,000.")) {
                JOptionPane.showMessageDialog(null, "El monto del depósito debe ser mínimo $1 y máximo $10,000.", "Error de depósito", JOptionPane.ERROR_MESSAGE);
                return null;
            } else if (e.getMessage().contains("Los depósitos mayores a $1 deben ser de $100 en $100.")) {
                JOptionPane.showMessageDialog(null, "Los depósitos mayores a $1 deben ser de $100 en $100.", "Error de depósito", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la transferencia o el depósito.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
    }

    /**
     * Obtiene el identificador único de un cliente por su nombre y apellido paterno.
     * 
     * @param nombre Nombre del cliente.
     * @param paterno Apellido paterno del cliente.
     * @return Identificador único del cliente.
     */
    @Override
    public int idCliente(String nombre, String paterno) {
        int idCliente = clienteDAO.idCliente(nombre,paterno);
        return idCliente;
    }

    /**
     * Obtiene el identificador único de una cuenta por su fecha de creación.
     * 
     * @param fecha Fecha de creación de la cuenta.
     * @return Identificador único de la cuenta.
     */
    @Override
    public int idCuenta(String fecha) {
        int idCuenta = cuentaDAO.idCuenta(fecha);
        return idCuenta;
    }

    /**
     * Obtiene el identificador único de una dirección por sus datos.
     * 
     * @param calle Calle de la dirección.
     * @param colonia Colonia de la dirección.
     * @param numero Número de la dirección.
     * @return Identificador único de la dirección.
     */
    @Override
    public int idDireccion(String calle, String colonia, String numero) {
        int idDireccion = direccion.idDireccion(calle, colonia, numero);
        return idDireccion;
    }

    /**
     * Obtiene el identificador único de un usuario por su contraseña y nombre de usuario.
     * 
     * @param contraseña Contraseña del usuario.
     * @param usuario Nombre de usuario.
     * @return Identificador único del usuario.
     */
    @Override
    public int idUsuario(String contraseña, String usuario
    ) {
        int idUsuario = usuario2.idUsuario(contraseña, usuario);
        return idUsuario;
    }

    /**
     * Obtiene el identificador único de un cliente por su identificador único de usuario.
     * 
     * @param idUsuario Identificador único del usuario asociado al cliente.
     * @return Identificador único del cliente.
     */
    @Override
    public int idClienteUsuario(int idUsuario
    ) {
        int idClienteUsuario = clienteDAO.idClienteUsuario(idUsuario);
        return idClienteUsuario;
    }

    /**
     * Obtiene el identificador único de un cliente por su identificador único de dirección.
     * 
     * @param idDireccion Identificador único de la dirección asociada al cliente.
     * @return Identificador único del cliente.
     */
    @Override
    public int idClienteDireccion(int idDireccion
    ) {
        int idClienteDireccion = clienteDAO.idClienteDireccion(idDireccion);
        return idClienteDireccion;
    }

    /**
     * Realiza un depósito en una cuenta.
     * 
     * @param cuenta Número de cuenta.
     * @param monto Monto a depositar.
     * @return `true` si el depósito es exitoso, `false` en caso contrario.
     * @throws SQLException Si hay un error al realizar el depósito.
     */
    public boolean depositar(int cuenta, float monto) throws SQLException {
        try {
            if (transferencia.depositar(cuenta, monto)) {
                return true;
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("El monto del depósito debe ser mínimo $1 y máximo $10,000.")) {
                JOptionPane.showMessageDialog(null, "El monto del depósito debe ser mínimo $1 y máximo $10,000.", "Error de depósito", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (e.getMessage().contains("Los depósitos mayores a $1 deben ser de $100 en $100.")) {
                JOptionPane.showMessageDialog(null, "Los depósitos mayores a $1 deben ser de $100 en $100.", "Error de depósito", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la transferencia o el depósito.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        return false;
    }

    /**
     * Obtiene el identificador único de una cuenta por su número.
     * 
     * @param numCuenta Número de cuenta.
     * @return Identificador único de la cuenta.
     */
    @Override
    public int idCuenta(int numCuenta) {
        int id = cuentaDAO.idCuenta(numCuenta);
        return id;
    }

    /**
     * Agrega una operación al sistema.
     * 
     * @param op Objeto Operaciones con la información de la operación.
     */
    @Override
    public void agregarOperacion(Operaciones op) {
        operacionesDAO.agregarOperacion(op);
    }

    /**
     * Obtiene el identificador único de una operación por su fecha.
     * 
     * @param fecha Fecha de la operación.
     * @return Identificador único de la operación.
     */
    @Override
    public int idOperacion(String fecha) {
        int numero = operacionesDAO.idOperacion(fecha);
        return numero;
    }

    /**
     * Obtiene el folio de un retiro sin cuenta.
     * 
     * @return Folio del retiro sin cuenta.
     */
    @Override
    public int obtenerFolio() {
        int num = retiro.obtenerFolio();
        return num;
    }

    /**
     * Realiza un evento en el sistema.
     */
    @Override
    public void evento() {
        retiro.evento();
    }

    /**
     * Obtiene el identificador único de un retiro sin cuenta por su folio y contraseña.
     * 
     * @param folio Folio del retiro sin cuenta.
     * @param contraseña Contraseña del retiro sin cuenta.
     * @return Identificador único del retiro sin cuenta.
     */
    @Override
    public int idRetiro(int folio, int contraseña) {
        int num = retiro.idRetiro(folio, contraseña);
        return num;
    }

    /**
     * Obtiene el historial de transferencias realizadas en un rango de fechas.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos Transferencia con el historial de transferencias.
     */
    @Override
    public List<Transferencia> obtenerHistorialTransferencia(String desde, String hasta) {
        List<Transferencia> c = operacionesDAO.obtenerHistorialTransferencia(desde, hasta);
        return c;
    }

    /**
     * Obtiene el historial de retiros sin cuenta realizados en un rango de fechas.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos SinCuenta con el historial de retiros sin cuenta.
     */
    @Override
    public List<SinCuenta> obtenerHistorialSinCuenta(String desde, String hasta) {
        List<SinCuenta> c = operacionesDAO.obtenerHistorialSinCuenta(desde, hasta);
        return c;
    }

    /**
     * Obtiene el historial completo de retiros sin cuenta.
     * 
     * @return Lista de objetos SinCuenta con el historial completo de retiros sin cuenta.
     */
    @Override
    public List<SinCuenta> obtenerTodaSInCuenta() {
        List<SinCuenta> c = operacionesDAO.obtenerTodaSInCuenta();
        return c;
    }

    /**
     * Obtiene el historial completo de transferencias realizadas.
     * 
     * @return Lista de objetos Transferencia con el historial completo de transferencias.
     */
    @Override
    public List<Transferencia> obtenerTodasTransferencia() {
        List<Transferencia> c = operacionesDAO.obtenerTodasTransferencia();
        return c;
    }
}

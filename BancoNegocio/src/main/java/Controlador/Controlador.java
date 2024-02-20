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
import DTO.OperacionesDTO;
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
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
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

    @Override
    public boolean autenticarUsuario(String usuario, String contraseña) {
        if (usuario2.autenticarUsuario(usuario, contraseña)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        if (usuario2.registrarUsuario(usuario)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarUsuario(UsuariosDTO usuario, int idUsuario) {
        if (usuario2.actualizarUsuario(usuario, idUsuario)) {
            return true;
        }
        return false;
    }

    @Override
    public ClienteDTO obtenerCliente(int idCliente) throws PersistenciaExcepcion {
        ClienteDTO c = clienteDAO.obtenerCliente(idCliente);
        return c;
    }

    @Override
    public boolean actualizarCliente(ClienteDTO cliente, int idCliente) throws PersistenciaExcepcion {
        if (clienteDAO.actualizarCliente(cliente, idCliente)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registrarCliente(Cliente cliente) throws PersistenciaExcepcion {
        if (clienteDAO.registrarCliente(cliente)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Cuenta> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion {
        List<Cuenta> c = clienteDAO.obtenerCuentasCliente(idCliente);
        return c;
    }

    @Override
    public CuentaDTO obtenerCuenta(int numeroCuenta) {
        CuentaDTO c = cuentaDAO.obtenerCuenta(numeroCuenta);
        return c;
    }

    @Override
    public int numeroCuenta(Cuenta cuenta) {
        int c = cuentaDAO.numeroCuenta(cuenta);
        return c;
    }

    @Override
    public boolean actualizarEstadoCuenta(int cuenta) {
        if (cuentaDAO.actualizarEstadoCuenta(cuenta)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean crearCuenta(Cuenta cuenta, int num) {
        if (cuentaDAO.crearCuenta(cuenta, num)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean crearCuentaNueva(Cuenta cuenta, int id, int num) {
        if (cuentaDAO.crearCuentaNueva(cuenta, id, num)) {
            return true;
        }
        return false;
    }

    @Override
    public void sumarMonto(int cuenta, float monto) {
        sumarMonto(cuenta, monto);
    }

    @Override
    public DireccionDTO obtenerDireccion(int idDireccion) {
        DireccionDTO d = direccion.obtenerDireccion(idDireccion);
        return d;
    }

    @Override
    public boolean actualizarDireccion(DireccionDTO direccion, int idDireccion) {
        if (this.direccion.actualizarDireccion(direccion, idDireccion)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registrarDireccion(Direccion direccion) {
        if (this.direccion.registrarDireccion(direccion)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean autenticarCobro(int folio, int contraseña) {
        if (retiro.autenticarCobro(folio, contraseña)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean generarSinCuenta(RetiroSinDTO sin, int num) {
        if (retiro.generarSinCuenta(sin, num)) {
            return true;
        }
        return false;
    }

    @Override
    public int generarContraseña() {
        int s = retiro.generarContraseña();
        return s;
    }

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

        @Override
        public TransferenciaDTO realizarTransferencia
        (TransferenciaDTO trans) throws SQLException
        {
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

        @Override
        public int idCliente
        (String nombre, String Paterno
        
            ) {
        int idCliente = clienteDAO.idCliente(nombre, Paterno);
            return idCliente;
        }

        @Override
        public int idCuenta
        (String Fecha
        
            ) {
        int idCuenta = cuentaDAO.idCuenta(Fecha);
            return idCuenta;
        }

        @Override
        public int idDireccion
        (String calle, String colonia
        , String numero
        
            ) {
        int idDireccion = direccion.idDireccion(calle, colonia, numero);
            return idDireccion;
        }

        @Override
        public int idUsuario
        (String contraseña, String Usuario
        
            ) {
        int idUsuario = usuario2.idUsuario(contraseña, Usuario);
            return idUsuario;
        }

        @Override
        public int idClienteUsuario
        (int idUsuario
        
            ) {
        int idClienteUsuario = clienteDAO.idClienteUsuario(idUsuario);
            return idClienteUsuario;
        }

        @Override
        public int idClienteDireccion
        (int idDireccion
        
            ) {
        int idClienteDireccion = clienteDAO.idClienteDireccion(idDireccion);
            return idClienteDireccion;
        }

    

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

    @Override
    public int idCuenta(int numCuenta) {
        int id = cuentaDAO.idCuenta(numCuenta);
        return id;
    }

    @Override
    public void agregarOperacion(Operaciones op) {
        operacionesDAO.agregarOperacion(op);
    }

    @Override
    public int idOperacion(String Fecha) {
        int numero = operacionesDAO.idOperacion(Fecha);
        return numero;
    }

    @Override
    public int obtenerFolio() {
        int num = retiro.obtenerFolio();
        return num;
    }

    @Override
    public void evento() {
        retiro.evento();
    }

    @Override
    public int idRetiro(int folio, int contraseña) {
        int num = retiro.idRetiro(folio, contraseña);
        return num;
    }

    @Override
    public List<Transferencia> obtenerHistorialTransferencia(String desde, String hasta) {
        List<Transferencia> c = operacionesDAO.obtenerHistorialTransferencia(desde, hasta);
        return c;
    }

    @Override
    public List<SinCuenta> obtenerHistorialSinCuenta(String desde, String hasta) {
        List<SinCuenta> c = operacionesDAO.obtenerHistorialSinCuenta(desde, hasta);
        return c;
    }

    @Override
    public List<SinCuenta> obtenerTodaSInCuenta() {
        List<SinCuenta> c = operacionesDAO.obtenerTodaSInCuenta();
        return c;
    }

    @Override
    public List<Transferencia> obtenerTodasTransferencia() {
        List<Transferencia> c = operacionesDAO.obtenerTodasTransferencia();
        return c;
    }
}

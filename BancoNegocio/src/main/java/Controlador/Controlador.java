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
import Entidades.SinCuenta;
import Entidades.Usuario;
import Excepciones.PersistenciaExcepcion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lv1821
 */
public class Controlador implements IControlador{

    String cadenaConexion = "jdbc:mysql://localhost:3306/Asignacion01";
    String usuario = "root";
    String contrasenia = "2608jlml";
    IConexion conexionBD = new Conexion(cadenaConexion, usuario, contrasenia);
    IClienteDAO cliente = new ClienteDAO(conexionBD);
    ICuentaDAO cuenta = new CuentaDAO(conexionBD);
    IDireccionDAO direccion = new DireccionDAO(conexionBD);
    IOperacionesDAO operaciones = new OperacionesDAO(conexionBD);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuariosDTO actualizarUsuario(UsuariosDTO usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO obtenerCliente(int idCliente) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO cliente) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean registrarCliente(Cliente cliente) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cuenta> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuentaDTO obtenerCuenta(int numeroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int numeroCuenta(Cuenta cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarEstadoCuenta(int cuenta, int contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta crearCuentaNueva(Cuenta cuenta, int contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sumarMonto(int cuenta, float monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DireccionDTO obtenerDireccion(int idDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DireccionDTO actualizarDireccion(DireccionDTO direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean registrarDireccion(Direccion direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, Date desde, Date hasta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean autenticarCobro(String folio, int contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SinCuenta generarSinCuenta(RetiroSinDTO sin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String generarFolio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int generarContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarEstado(int numCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

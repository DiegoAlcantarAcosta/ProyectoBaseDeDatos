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
public class Controlador implements IControlador {

    String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    String usuario = "root";
    String contrasenia = "2608jlml";
    IConexion conexionBD = new Conexion(cadenaConexion, usuario, contrasenia);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
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
        if (usuario2.registrarUsuario(usuario)) {
            return true;
        }
        return false;
    }

    @Override
    public UsuariosDTO actualizarUsuario(UsuariosDTO usuario) {
        UsuariosDTO u = usuario2.actualizarUsuario(usuario);
        return u;
    }

    @Override
    public ClienteDTO obtenerCliente(int idCliente) throws PersistenciaExcepcion {
        ClienteDTO c = clienteDAO.obtenerCliente(idCliente);
        return c;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO cliente) throws PersistenciaExcepcion {
        ClienteDTO c = actualizarCliente(cliente);
        return c;
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
        List<Cuenta> c = obtenerCuentasCliente(idCliente);
        return c;
    }

    @Override
    public CuentaDTO obtenerCuenta(int numeroCuenta) {
        CuentaDTO c = obtenerCuenta(numeroCuenta);
        return c;
    }

    @Override
    public int numeroCuenta(Cuenta cuenta) {
        int c = numeroCuenta(cuenta);
        return c;
    }

    @Override
    public boolean actualizarEstadoCuenta(int cuenta, int contraseña) {
        if (cuentaDAO.actualizarEstadoCuenta(cuenta, contraseña)) {
            return true;
        }
        return false;
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        Cuenta c = crearCuenta(cuenta);
        return c;
    }

    @Override
    public Cuenta crearCuentaNueva(Cuenta cuenta, int contraseña) {
        Cuenta c = crearCuentaNueva(cuenta, contraseña);
        return c;
    }

    @Override
    public void sumarMonto(int cuenta, float monto) {
        sumarMonto(cuenta, monto);
    }

    @Override
    public DireccionDTO obtenerDireccion(int idDireccion) {
        DireccionDTO d = obtenerDireccion(idDireccion);
        return d;
    }

    @Override
    public DireccionDTO actualizarDireccion(DireccionDTO direccion) {
        DireccionDTO d = actualizarDireccion(direccion);
        return d;
    }

    @Override
    public boolean registrarDireccion(Direccion direccion) {
        if (this.direccion.registrarDireccion(direccion)) {
            return true;
        }
        return false;
    }

    @Override
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, Date desde, Date hasta) {
        List<OperacionesDTO> o = obtenerHistorialOperaciones(numeroCuenta, desde, hasta);
        return o;
    }

    @Override
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, String tipo) {
        List<OperacionesDTO> o = obtenerHistorialOperaciones(numeroCuenta, tipo);
        return o;
    }

    @Override
    public boolean autenticarCobro(String folio, int contraseña) {
        if (retiro.autenticarCobro(folio, contraseña)) {
            return true;
        }
        return false;
    }

    @Override
    public SinCuenta generarSinCuenta(RetiroSinDTO sin) {
        SinCuenta s = generarSinCuenta(sin);
        return s;
    }

    @Override
    public String generarFolio() {
        String s = retiro.generarFolio();
        return s;
    }

    @Override
    public int generarContraseña() {
        int s = retiro.generarContraseña();
        return s;
    }

    @Override
    public boolean actualizarEstado(int numCuenta) {
        if (retiro.actualizarEstado(numCuenta)) {
            return true;
        }
        return false;
    }

    @Override
    public TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) {
        TransferenciaDTO t = realizarTransferencia(trans);
        return t;
    }

}

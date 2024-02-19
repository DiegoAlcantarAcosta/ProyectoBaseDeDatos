/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

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
import Entidades.Usuario;
import Excepciones.PersistenciaExcepcion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lv1821
 */
public interface IControlador {
    boolean autenticarUsuario(String usuario, String contraseña);
    public boolean registrarUsuario(Usuario usuario);
    boolean actualizarUsuario(UsuariosDTO usuario, int idUsuario);
    ClienteDTO obtenerCliente(int idCliente)  throws PersistenciaExcepcion;
    boolean actualizarCliente(ClienteDTO cliente, int idCliente)  throws PersistenciaExcepcion;
    boolean registrarCliente(Cliente cliente)  throws PersistenciaExcepcion;
    List<Cuenta> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion;
    CuentaDTO obtenerCuenta(int numeroCuenta);

    int numeroCuenta(Cuenta cuenta);

    boolean actualizarEstadoCuenta(int cuenta);

    boolean crearCuenta(Cuenta cuenta, int num);
    
    boolean crearCuentaNueva(Cuenta cuenta, int id,int num);

    int idClienteUsuario(int idUsuario);
    int idClienteDireccion(int idDireccion);
    
    void sumarMonto(int cuenta,float monto);
    DireccionDTO obtenerDireccion(int idDireccion);
    boolean actualizarDireccion(DireccionDTO direccion, int idDireccion);
    boolean registrarDireccion(Direccion direccion);
    public boolean autenticarCobro(int folio, int contraseña);
    public boolean generarSinCuenta(RetiroSinDTO sin,int num);
    public int generarContraseña();
    public void actualizarEstado(int numCuenta);
    TransferenciaDTO realizarTransferencia(TransferenciaDTO trans);
    int idCliente(String nombre, String Paterno);
    int idCuenta(String Fecha);
    int idDireccion(String calle, String colonia, String numero);
    int idUsuario(String contraseña, String Usuario);
    public int idCuenta(int numCuenta);
    public void agregarOperacion(Operaciones op);
    public int idOperacion (String Fecha);
    public int obtenerFolio();
    public void evento();
    public int idRetiro(int folio, int contraseña);
}

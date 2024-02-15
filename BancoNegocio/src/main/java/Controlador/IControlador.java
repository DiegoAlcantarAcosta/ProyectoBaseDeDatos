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
    UsuariosDTO actualizarUsuario(UsuariosDTO usuario);
    ClienteDTO obtenerCliente(int idCliente)  throws PersistenciaExcepcion;
    ClienteDTO actualizarCliente(ClienteDTO cliente)  throws PersistenciaExcepcion;
    boolean registrarCliente(Cliente cliente)  throws PersistenciaExcepcion;
    List<Cuenta> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion;
    CuentaDTO obtenerCuenta(int numeroCuenta);

    int numeroCuenta(Cuenta cuenta);

    boolean actualizarEstadoCuenta(int cuenta, int contraseña);

    Cuenta crearCuenta(Cuenta cuenta);
    
    Cuenta crearCuentaNueva(Cuenta cuenta, int contraseña);

    void sumarMonto(int cuenta,float monto);
    DireccionDTO obtenerDireccion(int idDireccion);
    DireccionDTO actualizarDireccion(DireccionDTO direccion);
    boolean registrarDireccion(Direccion direccion);
    List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, Date desde, Date hasta);
    List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, String tipo);
    public boolean autenticarCobro(String folio, int contraseña);
    public SinCuenta generarSinCuenta(RetiroSinDTO sin);
    public String generarFolio();
    public int generarContraseña();
    public boolean actualizarEstado(int numCuenta);
    TransferenciaDTO realizarTransferencia(TransferenciaDTO trans);
}

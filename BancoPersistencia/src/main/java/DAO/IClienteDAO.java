/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.ClienteDTO;
import Entidades.Cliente;
import Entidades.Cuenta;
import Excepciones.PersistenciaExcepcion;
import java.util.List;

/**
 * La interfaz IClienteDAO define las operaciones de acceso a datos relacionadas
 * con la entidad Cliente en la base de datos. Proporciona métodos para obtener
 * detalles de clientes, actualizar información de clientes, registrar nuevos
 * clientes y obtener listas de cuentas asociadas a un cliente.
 * 
 * @author lv1821
 */
public interface IClienteDAO {
    /**
     * Obtiene los detalles de un cliente basándose en su ID.
     * 
     * @param idCliente ID del cliente a consultar.
     * @return DTO con los detalles del cliente.
     * @throws PersistenciaExcepcion Excepción que indica un error en la persistencia de datos.
     */
    ClienteDTO obtenerCliente(int idCliente)  throws PersistenciaExcepcion;
    
    /**
     * Actualiza la información de un cliente existente en la base de datos.
     * 
     * @param cliente DTO con los nuevos detalles del cliente.
     * @param idCliente ID del cliente a actualizar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     * @throws PersistenciaExcepcion Excepción que indica un error en la persistencia de datos.
     */
    boolean actualizarCliente(ClienteDTO cliente, int idCliente)  throws PersistenciaExcepcion;
    
    /**
     * Registra un nuevo cliente en la base de datos.
     * 
     * @param cliente Instancia de la entidad Cliente a registrar.
     * @return true si el registro fue exitoso, false en caso contrario.
     * @throws PersistenciaExcepcion Excepción que indica un error en la persistencia de datos.
     */
    boolean registrarCliente(Cliente cliente)  throws PersistenciaExcepcion;
    
    /**
     * Obtiene una lista de cuentas asociadas a un cliente.
     * 
     * @param idCliente ID del cliente del cual se desean obtener las cuentas.
     * @return Lista de cuentas asociadas al cliente.
     * @throws PersistenciaExcepcion Excepción que indica un error en la persistencia de datos.
     */
    List<Cuenta> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion;
    
    /**
     * Obtiene el ID de un cliente basándose en su nombre y apellido paterno.
     * 
     * @param nombre Nombre del cliente.
     * @param paterno Apellido paterno del cliente.
     * @return ID del cliente o -1 si no se encuentra.
     */
    int idCliente(String nombre, String paterno);
    
    /**
     * Obtiene el ID de un cliente basándose en su ID de usuario.
     * 
     * @param idUsuario ID del usuario asociado al cliente.
     * @return ID del cliente o -1 si no se encuentra.
     */
    int idClienteUsuario (int idUsuario);
    
    /**
     * Obtiene el ID de un cliente basándose en su ID de dirección.
     * 
     * @param idDireccion ID de la dirección asociada al cliente.
     * @return ID del cliente o -1 si no se encuentra.
     */
    int idClienteDireccion (int idDireccion);
}

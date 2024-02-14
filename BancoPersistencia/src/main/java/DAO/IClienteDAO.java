/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.ClienteDTO;
import DTO.CuentaDTO;
import Entidades.Cliente;
import Entidades.Cuenta;
import Excepciones.PersistenciaExcepcion;
import java.util.List;

/**
 *
 * @author lv1821
 */
public interface IClienteDAO {
    Cliente obtenerCliente(int idCliente)  throws PersistenciaExcepcion;
    ClienteDTO actualizarCliente(ClienteDTO cliente)  throws PersistenciaExcepcion;
    boolean registrarCliente(Cliente cliente)  throws PersistenciaExcepcion;
    List<CuentaDTO> obtenerCuentasCliente(int idCliente) throws PersistenciaExcepcion;
}

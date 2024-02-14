/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.ClienteDTO;
import Entidades.Cliente;
import Entidades.Cuenta;
import java.util.List;

/**
 *
 * @author lv1821
 */
public interface IClienteDAO {
    Cliente obtenerCliente(int idCliente);
    ClienteDTO actualizarCliente(ClienteDTO cliente);
    boolean registrarCliente(Cliente cliente);
    List<Cuenta> obtenerCuentasCliente(int idCliente);
}

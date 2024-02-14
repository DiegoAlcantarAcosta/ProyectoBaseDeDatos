/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Cliente;

/**
 *
 * @author lv1821
 */
public interface IClienteDAO {
    Cliente obtenerCliente(int idCliente);
    boolean actualizarCliente(Cliente cliente);
    boolean registrarCliente(Cliente cliente);
}

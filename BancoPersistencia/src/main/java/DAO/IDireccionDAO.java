/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.DireccionDTO;
import Entidades.Direccion;

/**
 *
 * @author lv1821
 */
public interface IDireccionDAO {
    Direccion obtenerDireccion(int idCliente);
    DireccionDTO actualizarDireccion(DireccionDTO direccion);
    boolean registrarDireccion(Direccion direccion);
}

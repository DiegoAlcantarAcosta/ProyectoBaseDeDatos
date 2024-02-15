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
    DireccionDTO obtenerDireccion(int idDireccion);
    boolean actualizarDireccion(DireccionDTO direccion, int idDireccion);
    boolean registrarDireccion(Direccion direccion);
    int idDireccion(String calle, String colonia, String numero);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.OperacionesDTO;
import Entidades.Operaciones;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lv1821
 */
public interface IOperacionesDAO {
    
    List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, Date desde, Date hasta);
    List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, String tipo);
}

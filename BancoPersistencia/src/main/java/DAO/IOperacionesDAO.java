/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Operaciones;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author lv1821
 */
public interface IOperacionesDAO {
    
    List<Operaciones> obtenerHistorialOperaciones(int numeroCuenta, Date desde, Date hasta);
    List<Operaciones> obtenerHistorialOperaciones(int numeroCuenta, String tipo);
}

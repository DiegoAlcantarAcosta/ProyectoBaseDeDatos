/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.OperacionesDTO;
import Entidades.Operaciones;
import Entidades.SinCuenta;
import Entidades.Transferencia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lv1821
 */
public interface IOperacionesDAO {
    
    List<Transferencia> obtenerHistorialTransferencia(String tipo, Date desde, Date hasta);
    List<SinCuenta> obtenerHistorialSinCuenta(String tipo, Date desde, Date hasta);
    List<SinCuenta> obtenerHistorialTodos(String tipo, Date desde, Date hasta);
   public void agregarOperacion(Operaciones op);
   public int idOperacion (String Fecha);
}

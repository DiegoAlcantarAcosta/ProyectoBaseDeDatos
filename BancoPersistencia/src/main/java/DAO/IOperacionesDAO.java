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
    
    List<Transferencia> obtenerHistorialTransferencia(String desde, String hasta);
    List<SinCuenta> obtenerHistorialSinCuenta(String desde, String hasta);
    List<SinCuenta> obtenerTodaSInCuenta();
   public void agregarOperacion(Operaciones op);
   public int idOperacion (String Fecha);
   List<Transferencia> obtenerTodasTransferencia();
}

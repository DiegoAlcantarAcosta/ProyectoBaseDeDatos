/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Operaciones;
import Entidades.SinCuenta;
import Entidades.Transferencia;
import java.util.List;

/**
 * Interface que define las operaciones de acceso a datos para las operaciones financieras.
 * Las clases que implementen esta interfaz proporcionarán la lógica para interactuar
 * con la capa de persistencia y obtener información sobre las operaciones realizadas.
 *
 * @author lv1821
 */
public interface IOperacionesDAO {
    
    /**
     * Obtiene el historial de transferencias realizadas en un rango de fechas.
     *
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos de tipo Transferencia que representan las transferencias realizadas.
     */
    List<Transferencia> obtenerHistorialTransferencia(String desde, String hasta);
    
    /**
     * Obtiene el historial de retiros sin cuenta realizados en un rango de fechas.
     *
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos de tipo SinCuenta que representan los retiros sin cuenta realizados.
     */
    List<SinCuenta> obtenerHistorialSinCuenta(String desde, String hasta);
    
    /**
     * Obtiene el historial completo de retiros sin cuenta realizados.
     *
     * @return Lista de objetos de tipo SinCuenta que representan todos los retiros sin cuenta realizados.
     */
    List<SinCuenta> obtenerTodaSInCuenta();
    
    /**
     * Agrega una nueva operación financiera a la base de datos.
     *
     * @param op Objeto de tipo Operaciones que representa la nueva operación financiera.
     */
   public void agregarOperacion(Operaciones op);
   
   /**
     * Obtiene el ID de una operación mediante su fecha.
     *
     * @param fecha Fecha de la operación.
     * @return ID de la operación asociada a la fecha especificada.
     */
   public int idOperacion (String fecha);
   
   /**
     * Obtiene el historial completo de transferencias realizadas.
     *
     * @return Lista de objetos de tipo Transferencia que representan todas las transferencias realizadas.
     */
   List<Transferencia> obtenerTodasTransferencia();
}

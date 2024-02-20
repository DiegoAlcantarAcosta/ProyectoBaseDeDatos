/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.DireccionDTO;
import Entidades.Direccion;

/**
 * Interface que define las operaciones de acceso a datos para las direcciones.
 * Las clases que implementen esta interfaz proporcionarán la lógica para interactuar
 * con la capa de persistencia y obtener información sobre las direcciones.
 *
 * @author lv1821
 */
public interface IDireccionDAO {
    
    /**
     * Obtiene la información de una dirección mediante su ID.
     *
     * @param idDireccion ID de la dirección.
     * @return Objeto de tipo DireccionDTO que contiene la información de la dirección.
     */
    DireccionDTO obtenerDireccion(int idDireccion);
    
    /**
     * Actualiza la información de una dirección.
     *
     * @param direccion Objeto de tipo DireccionDTO con la información actualizada.
     * @param idDireccion ID de la dirección que se desea actualizar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    boolean actualizarDireccion(DireccionDTO direccion, int idDireccion);
    
    /**
     * Registra una nueva dirección en la base de datos.
     *
     * @param direccion Objeto de tipo Direccion que se desea registrar.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    boolean registrarDireccion(Direccion direccion);
    /**
     * Obtiene el ID de una dirección mediante su calle, colonia y número.
     *
     * @param calle Calle de la dirección.
     * @param colonia Colonia de la dirección.
     * @param numero Número de la dirección.
     * @return ID de la dirección asociada a la calle, colonia y número especificados.
     */
    
    int idDireccion(String calle, String colonia, String numero);
}

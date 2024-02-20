/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que define el contrato para la creación de conexiones a la base de
 * datos. Las implementaciones de esta interfaz deben proporcionar un método
 * para establecer una conexión.
 *
 * @author lv1821
 */
public interface IConexion {

    /**
     * Crea y devuelve una conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la
     * conexión.
     */
    public Connection crearConexion() throws SQLException;
}

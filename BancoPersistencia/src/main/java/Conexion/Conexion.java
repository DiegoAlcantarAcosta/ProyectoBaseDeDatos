/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz IConexion que proporciona métodos para establecer la conexión a la base de datos.
 * Utiliza la API JDBC para interactuar con la base de datos MySQL.
 * 
 * @author lv1821
 */
public class Conexion implements IConexion {
     final String url;
    final String usuario;
    final String contra;
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());
    
    /**
     * Constructor de la clase Conexion.
     * 
     * @param url URL de conexión a la base de datos.
     * @param usuario Nombre de usuario para la conexión.
     * @param contra Contraseña para la conexión.
     */
    public Conexion(String url, String usuario, String contra) {
        this.url = url;
        this.usuario = usuario;
        this.contra = contra;
    }

    /**
     * Crea y devuelve una conexión a la base de datos utilizando la URL, el usuario y la contraseña especificados.
     * 
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    @Override
    public Connection crearConexion() throws SQLException {
       Connection conexion= DriverManager.getConnection(url, usuario, contra);
        LOG.log(java.util.logging.Level.INFO, "Conexion establecida {0}", url);
        return conexion;
    }
}

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
 *
 * @author lv1821
 */
public class Conexion implements IConexion {
     final String url;
    final String usuario;
    final String contra;
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());
    
    public Conexion(String url, String usuario, String contra) {
        this.url = url;
        this.usuario = usuario;
        this.contra = contra;
    }

    @Override
    public Connection crearConexion() throws SQLException {
       Connection conexion= DriverManager.getConnection(url, usuario, contra);
        LOG.log(java.util.logging.Level.INFO, "Conexion establecida {0}", url);
        return conexion;
    }
}

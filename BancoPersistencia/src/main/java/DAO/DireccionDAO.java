/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.DireccionDTO;
import Entidades.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz IDireccionDAO que proporciona operaciones de acceso
 * a datos relacionadas con la entidad Direccion en la base de datos.
 * 
 * @author lv1821
 */
public class DireccionDAO implements IDireccionDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Constructor que acepta una instancia de IConexion para establecer la conexión a la base de datos.
     * 
     * @param conexionBD Instancia de IConexion para la conexión a la base de datos.
     */
    public DireccionDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene los detalles de una dirección basándose en el ID de la dirección.
     * 
     * @param idDireccion ID de la dirección.
     * @return DTO con los detalles de la dirección o null si no se encuentra.
     */
    @Override
    public DireccionDTO obtenerDireccion(int idDireccion) {
        String sentencia = "SELECT * FROM DIRECCIONES WHERE idDireccion = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setInt(1, idDireccion);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idDireccion");
                String calle = resultado.getString("calle");
                String colonia = resultado.getString("colonia");
                String numero = resultado.getString("numero");
                String codigoPostal = resultado.getString("codigoPostal");

                DireccionDTO direccion = new DireccionDTO(calle, colonia, numero, codigoPostal);
                LOG.log(Level.INFO, "Se consultaron {0}");
                return direccion;
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
        }
        return null;
    }

    /**
     * Actualiza los detalles de una dirección basándose en el ID de la dirección.
     * 
     * @param direccion DTO con los nuevos detalles de la dirección.
     * @param idDireccion ID de la dirección a actualizar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    @Override
    public boolean actualizarDireccion(DireccionDTO direccion, int idDireccion) {
        String sentenciaSQL = "UPDATE DIRECCIONES SET calle = ?, colonia = ?, numero = ?, codigoPostal = ? WHERE idDireccion = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, direccion.getCalle());
            comandoSQL.setString(2, direccion.getColonia());
            comandoSQL.setString(3, direccion.getNumero());
            comandoSQL.setString(4, direccion.getCodigoPostal());
            comandoSQL.setInt(5, idDireccion);
      
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se ha actualizado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar la direccion");
            return false;
        }
    }

    /**
     * Registra una nueva dirección en la base de datos.
     * 
     * @param direccion Instancia de la entidad Direccion a registrar.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    @Override
    public boolean registrarDireccion(Direccion direccion) {
        String sentenciaSQL = "INSERT INTO DIRECCIONES (calle,colonia,numero, codigoPostal) VALUES (?,?,?,?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, direccion.getCalle());
            comandoSQL.setString(2, direccion.getColonia());
            comandoSQL.setString(3, direccion.getNumero());
            comandoSQL.setString(4, direccion.getCodigoPostal());

            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha registrado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la direccion");
            System.out.println("No se pudo registrar la direccion" + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene el ID de una dirección basándose en la calle, colonia y número.
     * 
     * @param calle Nombre de la calle.
     * @param colonia Nombre de la colonia.
     * @param numero Número de la dirección.
     * @return El ID de la dirección o -1 si no se encuentra.
     */
    @Override
    public int idDireccion(String calle, String colonia, String numero) {
        int idCliente = -1;
        String sentenciaSQL = "SELECT idDireccion FROM Direcciones WHERE calle = ? and colonia = ? and numero = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, calle);
            comandoSQL.setString(2, colonia);
            comandoSQL.setString(3, numero);
            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idDireccion");
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);

        }
        return idCliente;
    }
}

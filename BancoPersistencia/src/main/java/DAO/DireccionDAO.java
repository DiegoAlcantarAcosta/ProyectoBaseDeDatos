/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.CuentaDTO;
import DTO.DireccionDTO;
import Entidades.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lv1821
 */
public class DireccionDAO implements IDireccionDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public DireccionDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

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
                return direccion;
            }
            LOG.log(Level.INFO, "Se consultaron {0}");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
        }
        return null;
    }

    @Override
    public DireccionDTO actualizarDireccion(DireccionDTO direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
}
   

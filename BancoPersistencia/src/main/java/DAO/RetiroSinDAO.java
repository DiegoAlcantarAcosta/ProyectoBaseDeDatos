/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.RetiroSinDTO;
import Entidades.SinCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class RetiroSinDAO implements IRetiroSinDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public RetiroSinDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public boolean autenticarCobro(int folio, int contraseña) {
        String sentencia = "SELECT * FROM sincuentas WHERE folio = ? and contraseña = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setInt(1, folio);
            comandoSQL.setInt(2, contraseña);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int nombreUsuario = resultado.getInt("folio");
                int contra = resultado.getInt("contraseña");

                if (nombreUsuario == folio && contra == contraseña) {
                    return true;
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
        }
        return false;
    }

    @Override
    public boolean generarSinCuenta(RetiroSinDTO sin, int num) {
        String sentenciaSQL = "INSERT INTO sincuentas (folio,contraseña,idOperacion) VALUES (?,?,?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setInt(1, sin.getFolio());
            comandoSQL.setInt(2, sin.getContraseña());
            comandoSQL.setInt(3, num);
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el retiro", e);
            return false;
        }
        return true;
    }

    @Override
    public int generarContraseña() {
        Random random = new Random();
        int numero = 10000000 + random.nextInt(90000000);
        return numero;
    }

    @Override
    public boolean actualizarEstado(int numCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int obtenerFolio() {
        int idCliente = -1;
        String sentenciaSQL = "SELECT MAX(folio) AS folio FROM sincuentas";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("folio");
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo obtener el folio", e);

        }
        return idCliente;
    }

    public void evento() {
        String sentenciaSQL = "CALL programar_verificacion_retiro_sin_cuenta()";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            ResultSet resultado = comandoSQL.executeQuery();
//            TransferenciaDTO tra = new TransferenciaDTO(trans.getIdCuenta(), trans.getIdCuentaDestino(), "TRANSFERENCIA", trans.getFecha(),trans.getMonto());
            LOG.log(Level.INFO, "Se llamo {0}");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentenciaSQL, e);
         
        }
   
    }

}

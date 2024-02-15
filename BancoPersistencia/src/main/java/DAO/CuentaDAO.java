/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.CuentaDTO;
import DTO.DireccionDTO;
import Entidades.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lv1821
 */
public class CuentaDAO implements ICuentaDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public CuentaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public CuentaDTO obtenerCuenta(int numeroCuenta) {
        String sentencia = "SELECT * FROM CUENTAS WHERE idCliente = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setInt(1, numeroCuenta);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int numCuenta = resultado.getInt("numCuenta");
                float saldo = resultado.getFloat("saldo");
                String fechaApertura = resultado.getString("fechaApertura");
                String estado = resultado.getString("estado");
                int idCliente = resultado.getInt("idCliente");

                CuentaDTO cuenta = new CuentaDTO(saldo, fechaApertura, estado);
                return cuenta;
            }
            LOG.log(Level.INFO, "Se consultaron {0}");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
        }
        return null;
    }

    @Override
    public int numeroCuenta(Cuenta cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarEstadoCuenta(int cuenta, int contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean crearCuenta(Cuenta cuenta) {
        String sentenciaSQL = "INSERT INTO CUENTAS (saldo,fechaApertura,idCliente) VALUES (?,?,?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setFloat(1, cuenta.getSaldo());
            comandoSQL.setString(2, cuenta.getFechaApertura());
            comandoSQL.setInt(3, cuenta.getIdCliente());
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            
            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            return false;
        }
    }

    @Override
    public Cuenta crearCuentaNueva(Cuenta cuenta, int contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sumarMonto(int cuenta, float monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int idCuenta(String Fecha) {
        int idCliente = -1;
        String sentenciaSQL = "SELECT numCuenta FROM Cuentas WHERE fechaApertura = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, Fecha);
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("numCuenta");
                }
            }
            
        }catch(SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            
        }
        return idCliente;
    }
    
        
    }
    


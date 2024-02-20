/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.CuentaDTO;
import Entidades.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz ICuentaDAO que proporciona operaciones de acceso
 * a datos relacionadas con la entidad Cuenta en la base de datos.
 * 
 * @author lv1821
 */
public class CuentaDAO implements ICuentaDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Constructor que acepta una instancia de IConexion para establecer la conexión a la base de datos.
     * 
     * @param conexionBD Instancia de IConexion para la conexión a la base de datos.
     */
    public CuentaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene los detalles de una cuenta basado en el número de cuenta.
     * 
     * @param numeroCuenta Número de cuenta.
     * @return Objeto CuentaDTO que contiene los detalles de la cuenta o null si no se encuentra.
     */
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

    /**
     * Obtiene el número de cuenta asociado a una cuenta.
     * 
     * @param cuenta Objeto Cuenta.
     * @return El número de cuenta o -1 si no se encuentra.
     */
    @Override
    public int numeroCuenta(Cuenta cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Actualiza el estado de una cuenta a 'CANCELADA' basado en el número de cuenta.
     * 
     * @param cuenta Número de cuenta.
     * @return True si la actualización fue exitosa, False si falló.
     */
    @Override
    public boolean actualizarEstadoCuenta(int cuenta) {
        String sentenciaSQL = "UPDATE CUENTAS SET estado = ? WHERE numCuenta = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, "CANCELADA");
            comandoSQL.setInt(2, cuenta);

            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se ha actualizado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente");
            return false;
        }
    }

    /**
     * Crea una nueva cuenta con la información proporcionada.
     * 
     * @param cuenta Objeto Cuenta con la información para la nueva cuenta.
     * @param num Número de cuenta a asignar.
     * @return True si la creación fue exitosa, False si falló.
     */
    @Override
    public boolean crearCuenta(Cuenta cuenta, int num) {
        String sentenciaSQL = "INSERT INTO CUENTAS (numCuenta,saldo,fechaApertura,idCliente) VALUES (?,?,?,?)";
        cuenta.setNumCuenta(num);
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            comandoSQL.setInt(1, num);
            comandoSQL.setFloat(2, cuenta.getSaldo());
            comandoSQL.setString(3, cuenta.getFechaApertura());
            comandoSQL.setInt(4, cuenta.getIdCliente());
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

    /**
     * Crea una nueva cuenta asociada a un cliente con la información proporcionada.
     * 
     * @param cuenta Objeto Cuenta con la información para la nueva cuenta.
     * @param id ID del cliente asociado a la nueva cuenta.
     * @param numCuenta Número de cuenta a asignar.
     * @return True si la creación fue exitosa, False si falló.
     */
    @Override
    public boolean crearCuentaNueva(Cuenta cuenta, int id, int numCuenta) {
        String sentenciaSQL = "INSERT INTO CUENTAS (numCuenta,saldo,fechaApertura,idCliente) VALUES (?,?,?,?)";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            cuenta.setNumCuenta(numCuenta);
            comandoSQL.setInt(1, numCuenta);
            comandoSQL.setFloat(2, cuenta.getSaldo());
            comandoSQL.setString(3, cuenta.getFechaApertura());
            comandoSQL.setInt(4, id);
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

    /**
     * Suma un monto específico al saldo de una cuenta.
     * 
     * @param cuenta Número de cuenta.
     * @param monto Monto a sumar.
     */
    @Override
    public void sumarMonto(int cuenta, float monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Obtiene el ID de una cuenta basándose en la fecha de apertura.
     * 
     * @param Fecha Fecha de apertura de la cuenta.
     * @return El ID de la cuenta o -1 si no se encuentra.
     */
    @Override
    public int idCuenta(String Fecha) {
        int idCliente = -1;
        String sentenciaSQL = "SELECT idCuenta FROM Cuentas WHERE fechaApertura = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, Fecha);
            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("numCuenta");
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);

        }
        return idCliente;
    }

    /**
     * Obtiene el ID de una cuenta basándose en el número de cuenta.
     * 
     * @param numCuenta Número de cuenta.
     * @return El ID de la cuenta o -1 si no se encuentra.
     */
    public int idCuenta(int numCuenta) {
        int idCliente = -1;
        String sentenciaSQL = "SELECT idCuenta FROM Cuentas WHERE numCuenta = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setInt(1, numCuenta);
            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idCuenta");
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
        }
        return idCliente;
    }
}

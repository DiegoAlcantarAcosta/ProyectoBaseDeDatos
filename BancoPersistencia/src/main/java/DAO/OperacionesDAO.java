/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.CuentaDTO;
import DTO.OperacionesDTO;
import Entidades.Operaciones;
import java.sql.Connection;
import java.util.Date;
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
public class OperacionesDAO implements IOperacionesDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public OperacionesDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, Date desde, Date hasta) {
       String sentencia = "SELECT * FROM OPERACIONES WHERE idCuenta_origen = ?";
        List<CuentaDTO> lista = new ArrayList<>();

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setInt(1, numeroCuenta);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int numCuenta = resultado.getInt("idCuenta");
                float saldo = resultado.getFloat("saldo");
                String fechaApertura = resultado.getString("fechaApertura");
                String estado = resultado.getString("estado");
                int idClientela = resultado.getInt("idCliente");

                CuentaDTO cuenta = new CuentaDTO(saldo, fechaApertura, estado);

                lista.add(cuenta);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());
            return null;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
            return null;
        }
    }
    
    public void agregarOperacion(Operaciones op){
        String sentenciaSQL = "INSERT INTO Operaciones (idCuenta_origen,tipo,fecha,monto) VALUES (?,?,?,?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setInt(1, op.getIdCuenta());
            comandoSQL.setString(2, op.getTipo());
            comandoSQL.setString(3, op.getFecha());
            comandoSQL.setFloat(4, op.getMonto());
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la operacion", e);
        }
        
        
    }
    public int idOperacion (String Fecha){
        
        int idCliente = -1;
        String sentenciaSQL = "SELECT idTransaccion FROM Operaciones WHERE fecha= ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, Fecha);
            
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idTransaccion");
                }
            }
            
        }catch(SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            
        }
        return idCliente;
    }

    
}

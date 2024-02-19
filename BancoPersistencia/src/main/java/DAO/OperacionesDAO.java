/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.CuentaDTO;
import DTO.OperacionesDTO;
import Entidades.Operaciones;
import Entidades.SinCuenta;
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
    public List<OperacionesDTO> obtenerHistorialOperaciones(String tipo, Date desde, Date hasta) {
        String sentencia;
        List<SinCuenta> lista = new ArrayList<>();

        switch (tipo) {
            case "Sin cuenta":
                sentencia = "SELECT O.idTransaccion, O.tipo, O.monto, S.folio"
                        + "FROM OPERACIONES O"
                        + "INNER JOIN SinCuentas S ON S.idOperacion = O.idTransaccion"
                        + "WHERE fecha BETWEEN \"?\" AND \"?\"";
                
                 try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setDate(1, (java.sql.Date) desde);
            comandoSQL.setDate(2, (java.sql.Date) hasta);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int idTransaccion = resultado.getInt("O.idTransaccion");
                String tipoXD = resultado.getString("O.tipo");
                String estado = resultado.getString("S.estado");
                float monto = resultado.getFloat("O.monto");
                int folio = resultado.getInt("S.folio");

                SinCuenta cuenta = new SinCuenta(folio, estado, idTransaccion, tipo, estado, monto);
                lista.add(cuenta);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());
            return null;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
            return null;
        }
        }

       
    }

    public void agregarOperacion(Operaciones op) {
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

    public int idOperacion(String Fecha) {

        int idCliente = -1;
        String sentenciaSQL = "SELECT idTransaccion FROM Operaciones WHERE fecha= ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, Fecha);

            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idTransaccion");
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);

        }
        return idCliente;
    }

}

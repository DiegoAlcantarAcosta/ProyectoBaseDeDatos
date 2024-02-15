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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, Date desde, Date hasta) {
       String sentencia = "SELECT * FROM OPERACIONES WHERE idCuenta_origen = ?";
        List<CuentaDTO> lista = new ArrayList<>();

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setInt(1, numeroCuenta);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int numCuenta = resultado.getInt("numCuenta");
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
    

    @Override
    public List<OperacionesDTO> obtenerHistorialOperaciones(int numeroCuenta, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

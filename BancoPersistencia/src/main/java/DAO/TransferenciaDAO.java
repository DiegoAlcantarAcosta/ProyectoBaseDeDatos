/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.TransferenciaDTO;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class TransferenciaDAO implements ITransferenciaDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public TransferenciaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) throws SQLException{
        String sentenciaSQL = "CALL transferencia_entre_cuentas(?,?,?);";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            comandoSQL.setInt(1, trans.getIdCuenta());
            comandoSQL.setInt(2, trans.getIdCuentaDestino());
            comandoSQL.setFloat(3, trans.getMonto());
            ResultSet resultado = comandoSQL.executeQuery();

            TransferenciaDTO tra = new TransferenciaDTO(trans.getIdCuenta(), trans.getIdCuentaDestino(), "TRANSFERENCIA", trans.getFecha(),trans.getMonto());
            LOG.log(Level.INFO, "Se transfirieron {0}");
            return tra;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                // Capturar el error de fondos insuficientes
                String mensajeError = e.getMessage();
                JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean depositar(int cuenta, float monto) throws SQLException{
        
        String sentenciaSQL = "CALL depositar_en_cuenta(?,?);";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            comandoSQL.setInt(1, cuenta);
            comandoSQL.setFloat(2, monto);
            ResultSet resultado = comandoSQL.executeQuery();

//            TransferenciaDTO tra = new TransferenciaDTO(trans.getIdCuenta(), trans.getIdCuentaDestino(), "TRANSFERENCIA", trans.getFecha(),trans.getMonto());
            LOG.log(Level.INFO, "Se transfirieron {0}");
             JOptionPane.showMessageDialog(null, "Deposito Exitoso");
            return true;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                // Capturar el error de fondos insuficientes
                String mensajeError = e.getMessage();
                JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
}

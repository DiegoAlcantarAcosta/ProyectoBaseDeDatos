/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.TransferenciaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) {
        String sentenciaSQL = "CALL transferencia_entre_cuentas(?, ?,?);";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            comandoSQL.setInt(1, trans.getIdCuenta());
            comandoSQL.setInt(2, trans.getIdCuentaDestino());
            comandoSQL.setFloat(3, trans.getMonto());
            ResultSet resultado = comandoSQL.executeQuery();

            TransferenciaDTO tra = new TransferenciaDTO(trans.getIdCuenta(), trans.getIdCuentaDestino(), "TRANSFERENCIA", trans.getFecha(),trans.getMonto());
            LOG.log(Level.INFO, "Se transfirieron {0}");
            return tra;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentenciaSQL, e);
            return null;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import Entidades.Operaciones;
import Entidades.SinCuenta;
import Entidades.Transferencia;
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
 * Clase que implementa la interfaz IOperacionesDAO y define las operaciones
 * de acceso a datos relacionadas con las operaciones realizadas en el sistema.
 * Proporciona métodos para agregar operaciones, obtener el identificador de una
 * operación por fecha, obtener historiales de transferencias y sin cuenta, y
 * obtener listas de todas las transferencias y sin cuentas.
 * 
 * @author lv1821
 */
public class OperacionesDAO implements IOperacionesDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Constructor que recibe una instancia de IConexion para establecer la conexión
     * con la base de datos.
     * 
     * @param conexionBD Instancia de IConexion para la conexión con la base de datos.
     */
    public OperacionesDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Agrega una operación a la base de datos.
     * 
     * @param op Objeto de tipo Operaciones que contiene la información de la operación.
     */
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

    /**
     * Obtiene el identificador único de una operación dado su fecha.
     * 
     * @param Fecha Fecha de la operación.
     * @return Identificador único de la operación si se encuentra, -1 en caso contrario.
     */
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

    /**
     * Obtiene el historial de transferencias realizadas entre las fechas especificadas.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos Transferencia que representan el historial de transferencias.
     */
    @Override
    public List<Transferencia> obtenerHistorialTransferencia(String desde, String hasta) {
        String sentencia;
        List<Transferencia> lista = new ArrayList<>();

        sentencia = "SELECT  O.tipo, O.fecha, T.idTransferencia, T.idCuenta_destino, O.monto"
                + " FROM OPERACIONES O"
                + " INNER JOIN TRANSFERENCIA T ON T.idOperacion = O.idTransaccion"
                + " WHERE fecha BETWEEN ? AND ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setString(1, desde);
            comandoSQL.setString(2, hasta);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int idTransaccion = resultado.getInt("T.idTransferencia");
                int idCuentaDestino = resultado.getInt("T.idCuenta_destino");
                String tipoXD = resultado.getString("O.tipo");
                String fecha = resultado.getString("O.fecha");
                float monto = resultado.getFloat("O.monto");

                Transferencia cuenta = new Transferencia(idTransaccion, idCuentaDestino, tipoXD, fecha, monto);
                lista.add(cuenta);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());
            return lista;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
            return null;
        }
    }

    /**
     * Obtiene el historial de operaciones sin cuenta realizadas entre las fechas especificadas.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Lista de objetos SinCuenta que representan el historial de operaciones sin cuenta.
     */
    @Override
    public List<SinCuenta> obtenerHistorialSinCuenta(String desde, String hasta) {
        String sentencia;
        List<SinCuenta> lista = new ArrayList<>();

        sentencia = "SELECT O.idTransaccion, O.tipo, S.estado, O.monto, S.folio, O.fecha"
                + " FROM OPERACIONES O"
                + " INNER JOIN SinCuentas S ON S.idOperacion = O.idTransaccion"
                + " WHERE fecha BETWEEN ? AND ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setString(1, desde);
            comandoSQL.setString(2, hasta);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int idTransaccion = resultado.getInt("O.idTransaccion");
                String tipoXD = resultado.getString("O.tipo");
                String estado = resultado.getString("S.estado");
                String fecha = resultado.getString("O.fecha");
                float monto = resultado.getFloat("O.monto");
                int folio = resultado.getInt("S.folio");

                SinCuenta cuenta = new SinCuenta(folio, estado, idTransaccion, tipoXD, fecha, monto);
                lista.add(cuenta);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());
            return lista;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
            return null;
        }
    }

    /**
     * Obtiene todas las transferencias registradas en el sistema.
     * 
     * @return Lista de objetos Transferencia que representan todas las transferencias.
     */
    @Override
    public List<Transferencia> obtenerTodasTransferencia() {
        String sentencia;
        List<Transferencia> lista = new ArrayList<>();

        sentencia = "SELECT  O.tipo, O.fecha, T.idTransferencia, T.idCuenta_destino, O.monto\n"
                + "FROM OPERACIONES O\n"
                + "INNER JOIN TRANSFERENCIA T ON T.idOperacion = O.idTransaccion";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int idTransaccion = resultado.getInt("T.idTransferencia");
                int idCuentaDestino = resultado.getInt("T.idCuenta_destino");
                String tipoXD = resultado.getString("O.tipo");
                String fecha = resultado.getString("O.fecha");
                float monto = resultado.getFloat("O.monto");

                Transferencia cuenta = new Transferencia(idTransaccion, idCuentaDestino, tipoXD, fecha, monto);
                lista.add(cuenta);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());
            return lista;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
            return null;
        }
    }

    /**
     * Obtiene todas las operaciones sin cuenta registradas en el sistema.
     * 
     * @return Lista de objetos SinCuenta que representan todas las operaciones sin cuenta.
     */
    @Override
    public List<SinCuenta> obtenerTodaSInCuenta() {
        String sentencia;
        List<SinCuenta> lista = new ArrayList<>();

        sentencia = "SELECT O.idTransaccion, O.tipo, S.estado, O.monto, S.folio, O.fecha\n"
                + "FROM OPERACIONES O\n"
                + "INNER JOIN SinCuentas S ON S.idOperacion = O.idTransaccion";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int idTransaccion = resultado.getInt("O.idTransaccion");
                String tipoXD = resultado.getString("O.tipo");
                String estado = resultado.getString("S.estado");
                String fecha = resultado.getString("O.fecha");
                float monto = resultado.getFloat("O.monto");
                int folio = resultado.getInt("S.folio");

                SinCuenta cuenta = new SinCuenta(folio, estado, idTransaccion, tipoXD, fecha, monto);
                lista.add(cuenta);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());
            return lista;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
            return null;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.RetiroSinDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que implementa la interfaz IRetiroSinDAO y define las operaciones
 * de acceso a datos relacionadas con los retiros sin cuenta en el sistema.
 * Proporciona métodos para autenticar el cobro, generar un retiro sin cuenta,
 * generar una contraseña, actualizar el estado de una cuenta, obtener el último
 * folio registrado y realizar un evento de programación para verificar retiros
 * sin cuenta.
 * 
 * @author pc
 */
public class RetiroSinDAO implements IRetiroSinDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Constructor que recibe una instancia de IConexion para establecer la conexión
     * con la base de datos.
     * 
     * @param conexionBD Instancia de IConexion para la conexión con la base de datos.
     */
    public RetiroSinDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Autentica el cobro de un retiro sin cuenta.
     * 
     * @param folio Folio del retiro sin cuenta.
     * @param contraseña Contraseña asociada al retiro sin cuenta.
     * @return True si la autenticación es exitosa, False en caso contrario.
     */
    @Override
    public boolean autenticarCobro(int folio, int contraseña) {
        String sentencia = "SELECT * FROM sincuentas WHERE folio = ? and contraseña = ?";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
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

    /**
     * Genera un retiro sin cuenta y lo registra en la base de datos.
     * 
     * @param sin Objeto de tipo RetiroSinDTO que contiene la información del retiro sin cuenta.
     * @param num Número asociado al retiro sin cuenta.
     * @return True si el retiro sin cuenta se generó y registró correctamente, False en caso contrario.
     */
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

    /**
     * Genera una contraseña aleatoria para un retiro sin cuenta.
     * 
     * @return Contraseña generada.
     */
    @Override
    public int generarContraseña() {
        Random random = new Random();
        int numero = 10000000 + random.nextInt(90000000);
        return numero;
    }

    /**
     * Actualiza el estado de un retiro sin cuenta en la base de datos.
     * 
     * @param numCuenta Número de cuenta asociado al retiro sin cuenta.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    @Override
    public void actualizarEstado(int numCuenta) throws SQLException{
        String sentenciaSQL = "UPDATE sincuentas SET estado = ? WHERE idSinCuentas = ? and estado = ?";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, "COBRADO");
            comandoSQL.setInt(2, numCuenta);
            comandoSQL.setString(3, "Procesando");
            

            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se ha actualizado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();
        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                // Capturar el error de fondos insuficientes
                String mensajeError = e.getMessage();
                JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
                
            }
        }
        
    }

    /**
     * Obtiene el último folio registrado en la base de datos para retiros sin cuenta.
     * 
     * @return Último folio registrado.
     */
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
    
    /**
     * Obtiene el ID del retiro sin cuenta asociado a un folio y contraseña específicos.
     * 
     * @param folio Folio del retiro sin cuenta.
     * @param contraseña Contraseña asociada al retiro sin cuenta.
     * @return ID del retiro sin cuenta.
     */
    public int idRetiro(int folio, int contraseña){
        int idCliente = -1;
        String sentenciaSQL = "SELECT idSinCuentas FROM sincuentas where folio = ? and contraseña = ?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

                comandoSQL.setInt(1, folio);
                comandoSQL.setInt(2, contraseña);
                
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idSinCuentas");
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo obtener el folio", e);

        }
        return idCliente;
    }

    /**
     * Realiza un evento de programación para verificar retiros sin cuenta.
     */
    public void evento() {
        String sentenciaSQL = "CALL programar_verificacion_retiro_sin_cuenta()";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            ResultSet resultado = comandoSQL.executeQuery();
//            TransferenciaDTO tra = new TransferenciaDTO(trans.getIdCuenta(), trans.getIdCuentaDestino(), "TRANSFERENCIA", trans.getFecha(),trans.getMonto());
            LOG.log(Level.INFO, "Se llamo {0}");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentenciaSQL, e);

        }

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.ClienteDTO;
import DTO.CuentaDTO;
import Entidades.Cliente;
import Entidades.Cuenta;
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
 *
 * @author lv1821
 */
public class ClienteDAO implements IClienteDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    public ClienteDAO() {
    }

    @Override
    public ClienteDTO obtenerCliente(int idCliente) {
        String sentencia = "SELECT * FROM CLIENTES WHERE idCliente = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setInt(1, idCliente);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idCliente");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                

                ClienteDTO cliente = new ClienteDTO(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento,obtenerCuentasCliente(id));
                return cliente;
            }
            LOG.log(Level.INFO, "Se consultaron {0}");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
        }
        return null;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean registrarCliente(Cliente cliente) {
        String sentenciaSQL = "INSERT INTO CLIENTES (nombre,apellidoPaterno,apellidoMaterno, fechaNacimiento, idUsuario, idDireccion) VALUES (?,?,?,?,?,?,?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFechaNacimiento());

            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha registrado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el cliente");
            System.out.println("No se pudo registrar el cliente" + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Cuenta> obtenerCuentasCliente(int idCliente) {
        String sentencia = "SELECT * FROM CUENTAS WHERE idCliente = ?";
        List<Cuenta> lista = new ArrayList<>();

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setInt(1, idCliente);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int numCuenta = resultado.getInt("numCuenta");
                float saldo = resultado.getFloat("saldo");
                String fechaApertura = resultado.getString("fechaApertura");
                String estado = resultado.getString("estado");
                int idClientela = resultado.getInt("idCliente");

                Cuenta cuenta = new Cuenta(numCuenta, saldo, fechaApertura);

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

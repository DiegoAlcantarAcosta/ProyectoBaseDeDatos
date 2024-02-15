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
import java.sql.CallableStatement;
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
                

                ClienteDTO cliente = new ClienteDTO(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
                
                return cliente;
            }
            LOG.log(Level.INFO, "Se consultaron {0}");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
        }
        return null;
    }

    @Override
    public boolean actualizarCliente(ClienteDTO cliente, int idCliente) {
        String sentenciaSQL = "UPDATE Clientes SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, fechaNacimiento = ? WHERE idCliente = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFechaNacimiento());
            comandoSQL.setInt(5, idCliente);
      
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

    @Override
    public boolean registrarCliente(Cliente cliente) {
        String sentenciaSQL = "INSERT INTO CLIENTES (nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento) VALUES (?,?,?,?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFechaNacimiento());

            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha registrado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();
           try (CallableStatement cstmt = conexion.prepareCall("{call calcularEdadCliente()}")) {
                // Establecer el valor del parámetro de entrada
                
                
                // Ejecutar el procedimiento almacenado
                cstmt.execute();
            }
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
    public int idCliente(String nombre, String Paterno){
        int idCliente = -1;
        String sentenciaSQL = "SELECT idCliente FROM CLIENTES WHERE nombre = ? and apellidoPaterno = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, nombre);
            comandoSQL.setString(2, Paterno);
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idCliente");
                }
            }
            
        }catch(SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            
        }
        return idCliente;
    }

    @Override
    public int idClienteUsuario(int idUsuario) {
        int idCliente = -1;
        String sentenciaSQL = "SELECT idCliente FROM CLIENTES WHERE idUsuario = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setInt(1, idUsuario);
  
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idCliente");
                }
            }
            
        }catch(SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            
        }
        return idCliente;
    }

    @Override
    public int idClienteDireccion(int idCliente) {
        int x = -1;
        String sentenciaSQL = "SELECT idDireccion FROM CLIENTES WHERE idCliente = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setInt(1, idCliente);
  
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    x = resultado.getInt("idDireccion");
                }
            }
            
        }catch(SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            
        }
        return x;
    }
}

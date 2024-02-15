/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.UsuariosDTO;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class UsuarioDAO implements IUsuarioDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public UsuarioDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public boolean autenticarUsuario(String usuario, String contraseña) {
        String sentencia = "SELECT * FROM USUARIOS WHERE nombreUsuario = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setString(1, usuario);
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                String nombreUsuario = resultado.getString("nombreUsuario");
                String contra = resultado.getString("contraseña");

                if (nombreUsuario.equals(usuario) && contra.equals(contraseña)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentencia, e);
        }
        return false;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        String sentenciaSQL = "INSERT INTO USUARIOS (nombreUsuario, contraseña) VALUES (?,?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, usuario.getNombreUsuario());
            comandoSQL.setString(2, usuario.getContraseña());
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado {0}", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el cliente", e);
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(UsuariosDTO usuario, int idUsuario) {
        String sentenciaSQL = "UPDATE USUARIOS SET nombreUsuario = ?, contraseña = ? WHERE idUsuario = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, usuario.getNombreUsuario());
            comandoSQL.setString(2, usuario.getContraseña());
            comandoSQL.setInt(3, idUsuario);
      
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
    public int idUsuario(String contraseña, String Usuario) {
        int idCliente = -1;
        String sentenciaSQL = "SELECT idUsuario FROM usuarios WHERE nombreUsuario = ? and contraseña = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, Usuario);
            comandoSQL.setString(2, contraseña);
            
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                // Si se encontró el cliente, obtener su ID
                if (resultado.next()) {
                    idCliente = resultado.getInt("idUsuario");
                }
            }
            
        }catch(SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            
        }
        return idCliente;
    }
}

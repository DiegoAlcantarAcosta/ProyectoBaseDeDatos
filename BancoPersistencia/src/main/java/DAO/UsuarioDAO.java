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
 * Clase que implementa la interfaz IUsuarioDAO y define las operaciones
 * de acceso a datos relacionadas con los usuarios en el sistema.
 * Proporciona métodos para autenticar usuarios, registrar nuevos usuarios,
 * actualizar la información de los usuarios y obtener el ID de un usuario.
 * 
 * @author pc
 */
public class UsuarioDAO implements IUsuarioDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Constructor que recibe una instancia de IConexion para establecer la conexión
     * con la base de datos.
     * 
     * @param conexionBD Instancia de IConexion para la conexión con la base de datos.
     */
    public UsuarioDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Autentica un usuario en el sistema verificando el nombre de usuario y la contraseña.
     * 
     * @param usuario Nombre de usuario a autenticar.
     * @param contraseña Contraseña del usuario.
     * @return True si la autenticación es exitosa, False en caso contrario.
     */
    @Override
    public boolean autenticarUsuario(String usuario, String contraseña) {
        String sentencia = "SELECT * FROM USUARIOS WHERE nombreUsuario = ? and contraseña = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareCall(sentencia);) {
            comandoSQL.setString(1, usuario);
            comandoSQL.setString(2, contraseña);
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

    /**
     * Registra un nuevo usuario en la base de datos.
     * 
     * @param usuario Objeto de tipo Usuario que contiene la información del nuevo usuario.
     * @return True si el registro es exitoso, False en caso contrario.
     */
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

    /**
     * Actualiza la información de un usuario en la base de datos.
     * 
     * @param usuario Objeto de tipo UsuariosDTO que contiene la nueva información del usuario.
     * @param idUsuario ID del usuario a actualizar.
     * @return True si la actualización es exitosa, False en caso contrario.
     */
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

    /**
     * Obtiene el ID de un usuario en la base de datos.
     * 
     * @param contraseña Contraseña del usuario.
     * @param Usuario Nombre de usuario.
     * @return ID del usuario si se encuentra, -1 en caso contrario.
     */
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

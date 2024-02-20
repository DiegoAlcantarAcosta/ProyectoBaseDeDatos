           /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.UsuariosDTO;
import Entidades.Usuario;

/**
 * Interface que define las operaciones de acceso a datos para los usuarios.
 * Las clases que implementen esta interfaz proporcionarán la lógica para interactuar
 * con la capa de persistencia y realizar operaciones relacionadas con los usuarios.
 * 
 * @author pc
 */
public interface IUsuarioDAO {

    /**
     * Autentica a un usuario en el sistema.
     *
     * @param usuario Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
    boolean autenticarUsuario(String usuario, String contraseña);

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario Objeto de tipo Usuario que contiene la información del nuevo usuario.
     * @return true si el registro se realiza exitosamente, false en caso contrario.
     */
    public boolean registrarUsuario(Usuario usuario);

    /**
     * Actualiza la información de un usuario existente en el sistema.
     *
     * @param usuario Objeto de tipo UsuariosDTO que contiene la información actualizada del usuario.
     * @param idUsuario Identificador único del usuario a actualizar.
     * @return true si la actualización se realiza exitosamente, false en caso contrario.
     */
    boolean actualizarUsuario(UsuariosDTO usuario, int idUsuario);

    /**
     * Obtiene el identificador único de un usuario dado su nombre de usuario y contraseña.
     *
     * @param contraseña Contraseña del usuario.
     * @param usuario Nombre de usuario.
     * @return Identificador único del usuario si se encuentra, -1 en caso contrario.
     */
    int idUsuario(String contraseña, String usuario);
}


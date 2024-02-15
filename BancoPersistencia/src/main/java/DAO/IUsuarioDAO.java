           /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.UsuariosDTO;
import Entidades.Usuario;

/**
 *
 * @author pc
 */
public interface IUsuarioDAO {
    boolean autenticarUsuario(String usuario, String contraseña);
    public boolean registrarUsuario(Usuario usuario);
    boolean actualizarUsuario(UsuariosDTO usuario, int idUsuario);
    int idUsuario(String contraseña, String Usuario);
}

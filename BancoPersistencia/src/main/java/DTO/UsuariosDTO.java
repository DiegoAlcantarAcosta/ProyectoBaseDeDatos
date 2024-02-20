/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para usuarios.
 * Contiene atributos como el nombre de usuario y la contraseña.
 * 
 * @author pc
 */
public class UsuariosDTO {
    private String nombreUsuario, contraseña;

    /**
     * Constructor que recibe los atributos de un usuario.
     * 
     * @param nombreUsuario Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     */
    public UsuariosDTO(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    /**
     * Método getter para obtener el nombre de usuario.
     * 
     * @return Nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método setter para establecer el nombre de usuario.
     * 
     * @param nombreUsuario Nuevo nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método getter para obtener la contraseña del usuario.
     * 
     * @return Contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método setter para establecer la contraseña del usuario.
     * 
     * @param contraseña Nueva contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Método toString para obtener una representación en cadena del objeto UsuariosDTO.
     * 
     * @return Cadena que representa el objeto UsuariosDTO.
     */
    @Override
    public String toString() {
        return "UsuariosDTO{" + "nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + '}';
    }
}

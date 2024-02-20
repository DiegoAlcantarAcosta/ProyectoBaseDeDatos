/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 * La clase Usuario representa a un usuario del sistema con información básica como
 * un identificador único, nombre de usuario y contraseña.
 * 
 * @author pc
 */
public class Usuario {
    private int idUsuario;
    private String nombreUsuario, contraseña;

    /**
     * Constructor que crea un nuevo objeto Usuario con todos los atributos.
     *
     * @param idUsuario     Identificador único del usuario.
     * @param nombreUsuario Nombre de usuario.
     * @param contraseña    Contraseña del usuario.
     */
    public Usuario(int idUsuario, String nombreUsuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    /**
     * Constructor que crea un nuevo objeto Usuario sin el identificador único.
     *
     * @param nombreUsuario Nombre de usuario.
     * @param contraseña    Contraseña del usuario.
     */
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    /**
     * Constructor por defecto que crea un nuevo objeto Usuario sin atributos inicializados.
     */
    public Usuario() {
    }

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param idUsuario El identificador único del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contraseña La contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Genera y devuelve el código hash para el objeto Usuario basado en sus atributos.
     *
     * @return El código hash del objeto Usuario.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idUsuario;
        hash = 29 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 29 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    /**
     * Compara este objeto Usuario con otro objeto para determinar si son iguales.
     *
     * @param obj El objeto a comparar con el Usuario actual.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        return Objects.equals(this.contraseña, other.contraseña);
    }

    /**
     * Retorna una representación de cadena del objeto Usuario.
     *
     * @return Una cadena que representa el Usuario, incluyendo sus atributos.
     */
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + '}';
    }
}

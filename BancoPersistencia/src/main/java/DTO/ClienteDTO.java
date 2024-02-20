/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Cuenta;
import java.util.List;

/**
 * Data Transfer Object (DTO) que representa la información de un cliente.
 * Contiene atributos como nombre, apellidos, fecha de nacimiento y una lista
 * de cuentas asociadas al cliente
 * 
 * @author lv1821
 */
public class ClienteDTO {

    private String nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento;
    private List<Cuenta> cuentas;

    /**
     * Constructor que recibe todos los atributos de un cliente, incluyendo la lista
     * de cuentas asociadas.
     * 
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente en formato String.
     * @param cuentas Lista de cuentas asociadas al cliente.
     */
    public ClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, List<Cuenta> cuentas) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.cuentas = cuentas;
    }

    /**
     * Constructor que recibe solo los atributos básicos de un cliente, sin incluir la lista
     * de cuentas asociadas. Esta versión se utiliza cuando no es necesario proporcionar la lista.
     * 
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente en formato String.
     */
    public ClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /**
     * Método getter para obtener el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del cliente.
     * 
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el apellido paterno del cliente.
     * 
     * @return Apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método setter para establecer el apellido paterno del cliente.
     * 
     * @param apellidoPaterno Nuevo apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método getter para obtener el apellido materno del cliente.
     * 
     * @return Apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método setter para establecer el apellido materno del cliente.
     * 
     * @param apellidoMaterno Nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método getter para obtener la fecha de nacimiento del cliente.
     * 
     * @return Fecha de nacimiento del cliente en formato String.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método setter para establecer la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento Nueva fecha de nacimiento del cliente en formato String.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método getter para obtener la lista de cuentas asociadas al cliente.
     * 
     * @return Lista de cuentas asociadas al cliente.
     */
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * Método setter para establecer la lista de cuentas asociadas al cliente.
     * 
     * @param cuentas Nueva lista de cuentas asociadas al cliente.
     */
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Método toString que devuelve una representación en cadena del objeto ClienteDTO.
     * 
     * @return Cadena que representa el objeto ClienteDTO.
     */
    @Override
    public String toString() {
        return "ClienteDTO{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", cuentas=" + cuentas + '}';
    }
}

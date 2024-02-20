/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import java.util.Objects;

/**
 * La clase Cliente representa a un cliente con información personal y una lista de cuentas asociadas.
 * 
 * @author lv1821
 */
public class Cliente {
    private int idCliente;
    private String nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento;
    private List<Cuenta> cuentas;

    /**
     * Constructor que inicializa un objeto Cliente con todos los detalles.
     *
     * @param idCliente Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente en formato de cadena.
     * @param cuentas Lista de cuentas asociadas al cliente.
     */
    public Cliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, List<Cuenta> cuentas) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.cuentas = cuentas;
    }

    /**
     * Constructor que inicializa un objeto Cliente sin un identificador único.
     *
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente en formato de cadena.
     * @param cuentas Lista de cuentas asociadas al cliente.
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, List<Cuenta> cuentas) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.cuentas = cuentas;
    }

    /**
     * Constructor que inicializa un objeto Cliente con información básica.
     *
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente en formato de cadena.
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /**
     * Constructor por defecto sin parámetros.
     */
    public Cliente() {
    }

    /**
     * Metodo para obtener el id del cliente
     * @return idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo para asignar valor al idCliente
     * @param idCliente id del cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Metodo para obtener el nombre del cliente
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para asignar valor al nombre
     * @param nombre nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el apellido paterno del cliente
     * @return
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     *
     * @param apellidoPaterno El apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     *
     * @return El apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     *
     * @param apellidoMaterno El apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     *
     * @return La fecha de nacimiento del cliente en formato de cadena.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param fechaNacimiento La fecha de nacimiento del cliente en formato de cadena.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la lista de cuentas asociadas al cliente.
     *
     * @return La lista de cuentas asociadas al cliente.
     */
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * Establece la lista de cuentas asociadas al cliente.
     *
     * @param cuentas La lista de cuentas asociadas al cliente.
     */
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Genera un código hash único para el objeto Cliente basado en sus atributos.
     *
     * @return El código hash del objeto Cliente.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCliente;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 97 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 97 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 97 * hash + Objects.hashCode(this.cuentas);
        return hash;
    }

    /**
     * Compara el objeto Cliente actual con otro objeto para verificar su igualdad.
     *
     * @param obj El objeto a comparar con el Cliente actual
     * @return true o false
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return Objects.equals(this.cuentas, other.cuentas);
    }

    /**
     * Metodo que imprime todas las variables de la clase
     * @return Cadena de texto
     */
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", cuentas=" + cuentas + '}';
    }  
}

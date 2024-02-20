/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 * La clase Direccion representa la dirección del cliente.
 * Contiene información como el identificador, calle, colonia, número y código postal.
 *
 * @author lv1821
 */
public class Direccion {
    private int idDireccion;
    private String calle, colonia, numero, codigoPostal;

    /**
     * Constructor que crea un nuevo objeto Direccion con todos los atributos.
     *
     * @param idDireccion  Identificador único de la dirección.
     * @param calle        Nombre de la calle de la dirección.
     * @param colonia      Nombre de la colonia de la dirección.
     * @param numero       Número de la dirección.
     * @param codigoPostal Código postal de la dirección.
     */
    public Direccion(int idDireccion, String calle, String colonia, String numero, String codigoPostal) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor que crea un nuevo objeto Direccion sin el identificador único de la dirección.
     *
     * @param calle        Nombre de la calle de la dirección.
     * @param colonia      Nombre de la colonia de la dirección.
     * @param numero       Número de la dirección.
     * @param codigoPostal Código postal de la dirección.
     */
    public Direccion(String calle, String colonia, String numero, String codigoPostal) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor por defecto que crea un nuevo objeto Direccion sin atributos inicializados.
     */
    public Direccion() {
    }

    /**
     * Obtiene el identificador único de la dirección.
     *
     * @return El identificador único de la dirección.
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Establece el identificador único de la dirección.
     *
     * @param idDireccion El identificador único de la dirección.
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Obtiene el nombre de la calle de la dirección.
     *
     * @return El nombre de la calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle de la dirección.
     *
     * @param calle El nombre de la calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el nombre de la colonia de la dirección.
     *
     * @return El nombre de la colonia de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece el nombre de la colonia de la dirección.
     *
     * @param colonia El nombre de la colonia de la dirección.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el número de la dirección.
     *
     * @return El número de la dirección.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección.
     *
     * @param numero El número de la dirección.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el código postal de la dirección.
     *
     * @return El código postal de la dirección.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección.
     *
     * @param codigoPostal El código postal de la dirección.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Genera un código hash único para el objeto Direccion basado en sus atributos.
     *
     * @return El código hash del objeto Direccion.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idDireccion;
        hash = 47 * hash + Objects.hashCode(this.calle);
        hash = 47 * hash + Objects.hashCode(this.colonia);
        hash = 47 * hash + Objects.hashCode(this.numero);
        hash = 47 * hash + Objects.hashCode(this.codigoPostal);
        return hash;
    }

    /**
     * Compara el objeto Direccion actual con otro objeto para verificar su igualdad.
     *
     * @param obj El objeto a comparar con la Direccion actual.
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
        final Direccion other = (Direccion) obj;
        if (this.idDireccion != other.idDireccion) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.colonia, other.colonia)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.codigoPostal, other.codigoPostal);
    }

    /**
     * Retorna una representación de cadena del objeto Direccion.
     *
     * @return Una cadena que representa la Direccion, incluyendo sus atributos.
     */
    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", colonia=" + colonia + ", numero=" + numero + ", codigoPostal=" + codigoPostal + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Data Transfer Object (DTO) que representa la información de una dirección.
 * Contiene atributos como calle, colonia, número y código postal de la dirección.
 * 
 * @author lv1821
 */
public class DireccionDTO {
        private String calle, colonia, numero, codigoPostal;

        /**
     * Constructor que recibe los atributos de una dirección.
     * 
     * @param calle Calle de la dirección.
     * @param colonia Colonia de la dirección.
     * @param numero Número de la dirección.
     * @param codigoPostal Código postal de la dirección.
     */
    public DireccionDTO(String calle, String colonia, String numero, String codigoPostal) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método getter para obtener la calle de la dirección.
     * 
     * @return Calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método setter para establecer la calle de la dirección.
     * 
     * @param calle Nueva calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Método getter para obtener la colonia de la dirección.
     * 
     * @return Colonia de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Método setter para establecer la colonia de la dirección.
     * 
     * @param colonia Nueva colonia de la dirección.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Método getter para obtener el número de la dirección.
     * 
     * @return Número de la dirección.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Método setter para establecer el número de la dirección.
     * 
     * @param numero Nuevo número de la dirección.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Método getter para obtener el código postal de la dirección.
     * 
     * @return Código postal de la dirección.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método setter para establecer el código postal de la dirección.
     * 
     * @param codigoPostal Nuevo código postal de la dirección.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}

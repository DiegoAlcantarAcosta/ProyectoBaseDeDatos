/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Data Transfer Object (DTO) que representa la información de una cuenta.
 * Contiene atributos como saldo, fecha de apertura y estado de la cuenta.
 * 
 * @author lv1821
 */
public class CuentaDTO {
    private float saldo;
    private String fechaApertura, estado;

    /**
     * Constructor que recibe los atributos de una cuenta.
     * 
     * @param saldo Saldo de la cuenta.
     * @param fechaApertura Fecha de apertura de la cuenta en formato String.
     * @param estado Estado de la cuenta.
     */
    public CuentaDTO(float saldo, String fechaApertura, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    /**
     * Método getter para obtener el saldo de la cuenta.
     * 
     * @return Saldo de la cuenta.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Método setter para establecer el saldo de la cuenta.
     * 
     * @param saldo Nuevo saldo de la cuenta.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Método getter para obtener la fecha de apertura de la cuenta.
     * 
     * @return Fecha de apertura de la cuenta en formato String.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método setter para establecer la fecha de apertura de la cuenta.
     * 
     * @param fechaApertura Nueva fecha de apertura de la cuenta en formato String.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    
    /**
     * Método getter para obtener el estado de la cuenta.
     * 
     * @return Estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado de la cuenta.
     * 
     * @param estado Nuevo estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString que devuelve una representación en cadena del objeto CuentaDTO.
     * 
     * @return Cadena que representa el objeto CuentaDTO.
     */
    @Override
    public String toString() {
        return "CuentaDTO{" + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura  + ", estado=" + estado + '}';
    }
}

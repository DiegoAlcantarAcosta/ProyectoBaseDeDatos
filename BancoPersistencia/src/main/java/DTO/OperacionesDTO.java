/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Data Transfer Object (DTO) que representa la información de una operación.
 * Contiene atributos como el ID de cuenta, tipo de operación, fecha y monto.
 * 
 * @author lv1821
 */
public class OperacionesDTO {

    private int idCuenta;
    private String tipo, fecha;
    private float monto;

    /**
     * Constructor que recibe los atributos de una operación.
     * 
     * @param idCuenta ID de la cuenta asociada a la operación.
     * @param tipo Tipo de operación (por ejemplo, depósito, retiro, transferencia).
     * @param fecha Fecha en la que se realizó la operación.
     * @param monto Monto asociado a la operación.
     */
    public OperacionesDTO(int idCuenta, String tipo, String fecha, float monto) {
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    /**
     * Método getter para obtener el ID de la cuenta asociada a la operación.
     * 
     * @return ID de la cuenta.
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Método setter para establecer el ID de la cuenta asociada a la operación.
     * 
     * @param idCuenta Nuevo ID de la cuenta.
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Método getter para obtener el tipo de operación.
     * 
     * @return Tipo de operación.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método setter para establecer el tipo de operación.
     * 
     * @param tipo Nuevo tipo de operación.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método getter para obtener la fecha de la operación.
     * 
     * @return Fecha de la operación.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Método setter para establecer la fecha de la operación.
     * 
     * @param fecha Nueva fecha de la operación.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Método getter para obtener el monto asociado a la operación.
     * 
     * @return Monto de la operación.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Método setter para establecer el monto de la operación.
     * 
     * @param monto Nuevo monto de la operación.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Método toString para obtener una representación en cadena de la operación.
     * 
     * @return Cadena que representa la operación con sus atributos.
     */
    @Override
    public String toString() {
        return "OperacionesDTO{" + "idCuenta=" + idCuenta + ", tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para operaciones de transferencia.
 * Hereda de la clase OperacionesDTO.
 * Contiene atributos específicos como el identificador de la cuenta de destino.
 * 
 * @author pc
 */
public class TransferenciaDTO extends OperacionesDTO{
    private int idCuentaDestino;

    /**
     * Constructor que recibe los atributos de una transferencia.
     * 
     * @param idCuenta Identificador de la cuenta origen de la transferencia.
     * @param idCuentaDestino Identificador de la cuenta destino de la transferencia.
     * @param tipo Tipo de la operación.
     * @param fecha Fecha de la operación.
     * @param monto Monto de la operación.
     */
    public TransferenciaDTO(int idCuenta, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(idCuenta,tipo, fecha, monto);
        
        this.idCuentaDestino = idCuentaDestino;
    }
    
    /**
     * Método getter para obtener el identificador de la cuenta destino de la transferencia.
     * 
     * @return Identificador de la cuenta destino.
     */
    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    /**
     * Método setter para establecer el identificador de la cuenta destino de la transferencia.
     * 
     * @param idCuentaDestino Nuevo identificador de la cuenta destino.
     */
    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * Método toString para obtener una representación en cadena del objeto TransferenciaDTO.
     * 
     * @return Cadena que representa el objeto TransferenciaDTO.
     */
    @Override
    public String toString() {
        return "TransferenciaDTO{" + "idCuentaDestino=" + idCuentaDestino + '}';
    }
}

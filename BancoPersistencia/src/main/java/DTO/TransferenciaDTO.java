/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class TransferenciaDTO extends OperacionesDTO{
    private int idCuentaDestino;

    // Constructor
    public TransferenciaDTO(int idCuenta, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(idCuenta,tipo, fecha, monto);
        
        this.idCuentaDestino = idCuentaDestino;
    }
    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    @Override
    public String toString() {
        return "TransferenciaDTO{" + "idCuentaDestino=" + idCuentaDestino + '}';
    }
    
    
    
}

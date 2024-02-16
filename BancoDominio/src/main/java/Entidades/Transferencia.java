/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author pc
 */
public class Transferencia extends Operaciones{
    private int idTransferencia;
    private int cuentaDestino;
    
    // Constructor con llave primaria
    public Transferencia(int idTransferencia,int idCuenta, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(idCuenta,tipo, fecha, monto);
        this.idTransferencia = idTransferencia;
        this.cuentaDestino = idCuentaDestino;
    }

    // Constructor con datos y sin llave primaria
    public Transferencia(int idCuenta, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(idCuenta,tipo, fecha, monto);
        this.cuentaDestino = idCuentaDestino;
    }
    
    public Transferencia(int idCuenta, int idCuentaDestino, float monto){
        
    }

    // Constructor sin datos ni llave primaria
    public Transferencia() {
        super();
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.idTransferencia;
        hash = 23 * hash + this.cuentaDestino;
        return hash;
    }

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
        final Transferencia other = (Transferencia) obj;
        if (this.idTransferencia != other.idTransferencia) {
            return false;
        }
        return this.cuentaDestino == other.cuentaDestino;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", cuentaDestino=" + cuentaDestino + '}';
    }

   

    

    
    
    
    
    
    
}

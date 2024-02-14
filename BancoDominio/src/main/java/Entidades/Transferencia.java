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
    private int cuentaOrigen;
    
    // Constructor con llave primaria
    public Transferencia(int idTransferencia, int idCuentaOrigen, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(tipo, fecha, monto);
        this.idTransferencia = idTransferencia;
        this.cuentaOrigen = idCuentaOrigen;
        this.cuentaDestino = idCuentaDestino;
    }

    // Constructor con datos y sin llave primaria
    public Transferencia(int idCuentaOrigen, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(tipo, fecha, monto);
        this.cuentaOrigen = idCuentaOrigen;
        this.cuentaDestino = idCuentaDestino;
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

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idTransferencia;
        hash = 47 * hash + this.cuentaDestino;
        hash = 47 * hash + this.cuentaOrigen;
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
        if (this.cuentaDestino != other.cuentaDestino) {
            return false;
        }
        return this.cuentaOrigen == other.cuentaOrigen;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", cuentaDestino=" + cuentaDestino + ", cuentaOrigen=" + cuentaOrigen + '}';
    }
    
    
    
    
    
    
}

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
    private int cuentaDestino;
    private int cuentaOrigen;
    
    public Transferencia(int idTransaccion, String tipo, String fecha, float monto, int idCuentaOrigen, int idCuentaDestino) {
        super(idTransaccion, tipo, fecha, monto);
        this.cuentaOrigen = idCuentaOrigen;
        this.cuentaDestino = idCuentaDestino;
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
        hash = 67 * hash + this.cuentaDestino;
        hash = 67 * hash + this.cuentaOrigen;
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
        if (this.cuentaDestino != other.cuentaDestino) {
            return false;
        }
        return this.cuentaOrigen == other.cuentaOrigen;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "cuentaDestino=" + cuentaDestino + ", cuentaOrigen=" + cuentaOrigen + '}';
    }
    
    
    
    
}

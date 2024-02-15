/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Entidades;

import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class Cuenta {
    private int numCuenta, idCliente;
    private float saldo;
    private String fechaApertura;

    public Cuenta(int numCuenta, float saldo, String fechaApertura) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }
    public Cuenta(float saldo, String fechaApertura,int numCliente) {
        this.idCliente = numCliente;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }
    public Cuenta(float saldo, String fechaApertura) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    public Cuenta() {
    }
    
    public int getNumCuenta() {
        return numCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.numCuenta;
        hash = 23 * hash + this.idCliente;
        hash = 23 * hash + Float.floatToIntBits(this.saldo);
        hash = 23 * hash + Objects.hashCode(this.fechaApertura);
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
        final Cuenta other = (Cuenta) obj;
        if (this.numCuenta != other.numCuenta) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        return Objects.equals(this.fechaApertura, other.fechaApertura);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", idCliente=" + idCliente + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + '}';
    }

    

    
    
    
}

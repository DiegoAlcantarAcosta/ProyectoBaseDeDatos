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
    private int idCuenta,numCuenta, idCliente;
    private float saldo;
    private String fechaApertura;

    public Cuenta(int idCuenta, int numCuenta, int idCliente, float saldo, String fechaApertura) {
        this.idCuenta = idCuenta;
        this.numCuenta = numCuenta;
        this.idCliente = idCliente;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    public Cuenta(int numCuenta, int idCliente, float saldo, String fechaApertura) {
        this.numCuenta = numCuenta;
        this.idCliente = idCliente;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    public Cuenta() {
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idCuenta;
        hash = 31 * hash + this.numCuenta;
        hash = 31 * hash + this.idCliente;
        hash = 31 * hash + Float.floatToIntBits(this.saldo);
        hash = 31 * hash + Objects.hashCode(this.fechaApertura);
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
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
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

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", numCuenta=" + numCuenta + ", idCliente=" + idCliente + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + '}';
    }

    

    

    
    
    
}

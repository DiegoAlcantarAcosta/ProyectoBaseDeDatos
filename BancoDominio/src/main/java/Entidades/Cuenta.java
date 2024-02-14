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
    private int numCuenta;
    private float saldo;
    private String fechaApertura;

    public Cuenta(int numCuenta, float saldo, String fechaApertura) {
        this.numCuenta = numCuenta;
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
        hash = 59 * hash + this.numCuenta;
        hash = 59 * hash + Float.floatToIntBits(this.saldo);
        hash = 59 * hash + Objects.hashCode(this.fechaApertura);
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
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        return Objects.equals(this.fechaApertura, other.fechaApertura);
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + '}';
    }

    
    
    
}

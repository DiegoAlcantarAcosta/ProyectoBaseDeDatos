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
    private String fechaApertura, contraseña, estado;

    public Cuenta(int numCuenta, float saldo, String fechaApertura, String contraseña, String estado) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Cuenta(float saldo, String fechaApertura, String contraseña, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Cuenta() {
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.numCuenta;
        hash = 19 * hash + Float.floatToIntBits(this.saldo);
        hash = 19 * hash + Objects.hashCode(this.fechaApertura);
        hash = 19 * hash + Objects.hashCode(this.contraseña);
        hash = 19 * hash + Objects.hashCode(this.estado);
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
        if (!Objects.equals(this.fechaApertura, other.fechaApertura)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + ", contrase\u00f1a=" + contraseña + ", estado=" + estado + '}';
    }
    
    
}

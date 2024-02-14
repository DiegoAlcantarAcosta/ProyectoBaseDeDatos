/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class Operaciones {
    private int idTransaccion;
    private String tipo, fecha;
    private float monto;

    public Operaciones(int idTransaccion, String tipo, String fecha, float monto) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Operaciones(String tipo, String fecha, float monto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Operaciones() {
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idTransaccion;
        hash = 79 * hash + Objects.hashCode(this.tipo);
        hash = 79 * hash + Objects.hashCode(this.fecha);
        hash = 79 * hash + Float.floatToIntBits(this.monto);
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
        final Operaciones other = (Operaciones) obj;
        if (this.idTransaccion != other.idTransaccion) {
            return false;
        }
        if (Float.floatToIntBits(this.monto) != Float.floatToIntBits(other.monto)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        return "Operaciones{" + "idTransaccion=" + idTransaccion + ", tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto + '}';
    }

    
    
    
}

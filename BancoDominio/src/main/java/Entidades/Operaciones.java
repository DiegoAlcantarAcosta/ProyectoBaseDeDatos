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
    private String tipo, fecha, folio;
    private float monto;
    private Cuenta cuenta;

    public Operaciones(int idTransaccion, String tipo, String fecha, String folio, float monto, Cuenta cuenta) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.folio = folio;
        this.monto = monto;
        this.cuenta = cuenta;
    }

    public Operaciones(String tipo, String fecha, String folio, float monto, Cuenta cuenta) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.folio = folio;
        this.monto = monto;
        this.cuenta = cuenta;
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

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idTransaccion;
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + Objects.hashCode(this.folio);
        hash = 23 * hash + Float.floatToIntBits(this.monto);
        hash = 23 * hash + Objects.hashCode(this.cuenta);
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
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        return Objects.equals(this.cuenta, other.cuenta);
    }

    @Override
    public String toString() {
        return "Operaciones{" + "idTransaccion=" + idTransaccion + ", tipo=" + tipo + ", fecha=" + fecha + ", folio=" + folio + ", monto=" + monto + ", cuenta=" + cuenta + '}';
    }
    
    
}

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
public class SinCuenta {
   private int idSinCuenta;
   private String folio, contraseña;
   private Operaciones operacion;

    public SinCuenta(int idSinCuenta, String folio, String contraseña, Operaciones operacion) {
        this.idSinCuenta = idSinCuenta;
        this.folio = folio;
        this.contraseña = contraseña;
        this.operacion = operacion;
    }

    public SinCuenta(String folio, String contraseña, Operaciones operacion) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.operacion = operacion;
    }

    public SinCuenta() {
    }

    public int getIdSinCuenta() {
        return idSinCuenta;
    }

    public void setIdSinCuenta(int idSinCuenta) {
        this.idSinCuenta = idSinCuenta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Operaciones getOperacion() {
        return operacion;
    }

    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idSinCuenta;
        hash = 47 * hash + Objects.hashCode(this.folio);
        hash = 47 * hash + Objects.hashCode(this.contraseña);
        hash = 47 * hash + Objects.hashCode(this.operacion);
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
        final SinCuenta other = (SinCuenta) obj;
        if (this.idSinCuenta != other.idSinCuenta) {
            return false;
        }
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        return Objects.equals(this.operacion, other.operacion);
    }

    @Override
    public String toString() {
        return "SinCuenta{" + "idSinCuenta=" + idSinCuenta + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + ", operacion=" + operacion + '}';
    }
   
   
}

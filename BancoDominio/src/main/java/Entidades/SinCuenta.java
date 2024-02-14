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
public class SinCuenta extends Operaciones {
    private int idSinCuenta;
    private String folio;
    private int contraseña;

    public SinCuenta(int idRetiro, String folio, int contraseña, String tipo, String fecha, float monto) {
        super(tipo, fecha, monto);
        this.idSinCuenta = idRetiro;
        this.folio = folio;
        this.contraseña = contraseña;
    }

    // Constructor con datos y sin llave primaria
    public SinCuenta(String folio, int contraseña, String tipo, String fecha, float monto) {
        super(tipo, fecha, monto);
        this.folio = folio;
        this.contraseña = contraseña;
    }

    // Constructor sin datos ni llave primaria
    public SinCuenta() {
        super();
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

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idSinCuenta;
        hash = 23 * hash + Objects.hashCode(this.folio);
        hash = 23 * hash + this.contraseña;
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
        if (this.contraseña != other.contraseña) {
            return false;
        }
        return Objects.equals(this.folio, other.folio);
    }

    @Override
    public String toString() {
        return "SinCuenta{" + "idSinCuenta=" + idSinCuenta + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
}

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

    private String folio;
    private int contraseña;

    public SinCuenta(int idTransaccion, String tipo, String fecha, float monto, String folio, int contraseña) {
        super(idTransaccion, tipo, fecha, monto);
        this.folio = folio;
        this.contraseña = contraseña;
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.folio);
        hash = 97 * hash + this.contraseña;
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
        if (this.contraseña != other.contraseña) {
            return false;
        }
        return Objects.equals(this.folio, other.folio);
    }

    @Override
    public String toString() {
        return "SinCuenta{" + "folio=" + folio + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}

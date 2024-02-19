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
    private int idSinCuenta,folio;
    private String estado;
    private int contraseña;

    public SinCuenta(int idSinCuenta, int folio, String estado, int contraseña, int idTransaccion, int idCuenta, String tipo, String fecha, float monto) {
        super(idTransaccion, idCuenta, tipo, fecha, monto);
        this.idSinCuenta = idSinCuenta;
        this.folio = folio;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    public SinCuenta(int folio, String estado, int contraseña, int idCuenta, String tipo, String fecha, float monto) {
        super(idCuenta, tipo, fecha, monto);
        this.folio = folio;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    public SinCuenta(int folio, String estado, int idCuenta, String tipo, String fecha, float monto) {
        super(idCuenta, tipo, fecha, monto);
        this.folio = folio;
        this.estado = estado;
    }
    
    

    public SinCuenta() {
        super();
    }

    public int getIdSinCuenta() {
        return idSinCuenta;
    }

    public void setIdSinCuenta(int idSinCuenta) {
        this.idSinCuenta = idSinCuenta;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    

    
    
    
    
}

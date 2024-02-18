/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class RetiroSinDTO extends OperacionesDTO{
    private int folio;
    private String estado;
    private int contraseña;

    // Constructor
    public RetiroSinDTO(int idCuenta,int folio, int contraseña, String tipo, String fecha, float monto, String estado) {
        super(idCuenta,tipo, fecha, monto);
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
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

    @Override
    public String toString() {
        return "RetiroSinDTO{" + "folio=" + folio + ", estado=" + estado + ", contrase\u00f1a=" + contraseña + '}';
    }

    
    
}

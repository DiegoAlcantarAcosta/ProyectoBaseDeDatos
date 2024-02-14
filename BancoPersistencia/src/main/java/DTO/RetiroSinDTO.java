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
    private String folio;
    private int contraseña;

    // Constructor
    public RetiroSinDTO(String folio, int contraseña, String tipo, String fecha, float monto) {
        super(tipo, fecha, monto);
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
    public String toString() {
        return "RetiroSinDTO{" + "folio=" + folio + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}

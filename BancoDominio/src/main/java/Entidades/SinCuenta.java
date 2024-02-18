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

    public SinCuenta() {
        super();
    }

    

    
    
    
    
}

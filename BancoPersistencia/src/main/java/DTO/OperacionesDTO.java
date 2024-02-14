/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Cuenta;

/**
 *
 * @author lv1821
 */
public class OperacionesDTO {

    private String tipo, fecha;
    private float monto;

    public OperacionesDTO(String tipo, String fecha, float monto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
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
    public String toString() {
        return "OperacionesDTO{" + "tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto + '}';
    }
    
    

    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Cliente;

/**
 *
 * @author lv1821
 */
public class CuentaDTO {
    private float saldo;
    private String fechaApertura, estado;

    public CuentaDTO(float saldo, String fechaApertura, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }


    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

  

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CuentaDTO{" + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura  + ", estado=" + estado + '}';
    }

    
    
    
    
}

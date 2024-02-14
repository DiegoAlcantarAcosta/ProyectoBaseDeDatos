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
     private int numCuenta;
    private float saldo;
    private String fechaApertura, estado;

    public CuentaDTO(int numCuenta, float saldo, String fechaApertura, String estado) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
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
        return "CuentaDTO{" + "numCuenta=" + numCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura  + ", estado=" + estado + '}';
    }

    
    
    
    
}

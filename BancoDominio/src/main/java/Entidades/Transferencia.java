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
public class Transferencia {
    private int idTransferencia;
    private Cuenta cuentaDeposito;
    private Operaciones operacion;

    public Transferencia(int idTransferencia, Cuenta cuentaDeposito, Operaciones operacion) {
        this.idTransferencia = idTransferencia;
        this.cuentaDeposito = cuentaDeposito;
        this.operacion = operacion;
    }

    public Transferencia(Cuenta cuentaDeposito, Operaciones operacion) {
        this.cuentaDeposito = cuentaDeposito;
        this.operacion = operacion;
    }

    public Transferencia() {
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public Cuenta getCuentaDeposito() {
        return cuentaDeposito;
    }

    public void setCuentaDeposito(Cuenta cuentaDeposito) {
        this.cuentaDeposito = cuentaDeposito;
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
        hash = 97 * hash + this.idTransferencia;
        hash = 97 * hash + Objects.hashCode(this.cuentaDeposito);
        hash = 97 * hash + Objects.hashCode(this.operacion);
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
        final Transferencia other = (Transferencia) obj;
        if (this.idTransferencia != other.idTransferencia) {
            return false;
        }
        if (!Objects.equals(this.cuentaDeposito, other.cuentaDeposito)) {
            return false;
        }
        return Objects.equals(this.operacion, other.operacion);
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", cuentaDeposito=" + cuentaDeposito + ", operacion=" + operacion + '}';
    }
    
    
    
}

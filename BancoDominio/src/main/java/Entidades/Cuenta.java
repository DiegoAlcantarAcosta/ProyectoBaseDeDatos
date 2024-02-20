/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Entidades;

import java.util.Objects;

/**
 * La clase Cuenta representa una cuenta asociada a un cliente en el sistema.
 * Contiene información como el identificador, número de cuenta, saldo, fecha de apertura, etc.
 *
 * @author lv1821
 */
public class Cuenta {
    private int idCuenta,numCuenta, idCliente;
    private float saldo;
    private String fechaApertura;

    /**
     * Constructor que crea un nuevo objeto Cuenta con todos los atributos.
     *
     * @param idCuenta       Identificador único de la cuenta.
     * @param numCuenta      Número de la cuenta.
     * @param idCliente      Identificador único del cliente asociado a la cuenta.
     * @param saldo          Saldo actual de la cuenta.
     * @param fechaApertura  Fecha de apertura de la cuenta en formato de cadena.
     */
    public Cuenta(int idCuenta, int numCuenta, int idCliente, float saldo, String fechaApertura) {
        this.idCuenta = idCuenta;
        this.numCuenta = numCuenta;
        this.idCliente = idCliente;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    /**
     * Constructor que crea un nuevo objeto Cuenta sin el identificador único de la cuenta.
     *
     * @param numCuenta      Número de la cuenta.
     * @param idCliente      Identificador único del cliente asociado a la cuenta.
     * @param saldo          Saldo actual de la cuenta.
     * @param fechaApertura  Fecha de apertura de la cuenta en formato de cadena.
     */
    public Cuenta(int numCuenta, int idCliente, float saldo, String fechaApertura) {
        this.numCuenta = numCuenta;
        this.idCliente = idCliente;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    /**
     * Constructor por defecto que crea un nuevo objeto Cuenta sin atributos inicializados.
     */
    public Cuenta() {
    }

    /**
     * Obtiene el identificador único de la cuenta.
     *
     * @return El identificador único de la cuenta.
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el identificador único de la cuenta.
     *
     * @param idCuenta El identificador único de la cuenta.
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene el número de la cuenta.
     *
     * @return El número de la cuenta.
     */
    public int getNumCuenta() {
        return numCuenta;
    }

    /**
     * Establece el número de la cuenta.
     *
     * @param numCuenta El número de la cuenta.
     */
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Obtiene el identificador único del cliente asociado a la cuenta.
     *
     * @return El identificador único del cliente asociado a la cuenta.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador único del cliente asociado a la cuenta.
     *
     * @param idCliente El identificador único del cliente asociado a la cuenta.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return El saldo actual de la cuenta.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo actual de la cuenta.
     *
     * @param saldo El saldo actual de la cuenta.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene la fecha de apertura de la cuenta.
     *
     * @return La fecha de apertura de la cuenta en formato de cadena.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     *
     * @param fechaApertura La fecha de apertura de la cuenta en formato de cadena.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Genera un código hash único para el objeto Cuenta basado en sus atributos.
     *
     * @return El código hash del objeto Cuenta.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idCuenta;
        hash = 31 * hash + this.numCuenta;
        hash = 31 * hash + this.idCliente;
        hash = 31 * hash + Float.floatToIntBits(this.saldo);
        hash = 31 * hash + Objects.hashCode(this.fechaApertura);
        return hash;
    }

    /**
     * Compara el objeto Cuenta actual con otro objeto para verificar su igualdad.
     *
     * @param obj El objeto a comparar con la Cuenta actual.
     * @return true si los objetos son iguales, false en caso contrario.
     */
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
        final Cuenta other = (Cuenta) obj;
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (this.numCuenta != other.numCuenta) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        return Objects.equals(this.fechaApertura, other.fechaApertura);
    }

    /**
     * Retorna una representación de cadena del objeto Cuenta.
     *
     * @return Una cadena que representa la Cuenta, incluyendo sus atributos.
     */
    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", numCuenta=" + numCuenta + ", idCliente=" + idCliente + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + '}';
    }
}

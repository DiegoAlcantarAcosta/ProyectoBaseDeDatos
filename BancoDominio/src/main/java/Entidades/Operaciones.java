/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 * La clase Operaciones representa las transacciones realizadas en una cuenta, con información como el identificador de la transacción, 
 * identificador de la cuenta asociada, tipo de operación, fecha y monto involucrado.
 * 
 * @author lv1821
 */
public class Operaciones {
    private int idTransaccion, idCuenta;
    private String tipo, fecha;
    private float monto;

    /**
     * Constructor que crea un nuevo objeto Operaciones con todos los atributos.
     *
     * @param idTransaccion Identificador único de la transacción.
     * @param idCuenta Identificador único de la cuenta asociada a la transacción.
     * @param tipo Tipo de operación realizada.
     * @param fecha Fecha en la que se realizó la operación en formato de cadena.
     * @param monto Monto involucrado en la operación.
     */
    public Operaciones(int idTransaccion, int idCuenta, String tipo, String fecha, float monto) {
        this.idTransaccion = idTransaccion;
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    /**
     * Constructor que crea un nuevo objeto Operaciones sin el identificador único de la transacción.
     *
     * @param idCuenta Identificador único de la cuenta asociada a la transacción.
     * @param tipo Tipo de operación realizada.
     * @param fecha Fecha en la que se realizó la operación en formato de cadena.
     * @param monto Monto involucrado en la operación.
     */
    public Operaciones(int idCuenta, String tipo, String fecha, float monto) {
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    /**
     * Constructor por defecto que crea un nuevo objeto Operaciones sin atributos inicializados.
     */
    public Operaciones() {
    }
    
    /**
     * Obtiene el identificador único de la transacción.
     *
     * @return El identificador único de la transacción.
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Establece el identificador único de la transacción.
     *
     * @param idTransaccion El identificador único de la transacción.
     */
    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Obtiene el identificador único de la cuenta asociada a la transacción.
     *
     * @return El identificador único de la cuenta asociada a la transacción.
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el identificador único de la cuenta asociada a la transacción.
     *
     * @param idCuenta El identificador único de la cuenta asociada a la transacción.
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene el tipo de operación realizada.
     *
     * @return El tipo de operación realizada.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de operación realizada.
     *
     * @param tipo El tipo de operación realizada.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la fecha en la que se realizó la operación.
     *
     * @return La fecha en la que se realizó la operación en formato de cadena.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realizó la operación.
     *
     * @param fecha La fecha en la que se realizó la operación en formato de cadena.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el monto involucrado en la operación.
     *
     * @return El monto involucrado en la operación.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto involucrado en la operación.
     *
     * @param monto El monto involucrado en la operación.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Genera un código hash único para el objeto Operaciones basado en sus atributos.
     *
     * @return El código hash del objeto Operaciones.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idTransaccion;
        hash = 53 * hash + this.idCuenta;
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + Objects.hashCode(this.fecha);
        hash = 53 * hash + Float.floatToIntBits(this.monto);
        return hash;
    }

    /**
     * Compara el objeto Operaciones actual con otro objeto para verificar su igualdad.
     *
     * @param obj El objeto a comparar con Operaciones actual.
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
        final Operaciones other = (Operaciones) obj;
        if (this.idTransaccion != other.idTransaccion) {
            return false;
        }
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (Float.floatToIntBits(this.monto) != Float.floatToIntBits(other.monto)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    /**
     * Retorna una representación de cadena del objeto Operaciones.
     *
     * @return Una cadena que representa Operaciones, incluyendo sus atributos.
     */
    @Override
    public String toString() {
        return "Operaciones{" + "idTransaccion=" + idTransaccion + ", idCuenta=" + idCuenta + ", tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto + '}';
    }
}

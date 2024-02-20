/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * La clase Transferencia extiende la clase Operaciones y representa una transferencia de fondos entre dos cuentas.
 * Contiene información adicional como identificador de transferencia y cuenta de destino.
 * Hereda atributos y métodos de la clase Operaciones.
 * 
 * @author pc
 */
public class Transferencia extends Operaciones{
    private int idTransferencia;
    private int cuentaDestino;
    
    /**
     * Constructor que crea un nuevo objeto Transferencia con todos los atributos.
     *
     * @param idTransferencia Identificador único de la transferencia.
     * @param idCuenta        Identificador único de la cuenta de origen.
     * @param idCuentaDestino Identificador único de la cuenta de destino.
     * @param tipo            Tipo de la operación.
     * @param fecha           Fecha de la operación en formato de cadena.
     * @param monto           Monto de la operación.
     */
    public Transferencia(int idTransferencia,int idCuenta, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(idCuenta,tipo, fecha, monto);
        this.idTransferencia = idTransferencia;
        this.cuentaDestino = idCuentaDestino;
    }


    /**
     * Constructor que crea un nuevo objeto Transferencia sin el identificador único de la transferencia.
     *
     * @param idCuenta        Identificador único de la cuenta de origen.
     * @param idCuentaDestino Identificador único de la cuenta de destino.
     * @param tipo            Tipo de la operación.
     * @param fecha           Fecha de la operación en formato de cadena.
     * @param monto           Monto de la operación.
     */
    public Transferencia(int idCuenta, int idCuentaDestino, String tipo, String fecha, float monto) {
        super(idCuenta,tipo, fecha, monto);
        this.cuentaDestino = idCuentaDestino;
    }
    
    /**
     * Constructor que crea un nuevo objeto Transferencia con solo identificador de cuentas y monto.
     *
     * @param idCuenta        Identificador único de la cuenta de origen.
     * @param idCuentaDestino Identificador único de la cuenta de destino.
     * @param monto           Monto de la operación.
     */
    public Transferencia(int idCuenta, int idCuentaDestino, float monto){
        
    }

    /**
     * Constructor por defecto que crea un nuevo objeto Transferencia sin atributos inicializados.
     */
    public Transferencia() {
        super();
    }

    /**
     * Obtiene el identificador único de la transferencia.
     *
     * @return El identificador único de la transferencia.
     */
    public int getIdTransferencia() {
        return idTransferencia;
    }

    /**
     * Establece el identificador único de la transferencia.
     *
     * @param idTransferencia El identificador único de la transferencia.
     */
    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    /**
     * Obtiene el identificador de la cuenta de destino.
     *
     * @return El identificador de la cuenta de destino.
     */
    public int getCuentaDestino() {
        return cuentaDestino;
    }

    /**
     * Establece el identificador de la cuenta de destino.
     *
     * @param cuentaDestino El identificador de la cuenta de destino.
     */
    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    /**
     * No se documenta el método hashCode() ya que hereda de la clase Operaciones.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.idTransferencia;
        hash = 23 * hash + this.cuentaDestino;
        return hash;
    }

    /**
     * No se documenta el método equals() ya que hereda de la clase Operaciones.
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
        final Transferencia other = (Transferencia) obj;
        if (this.idTransferencia != other.idTransferencia) {
            return false;
        }
        return this.cuentaDestino == other.cuentaDestino;
    }

    /**
     * Retorna una representación de cadena del objeto Transferencia.
     *
     * @return Una cadena que representa la Transferencia, incluyendo sus atributos.
     */
    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", cuentaDestino=" + cuentaDestino + '}';
    }
}

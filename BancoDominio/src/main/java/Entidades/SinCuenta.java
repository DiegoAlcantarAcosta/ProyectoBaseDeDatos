/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * La clase SinCuenta extiende la clase Operaciones y representa operaciones especiales sin una cuenta asociada.
 * Contiene información adicional como identificador SinCuenta, folio, estado y contraseña.
 * Hereda atributos y métodos de la clase Operaciones.
 * 
 * @author pc
 */
public class SinCuenta extends Operaciones {
    private int idSinCuenta,folio;
    private String estado;
    private int contraseña;

    /**
     * Constructor que crea un nuevo objeto SinCuenta con todos los atributos.
     *
     * @param idSinCuenta   Identificador único de SinCuenta.
     * @param folio         Número de folio asociado a SinCuenta.
     * @param estado        Estado actual de SinCuenta.
     * @param contraseña    Contraseña asociada a SinCuenta.
     * @param idTransaccion Identificador único de la transacción.
     * @param idCuenta      Identificador único de la cuenta asociada.
     * @param tipo          Tipo de la operación.
     * @param fecha         Fecha de la operación en formato de cadena.
     * @param monto         Monto de la operación.
     */
    public SinCuenta(int idSinCuenta, int folio, String estado, int contraseña, int idTransaccion, int idCuenta, String tipo, String fecha, float monto) {
        super(idTransaccion, idCuenta, tipo, fecha, monto);
        this.idSinCuenta = idSinCuenta;
        this.folio = folio;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    /**
     * Constructor que crea un nuevo objeto SinCuenta sin el identificador único de SinCuenta.
     *
     * @param folio         Número de folio asociado a SinCuenta.
     * @param estado        Estado actual de SinCuenta.
     * @param contraseña    Contraseña asociada a SinCuenta.
     * @param idCuenta      Identificador único de la cuenta asociada.
     * @param tipo          Tipo de la operación.
     * @param fecha         Fecha de la operación en formato de cadena.
     * @param monto         Monto de la operación.
     */
    public SinCuenta(int folio, String estado, int contraseña, int idCuenta, String tipo, String fecha, float monto) {
        super(idCuenta, tipo, fecha, monto);
        this.folio = folio;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    /**
     * Constructor que crea un nuevo objeto SinCuenta sin contraseña.
     *
     * @param folio         Número de folio asociado a SinCuenta.
     * @param estado        Estado actual de SinCuenta.
     * @param idCuenta      Identificador único de la cuenta asociada.
     * @param tipo          Tipo de la operación.
     * @param fecha         Fecha de la operación en formato de cadena.
     * @param monto         Monto de la operación.
     */
    public SinCuenta(int folio, String estado, int idCuenta, String tipo, String fecha, float monto) {
        super(idCuenta, tipo, fecha, monto);
        this.folio = folio;
        this.estado = estado;
    }
    
    /**
     * Constructor por defecto que crea un nuevo objeto SinCuenta sin atributos inicializados.
     */
    public SinCuenta() {
        super();
    }

    /**
     * Obtiene el identificador único de SinCuenta.
     *
     * @return El identificador único de SinCuenta.
     */
    public int getIdSinCuenta() {
        return idSinCuenta;
    }

    /**
     * Establece el identificador único de SinCuenta.
     *
     * @param idSinCuenta El identificador único de SinCuenta.
     */
    public void setIdSinCuenta(int idSinCuenta) {
        this.idSinCuenta = idSinCuenta;
    }

    /**
     * Obtiene el número de folio asociado a SinCuenta.
     *
     * @return El número de folio asociado a SinCuenta.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Establece el número de folio asociado a SinCuenta.
     *
     * @param folio El número de folio asociado a SinCuenta.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Obtiene el estado actual de SinCuenta.
     *
     * @return El estado actual de SinCuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de SinCuenta.
     *
     * @param estado El estado actual de SinCuenta.
     */

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la contraseña asociada a SinCuenta.
     *
     * @return La contraseña asociada a SinCuenta.
     */
    public int getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña asociada a SinCuenta.
     *
     * @param contraseña La contraseña asociada a SinCuenta.
     */
    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para operaciones de retiro sin cuenta.
 * Hereda de la clase OperacionesDTO.
 * Contiene atributos específicos como folio, estado y contraseña.
 * 
 * @author pc
 */
public class RetiroSinDTO extends OperacionesDTO{
    private int folio;
    private String estado;
    private int contraseña;

   /**
     * Constructor que recibe los atributos de un retiro sin cuenta.
     * 
     * @param idCuenta Identificador de la cuenta asociada al retiro sin cuenta.
     * @param folio Folio del retiro sin cuenta.
     * @param contraseña Contraseña asociada al retiro sin cuenta.
     * @param tipo Tipo de la operación.
     * @param fecha Fecha de la operación.
     * @param monto Monto de la operación.
     * @param estado Estado del retiro sin cuenta.
     */
    public RetiroSinDTO(int idCuenta,int folio, int contraseña, String tipo, String fecha, float monto, String estado) {
        super(idCuenta,tipo, fecha, monto);
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    /**
     * Método getter para obtener el folio del retiro sin cuenta.
     * 
     * @return Folio del retiro sin cuenta.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Método setter para establecer el folio del retiro sin cuenta.
     * 
     * @param folio Nuevo folio del retiro sin cuenta.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Método getter para obtener el estado del retiro sin cuenta.
     * 
     * @return Estado del retiro sin cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado del retiro sin cuenta.
     * 
     * @param estado Nuevo estado del retiro sin cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método getter para obtener la contraseña asociada al retiro sin cuenta.
     * 
     * @return Contraseña del retiro sin cuenta.
     */
    public int getContraseña() {
        return contraseña;
    }

    /**
     * Método setter para establecer la contraseña asociada al retiro sin cuenta.
     * 
     * @param contraseña Nueva contraseña del retiro sin cuenta.
     */
    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Método toString para obtener una representación en cadena del objeto RetiroSinDTO.
     * 
     * @return Cadena que representa el objeto RetiroSinDTO.
     */
    @Override
    public String toString() {
        return "RetiroSinDTO{" + "folio=" + folio + ", estado=" + estado + ", contrase\u00f1a=" + contraseña + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Clase de excepción personalizada para manejar errores relacionados con la persistencia de datos.
 * Se utiliza para indicar problemas al interactuar con la capa de persistencia o la base de datos.
 * 
 * La clase extiende la clase Exception de Java.
 * 
 * @author lv1821
 */
public class PersistenciaExcepcion extends Exception {

    /**
     * Constructor sin parámetros.
     */
    public PersistenciaExcepcion() {
    }

    /**
     * Constructor que recibe un mensaje de error.
     * 
     * @param message Mensaje de error.
     */
    public PersistenciaExcepcion(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y una causa subyacente.
     * 
     * @param message Mensaje de error.
     * @param cause Causa subyacente.
     */
    public PersistenciaExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa subyacente.
     * 
     * @param cause Causa subyacente.
     */
    public PersistenciaExcepcion(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que recibe un mensaje de error, una causa subyacente,
     * un indicador de supresión de habilitación y un indicador de escribibilidad de rastreo.
     * 
     * @param message Mensaje de error.
     * @param cause Causa subyacente.
     * @param enableSuppression Indicador de supresión de habilitación.
     * @param writableStackTrace Indicador de escribibilidad de rastreo.
     */
    public PersistenciaExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

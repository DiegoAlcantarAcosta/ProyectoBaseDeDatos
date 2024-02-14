/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author lv1821
 */
public class PersistenciaExcepcion extends Exception{

    public PersistenciaExcepcion() {
    }

    public PersistenciaExcepcion(String message) {
        super(message);
    }

    public PersistenciaExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenciaExcepcion(Throwable cause) {
        super(cause);
    }

    public PersistenciaExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

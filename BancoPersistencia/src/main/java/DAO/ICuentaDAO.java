/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.CuentaDTO;
import Entidades.Cuenta;

/**
 * Interface que define las operaciones de acceso a datos para las cuentas.
 * Las clases que implementen esta interfaz proporcionarán la lógica para interactuar
 * con la capa de persistencia y obtener información sobre las cuentas.
 *
 * @author lv1821
 */
public interface ICuentaDAO {

    /**
     * Obtiene la información de una cuenta mediante su número.
     *
     * @param numeroCuenta Número de la cuenta.
     * @return Objeto de tipo CuentaDTO que contiene la información de la cuenta.
     */
    CuentaDTO obtenerCuenta(int numeroCuenta);

    /**
     * Obtiene el número de cuenta asociado a una cuenta.
     *
     * @param cuenta Objeto de tipo Cuenta del cual se desea obtener el número de cuenta.
     * @return Número de cuenta asociado al objeto Cuenta.
     */
    int numeroCuenta(Cuenta cuenta);

    /**
     * Actualiza el estado de una cuenta.
     *
     * @param cuenta Número de cuenta que se desea actualizar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    boolean actualizarEstadoCuenta(int cuenta);

    /**
     * Crea una nueva cuenta.
     *
     * @param cuenta Objeto de tipo Cuenta que se desea crear.
     * @param num Número de cuenta asignado.
     * @return true si la creación fue exitosa, false en caso contrario.
     */
    boolean crearCuenta(Cuenta cuenta,int num);
    
    /**
     * Crea una nueva cuenta asociada a un cliente existente.
     *
     * @param cuenta Objeto de tipo Cuenta que se desea crear.
     * @param id ID del cliente al cual se asociará la nueva cuenta.
     * @param numCuenta Número de cuenta asignado.
     * @return true si la creación fue exitosa, false en caso contrario.
     */
    boolean crearCuentaNueva(Cuenta cuenta, int id, int numCuenta);

    /**
     * Incrementa el monto de una cuenta.
     *
     * @param cuenta Número de cuenta al cual se incrementará el monto.
     * @param monto Monto que se sumará a la cuenta.
     */
    void sumarMonto(int cuenta,float monto);
    
    /**
     * Obtiene el ID de una cuenta mediante su fecha de apertura.
     *
     * @param fecha Fecha de apertura de la cuenta.
     * @return ID de la cuenta asociada a la fecha especificada.
     */
    int idCuenta(String fecha);
    
    /**
     * Obtiene el ID de una cuenta mediante su número de cuenta.
     *
     * @param numCuenta Número de cuenta.
     * @return ID de la cuenta asociada al número de cuenta especificado.
     */
    public int idCuenta(int numCuenta);
}

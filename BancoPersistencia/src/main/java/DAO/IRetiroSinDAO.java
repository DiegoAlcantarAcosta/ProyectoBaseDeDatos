/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.RetiroSinDTO;
import java.sql.SQLException;

/**
 * Interface que define las operaciones de acceso a datos para los retiros sin
 * cuenta. Las clases que implementen esta interfaz proporcionarán la lógica
 * para interactuar con la capa de persistencia y realizar operaciones
 * relacionadas con los retiros sin cuenta.
 *
 * @author pc
 */
public interface IRetiroSinDAO {

    /**
     * Autentica el cobro de un retiro sin cuenta mediante el folio y la contraseña asociados.
     *
     * @param folio Número de folio del retiro sin cuenta.
     * @param contraseña Contraseña asociada al retiro sin cuenta.
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
    public boolean autenticarCobro(int folio, int contraseña);

    /**
     * Genera un retiro sin cuenta y almacena la información asociada en la base de datos.
     *
     * @param sin Objeto de tipo RetiroSinDTO que contiene la información del retiro sin cuenta.
     * @param num Número asociado al retiro sin cuenta.
     * @return true si el retiro sin cuenta se genera exitosamente, false en caso contrario.
     */
    public boolean generarSinCuenta(RetiroSinDTO sin, int num);

    /**
     * Genera una nueva contraseña para un retiro sin cuenta.
     *
     * @return Nueva contraseña generada.
     */
    public int generarContraseña();

    /**
     * Actualiza el estado de un retiro sin cuenta asociado a un número de cuenta.
     *
     * @param numCuenta Número de cuenta asociado al retiro sin cuenta.
     * @throws SQLException Si ocurre un error durante la actualización del estado.
     */
    public void actualizarEstado(int numCuenta) throws SQLException;

    /**
     * Obtiene el folio asociado al retiro sin cuenta.
     *
     * @return Número de folio del retiro sin cuenta.
     */
    public int obtenerFolio();

    /**
     * Realiza un evento relacionado con los retiros sin cuenta.
     */
    public void evento();

    /**
     * Obtiene el ID de un retiro sin cuenta mediante el folio y la contraseña asociados.
     *
     * @param folio Número de folio del retiro sin cuenta.
     * @param contraseña Contraseña asociada al retiro sin cuenta.
     * @return ID del retiro sin cuenta asociado al folio y contraseña especificados.
     */
    public int idRetiro(int folio, int contraseña);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.TransferenciaDTO;
import java.sql.SQLException;

/**
 * Interface que define las operaciones de acceso a datos para las transferencias.
 * Las clases que implementen esta interfaz proporcionarán la lógica para interactuar
 * con la capa de persistencia y realizar operaciones relacionadas con las transferencias.
 * 
 * @author pc
 */
public interface ITransferenciaDAO {

    /**
     * Realiza una transferencia y almacena la información asociada en la base de datos.
     *
     * @param trans Objeto de tipo TransferenciaDTO que contiene la información de la transferencia.
     * @return Objeto TransferenciaDTO con detalles de la transferencia realizada.
     * @throws SQLException Si ocurre un error durante la realización de la transferencia.
     */
    TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) throws SQLException;

    /**
     * Deposita un monto en una cuenta específica y actualiza la información en la base de datos.
     *
     * @param cuenta Número de cuenta en la que se realizará el depósito.
     * @param monto Monto a depositar en la cuenta.
     * @return true si el depósito se realiza exitosamente, false en caso contrario.
     * @throws SQLException Si ocurre un error durante el depósito.
     */
    boolean depositar(int cuenta, float monto) throws SQLException;
}

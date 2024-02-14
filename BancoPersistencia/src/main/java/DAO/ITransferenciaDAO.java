/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Transferencia;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ITransferenciaDAO {
    boolean realizarTransferencia(int numeroCuentaOrigen, int numeroCuentaDestino, double monto);
    List<Transferencia> obtenerHistorialTransferencias(int idCliente, Date desde, Date hasta);
}

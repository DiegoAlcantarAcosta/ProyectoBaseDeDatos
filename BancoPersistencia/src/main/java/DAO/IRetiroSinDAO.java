/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.SinCuenta;

/**
 *
 * @author pc
 */
public interface IRetiroSinDAO {
    boolean generarRetiroSinCuenta(int idCliente, double monto);
    SinCuenta obtenerRetiroSinCuenta(int idCliente);
    boolean actualizarEstadoRetiroSinCuenta(int idCliente, String estado);
}

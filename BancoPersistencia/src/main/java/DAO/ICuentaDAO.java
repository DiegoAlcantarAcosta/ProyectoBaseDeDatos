/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Cuenta;

/**
 *
 * @author lv1821
 */
public interface ICuentaDAO {

    Cuenta obtenerCuenta(int numeroCuenta);

    int numeroCuenta(Cuenta cuenta);

    boolean actualizarEstadoCuenta(int cuenta, int contraseña);

    Cuenta crearCuenta(Cuenta cuenta);
    
    Cuenta crearCuentaNueva(Cuenta cuenta, int contraseña);

    void sumarMonto(int cuenta,float monto);
}

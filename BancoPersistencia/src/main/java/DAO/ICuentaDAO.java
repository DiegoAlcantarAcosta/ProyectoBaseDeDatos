/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.CuentaDTO;
import Entidades.Cuenta;

/**
 *
 * @author lv1821
 */
public interface ICuentaDAO {

    CuentaDTO obtenerCuenta(int numeroCuenta);

    int numeroCuenta(Cuenta cuenta);

    boolean actualizarEstadoCuenta(int cuenta);

    boolean crearCuenta(Cuenta cuenta,int num);
    
    boolean crearCuentaNueva(Cuenta cuenta, int id, int numCuenta);

    void sumarMonto(int cuenta,float monto);
    int idCuenta(String Fecha);
    public int idCuenta(int numCuenta);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.RetiroSinDTO;
import Entidades.SinCuenta;

/**
 *
 * @author pc
 */
public interface IRetiroSinDAO {
    public boolean autenticarCobro(String folio, int contraseña);
    public SinCuenta generarSinCuenta(RetiroSinDTO sin);
    public String generarFolio();
    public int generarContraseña();
    public boolean actualizarEstado();
}

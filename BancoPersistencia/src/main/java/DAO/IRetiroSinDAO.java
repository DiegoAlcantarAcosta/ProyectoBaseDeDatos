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
    public boolean autenticarCobro(int folio, int contraseña);
    public boolean generarSinCuenta(RetiroSinDTO sin,int num);
    public int generarContraseña();
    public void actualizarEstado(int numCuenta);
    public int obtenerFolio();
    public void evento();
    public int idRetiro(int folio, int contraseña);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTO.RetiroSinDTO;
import Entidades.SinCuenta;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class RetiroSinDAO implements IRetiroSinDAO {

    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public RetiroSinDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    @Override
    public boolean autenticarCobro(String folio, int contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SinCuenta generarSinCuenta(RetiroSinDTO sin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String generarFolio() {
       Random random = new Random();
        String numero = String.format("%08d", random.nextInt(100000000));
        return numero;
    }

    @Override
    public int generarContraseña() {
        Random random = new Random();
        int numero = 10000000 + random.nextInt(90000000);
        return numero;
    }

    @Override
    public boolean actualizarEstado(int numCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

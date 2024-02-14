/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Conexion.IConexion;
import DTO.CuentaDTO;
import Excepciones.PersistenciaExcepcion;
import java.util.List;

/**
 *
 * @author Diego
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaExcepcion {

        String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String contraseña = "2004";

        IConexion conexion = new Conexion(cadenaConexion, usuario, contraseña);

        IClienteDAO c = new ClienteDAO(conexion);

        List<CuentaDTO> c2 = c.obtenerCuentasCliente(1);

        for (int i = 0; i < c2.size(); i++) {
            System.out.println(c2.get(i).getNumCuenta());

        }

    }

}

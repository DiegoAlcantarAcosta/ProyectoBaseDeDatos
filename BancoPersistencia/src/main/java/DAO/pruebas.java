/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Conexion.IConexion;
import DTO.CuentaDTO;
import DTO.DireccionDTO;
import DTO.TransferenciaDTO;
import Entidades.Direccion;
import Entidades.Usuario;
import Excepciones.PersistenciaExcepcion;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

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
        String contraseña = "2608jlml";

        IConexion conexion = new Conexion(cadenaConexion, usuario, contraseña);

        IClienteDAO c = new ClienteDAO(conexion);

//        List<CuentaDTO> c2 = c.obtenerCuentasCliente(1);
//
//        for (int i = 0; i < c2.size(); i++) {
//            System.out.println(c2.get(i).getSaldo());
//
//        }
        IUsuarioDAO usuarioTest = new UsuarioDAO(conexion);

//        usuarioTest.registrarUsuario(new Usuario("JUAN ESCUTIA", "21789364"));
//        boolean test = usuarioTest.autenticarUsuario("", "123");
//        System.out.println(test);
        IDireccionDAO direccion = new DireccionDAO(conexion);
//    DireccionDTO d = direccion.obtenerDireccion(1);
//        System.out.println(d.getCalle());

//        Direccion dire = new Direccion("Miguel Aleman", "Norte", "100", "4556");
//        direccion.registrarDireccion(dire);
//        RetiroSinDAO retiro = new RetiroSinDAO();
//        System.out.println(retiro.generarContraseña());
//        System.out.println(retiro.generarFolio());

        ITransferenciaDAO t = new TransferenciaDAO(conexion);
//        TransferenciaDTO te = new TransferenciaDTO(123, 456, "TRANSFERENCIA", "2000-01-03",500);
//        t.realizarTransferencia(te);

//System.out.println(    c.obtenerCliente(1));
// Crear un objeto GregorianCalendar
//        GregorianCalendar calendario = new GregorianCalendar();
//
//        // Obtener el formato deseado
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
//
//        // Obtener la fecha formateada
//        String fechaFormateada = formatoFecha.format(calendario.getTime());
//
//        // Imprimir la fecha formateada
//        System.out.println("Fecha formateada: " + fechaFormateada);

           ICuentaDAO cuenta = new CuentaDAO(conexion);
//           System.out.println(usuarioTest.idUsuario("a", "a"));
        
//           System.out.println(c.idClienteDireccion(1));
int maxDigits = 1000000; // Máximo valor de 6 dígitos
        int minDigits = 100000; // Mínimo valor de 6 dígitos
        Random random = new Random();
        int idCuenta = random.nextInt(maxDigits - minDigits + 1) + minDigits;
        System.out.println("ID de cuenta generado: " + idCuenta);
    }
}

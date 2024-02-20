/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.TransferenciaDTO;
import java.sql.SQLException;


/**
 *
 * @author pc
 */
public interface ITransferenciaDAO {
    TransferenciaDTO realizarTransferencia(TransferenciaDTO trans) throws SQLException;
    boolean depositar(int cuenta, float monto) throws SQLException;
        
}

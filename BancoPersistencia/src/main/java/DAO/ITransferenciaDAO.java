/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.TransferenciaDTO;


/**
 *
 * @author pc
 */
public interface ITransferenciaDAO {
    TransferenciaDTO realizarTransferencia(TransferenciaDTO trans);
    boolean depositar(int cuenta, float monto);
        
}

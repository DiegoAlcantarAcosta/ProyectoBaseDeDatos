/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * Clase para verificar la entrada en un componente de texto y permitir solo números.
 * Extiende la clase InputVerifier.
 * 
 * @author pc
 */
public class NumberInputVerifier extends InputVerifier {

    /**
     * Verifica la entrada en el componente de texto.
     * 
     * @param input el componente de texto a verificar
     * @return true si la entrada es válida (solo números), false de lo contrario
     */
    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        String text = textField.getText();
        return text.matches("\\d+"); // Solo números    }

    }
    }

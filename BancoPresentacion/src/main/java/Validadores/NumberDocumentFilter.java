/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Clase para filtrar e ingresar solo números en un documento de texto.
 *
 * @author pc
 */
public class NumberDocumentFilter extends DocumentFilter {

    /**
     * Inserta texto en el documento, permitiendo solo caracteres numéricos.
     *
     * @param fb el bypass del filtro
     * @param offset la posición en la que se insertará el texto
     * @param string el texto a insertar
     * @param attr los atributos del texto
     * @throws BadLocationException si ocurre un error al insertar el texto
     *
     */
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder(string);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (!Character.isDigit(c)) {
                sb.deleteCharAt(i); // Elimina caracteres no numéricos
            }
        }
        super.insertString(fb, offset, sb.toString(), attr);
    }

    /**
     * Reemplaza texto en el documento, permitiendo solo caracteres numéricos.
     * 
     * @param fb el bypass del filtro
     * @param offset la posición en la que se reemplazará el texto
     * @param length la longitud del texto a reemplazar
     * @param text el nuevo texto a insertar
     * @param attrs los atributos del texto
     * @throws BadLocationException si ocurre un error al reemplazar el texto
     */
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(text);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (!Character.isDigit(c)) {
                sb.deleteCharAt(i); // Elimina caracteres no numéricos
            }
        }
        super.replace(fb, offset, length, sb.toString(), attrs);
    }
}

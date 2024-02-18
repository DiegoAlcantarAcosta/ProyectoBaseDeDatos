/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author pc
 */
public class NumberDocumentFilter extends DocumentFilter {

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

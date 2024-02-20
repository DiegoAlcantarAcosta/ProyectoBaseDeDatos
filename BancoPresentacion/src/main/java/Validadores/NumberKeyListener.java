/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase NumberKeyListener que implementa KeyListener para restringir la entrada
 * en un componente de texto (JTextField) a caracteres numéricos, la tecla de
 * retroceso (BACK_SPACE) y la tecla de suprimir (DELETE).
 */
public class NumberKeyListener implements KeyListener {

    /**
     * Se llama cuando se ha detectado un carácter en el componente de texto.
     * Verifica si el carácter es un dígito o si es una tecla permitida como
     * retroceso o suprimir. Si no es así, consume el evento, evitando que el
     * carácter no deseado se muestre en el componente de texto.
     *
     * @param e Evento KeyEvent generado al presionar una tecla.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            e.consume(); // Ignora los caracteres no numéricos
        }
    }

    /**
     * Se llama cuando una tecla ha sido presionada.
     *
     * @param e Evento KeyEvent generado al presionar una tecla.
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Se llama cuando una tecla ha sido liberada.
     *
     * @param e Evento KeyEvent generado al liberar una tecla.
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

}

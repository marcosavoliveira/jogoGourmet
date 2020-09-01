/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogogourmet;

import javax.swing.JOptionPane;

/**
 *
 * @author marconesio
 */
public class Validacao {
    
public String validarTexto(String texto, String campo, String novaComida, String tipoEsquerda) {
        if (texto == null) {
            texto = "";
        }
        if (texto.isEmpty()) {
            while (texto.isEmpty()) {
                if (campo.equals("novaComida")) {
                    JOptionPane.showMessageDialog(null, "Você deve preencher um valor de comida para prosseguir", "Alerta", JOptionPane.WARNING_MESSAGE);
                    texto = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
                    if (texto == null) {
                        texto = "";
                    }
                }
                if (campo.equals("tipo")) {
                    JOptionPane.showMessageDialog(null, "Você deve preencher um valor de tipo de comida para prosseguir", "Alerta", JOptionPane.WARNING_MESSAGE);
                    texto = JOptionPane.showInputDialog(novaComida + " é ______ mas " + tipoEsquerda + " não.");
                    if (texto == null) {
                        texto = "";
                    }
                }
            }
        }
        return texto;
    }    
}

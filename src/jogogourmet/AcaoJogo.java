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
public class AcaoJogo {
    public InserirComida inserir;
    
    public void perguntar(Comida comida) {
        if(inserir == null){
            inserir= new InserirComida();
        }
        int resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + comida.getTipo() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            if (comida.getDireta() == null) {
                JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
            } else {
                perguntar(comida.getDireta());
            }
        } else {
            if (comida.getEsquerda() == null) {
                inserir.inserirComida(comida);
            } else {
                perguntar(comida.getEsquerda());
            }
        }
    }    
}

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
public class InserirComida {
    public Validacao validacao;
    
    public void inserirComida(Comida comida) {
        if(validacao==null){
            validacao = new Validacao();
        }
        String tipoEsquerda = comida.getTipo();
        String novaComida = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
        novaComida = validacao.validarTexto(novaComida, "novaComida", novaComida, tipoEsquerda);
        String novoTipo = JOptionPane.showInputDialog(novaComida + " é ______ mas " + comida.getTipo() + " não.");
        novoTipo = validacao.validarTexto(novoTipo, "tipo", novaComida, tipoEsquerda);
        comida.setTipo(novoTipo);
        comida.setDireta(new Comida(novaComida));
        comida.setEsquerda(new Comida(tipoEsquerda));
    }    
}

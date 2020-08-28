package jogogourmetmarcos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JogoGourmetMarcos {

    public static Comida raiz;

    public static void setRaiz(Comida comida) {
        raiz = comida;
    }

    public static Comida getArvore() {
        return raiz;
    }

    public static void Pergunta(Comida comida) {
        int resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + comida.tipo + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            if (comida.Direta == null) {
                JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Pergunta(comida.Direta);
            }
        } else {
            if (comida.Esquerda == null) {
                inserirComida(comida);
            } else {
                Pergunta(comida.Esquerda);
            }
        }
    }

    public static void inserirComida(Comida comida) {

        String novacomida = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
        if (novacomida.isEmpty()) {
            while (novacomida.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você deve preencher um valor de comida para prosseguir", "Alerta", JOptionPane.WARNING_MESSAGE);
                novacomida = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
            }
        }
        String tipo = JOptionPane.showInputDialog(novacomida + " é ______ mas " + comida.tipo + " não.");
        if (tipo.isEmpty()) {
            while (tipo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você deve preencher um valor de tipo de comida para prosseguir", "Alerta", JOptionPane.WARNING_MESSAGE);
                tipo = JOptionPane.showInputDialog(novacomida + " é ______ mas " + comida.tipo + " não.");
            }
        }
        String tipoEsquerda = comida.tipo;
        comida.tipo = tipo;
        comida.Direta = new Comida(novacomida);
        comida.Esquerda = new Comida(tipoEsquerda);
    }

    public static void IniciarJogo() {
        String TituloCaixa = "Jogo Gourmet";
        int jogarnovamente = 0;
        int resposta;

        if (getArvore() == null) {
            setRaiz(new Comida("massas"));
            getArvore().Esquerda = new Comida("Bolo de Chocolate");
            getArvore().Direta = new Comida("Lazanha");
        }
        while (jogarnovamente == 0) {
            JLabel label = new JLabel("<html><center>Pense em um prato que gosta");
            label.setHorizontalAlignment(SwingConstants.CENTER);            
            JOptionPane.showMessageDialog(null, label, TituloCaixa, JOptionPane.CLOSED_OPTION);
            resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + raiz.tipo + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (resposta == 0) {
                Pergunta(raiz.Direta);
            } else {
                Pergunta(raiz.Esquerda);
            }
            jogarnovamente = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Confirm", JOptionPane.YES_NO_OPTION);
        }
    }

    public static void main(String[] args) {
        IniciarJogo();
    }

}

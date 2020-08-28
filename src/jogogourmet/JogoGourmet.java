package jogogourmet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JogoGourmet {

    public Comida raiz;

    public void setRaiz(Comida comida) {
        raiz = comida;
    }

    public Comida getArvore() {
        return raiz;
    }

    public void iniciarJogo() {
        int jogarNovamente = 0;
        int resposta;

        if (getArvore() == null) {
            setRaiz(new Comida("massas"));
            getArvore().esquerda = new Comida("Bolo de Chocolate");
            getArvore().direta = new Comida("Lazanha");
        }
        while (jogarNovamente == 0) {
            JLabel textoCentro = new JLabel("<html><center>Pense em um prato que gosta");
            textoCentro.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null, textoCentro, "Jogo Gourmet", JOptionPane.PLAIN_MESSAGE);
            resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + raiz.tipo + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (resposta == 0) {
                perguntar(raiz.direta);
            } else {
                perguntar(raiz.esquerda);
            }
            jogarNovamente = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Confirm", JOptionPane.YES_NO_OPTION);
        }
    }

    public void perguntar(Comida comida) {
        int resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + comida.tipo + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            if (comida.direta == null) {
                JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
            } else {
                perguntar(comida.direta);
            }
        } else {
            if (comida.esquerda == null) {
                inserirComida(comida);
            } else {
                perguntar(comida.esquerda);
            }
        }
    }

    public void inserirComida(Comida comida) {
        String tipoEsquerda = comida.tipo;
        String novaComida = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
        novaComida = validarTexto(novaComida, "novaComida", novaComida, tipoEsquerda);
        String novoTipo = JOptionPane.showInputDialog(novaComida + " é ______ mas " + comida.tipo + " não.");
        novoTipo = validarTexto(novoTipo, "tipo", novaComida, tipoEsquerda);
        comida.tipo = novoTipo;
        comida.direta = new Comida(novaComida);
        comida.esquerda = new Comida(tipoEsquerda);
    }

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

    public static void main(String[] args) {
        JogoGourmet jogo = new JogoGourmet();
        jogo.iniciarJogo();
    }

}

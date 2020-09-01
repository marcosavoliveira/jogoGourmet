package jogogourmet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JogoGourmet {

    public AcaoJogo acao;
    public Comida comida;

    public void iniciarJogo() {
        if(acao == null){
            acao= new AcaoJogo();
        }
        if(comida == null){
            comida = new Comida("");
        }
        int jogarNovamente = 0;
        int resposta;

        if (comida.getRaiz() == null) {
            comida.setRaiz(new Comida("massas"));
            comida.getRaiz().setEsquerda(new Comida("Bolo de Chocolate"));
            comida.getRaiz().setDireta(new Comida("Lazanha"));
        }
        while (jogarNovamente == 0) {
            JLabel textoCentro = new JLabel("<html><center>Pense em um prato que gosta");
            textoCentro.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null, textoCentro, "Jogo Gourmet", JOptionPane.PLAIN_MESSAGE);
            resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + comida.getRaiz().getTipo() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (resposta == 0) {
                acao.perguntar(comida.getRaiz().getDireta());
            } else {
                acao.perguntar(comida.getRaiz().getEsquerda());
            }
            jogarNovamente = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Confirm", JOptionPane.YES_NO_OPTION);
        }
    }

    public static void main(String[] args) {
        JogoGourmet jogo = new JogoGourmet();
        jogo.iniciarJogo();
    }

}

package jogogourmet;

public class Comida {

    private String tipo;
    private Comida esquerda;
    private Comida direta;
    private Comida raiz;

    public Comida(String tipo) {        
        this.tipo = tipo;
    }

    
    public void setRaiz(Comida comida) {
        raiz = comida;
    }

    public Comida getRaiz() {
        return raiz;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comida getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Comida esquerda) {
        this.esquerda = esquerda;
    }

    public Comida getDireta() {
        return direta;
    }

    public void setDireta(Comida direta) {
        this.direta = direta;
    }
    
}

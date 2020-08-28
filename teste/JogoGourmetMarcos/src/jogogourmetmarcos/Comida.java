package jogogourmetmarcos;

public class Comida {

    int ordem;
    String tipo;
    Comida Esquerda;
    Comida Direta;

    public Comida(String tipo) {        
        this.tipo = tipo;
    }
}

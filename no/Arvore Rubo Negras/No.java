public class No {
    int valor;
    No esquerda;
    No direita;
    No pai;
    boolean cor;

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.cor = true;
    }
}
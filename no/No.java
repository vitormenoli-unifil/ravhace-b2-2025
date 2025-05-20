public class No {
    String valor;
    No esquerda, direita;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }

    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }

    public void PreOrdem(No node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            PreOrdem(node.esquerda);
            PreOrdem(node.direita);
        }
    }
}
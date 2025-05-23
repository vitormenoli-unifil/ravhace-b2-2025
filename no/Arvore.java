import java.util.LinkedList;
import java.util.Queue;

public class Arvore {

    No raiz;

    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }

    public void buscaPreOrdem(No node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            buscaPreOrdem(node.esquerda);
            buscaPreOrdem(node.direita);
        }
    }

    public void buscaEmOrdem(No node) {
        if (node != null) {
            buscaEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            buscaEmOrdem(node.direita);
        }
    }

    public void buscaPosOrdem(No node) {
        if (node != null) {
            buscaPosOrdem(node.esquerda);
            buscaPosOrdem(node.direita);
            System.out.println(node.valor + " ");
        }
    }

    public void buscaEmNivel() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.println(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }
}
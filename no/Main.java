public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.raiz = new No("A");
        arvore.raiz.esquerda = new No("B");
        arvore.raiz.direita  = new No("C");
        arvore.raiz.esquerda.esquerda  = new No("D");
        arvore.raiz.esquerda.direita   = new No("E");
        arvore.raiz.direita.direita    = new No("F");

        // 1) Contar nós (recursivo)
        int totalNos = arvore.contarNos(arvore.raiz);
        System.out.println("Total de nós na árvore (recursivo): " + totalNos);

        // 2) Percursos recursivos
        System.out.print("Pré-ordem: ");
        arvore.buscaPreOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Em-ordem: ");
        arvore.buscaEmOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.buscaPosOrdem(arvore.raiz);
        System.out.println();

        // 3) Busca em nível (largura)
        System.out.println("Em nível (largura):");
        arvore.buscaEmNivel();

        // 4) Percursos iterativos
        System.out.print("Em-ordem iterativo: ");
        arvore.emOrdemIterativo(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem iterativo: ");
        arvore.posOrdemIterativo(arvore.raiz);
        System.out.println();

        // 5) Contar nós (iterativo)
        int totalNosIterativo = arvore.contarNosIterativo();
        System.out.println("Total de nós na árvore (iterativo): " + totalNosIterativo);

        // 6) Contar folhas (iterativo)
        int totalFolhas = arvore.contarFolhasIterativo();
        System.out.println("Total de folhas na árvore: " + totalFolhas);
    }
}
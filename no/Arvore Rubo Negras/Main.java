public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra arv = new ArvoreRubroNegra();
        
        int[] chaves = {10, 20, 30, 15, 5, 25};
        for (int c : chaves) {
            arv.inserir(c);
        }

        System.out.println("== Árvore após inserções (in order) ==");
        arv.inorder();

        arv.remover(15);
        arv.remover(10);

        System.out.println("== Árvore após remoções (in order) ==");
        arv.inorder();
    }
}

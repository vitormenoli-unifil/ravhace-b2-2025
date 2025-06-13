public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra arv = new ArvoreRubroNegra();
        int[] chaves = {10, 20, 30, 15, 25, 5};

        System.out.println("== Inserindo ==");
        for (int c : chaves) {
            arv.inserir(c);
            System.out.println("Inserido: " + c);
        }

        System.out.println("== Removendo 20 ==");
        arv.remover(20);
        System.out.println("Removido: 20");
    }
}
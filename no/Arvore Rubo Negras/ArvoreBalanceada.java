public abstract class ArvoreBalanceada<N> {
    protected N raiz;

    public void inserir(int chave) {
        raiz = inserirRec(raiz, chave);
        aposInserir(raiz, chave);
    }

    protected abstract N inserirRec(N no, int chave);
    protected abstract void aposInserir(N no, int chave);

    public void remover(int chave) {
        raiz = removerRec(raiz, chave);
        aposRemover(raiz, chave);
    }

    protected abstract N removerRec(N no, int chave);
    protected abstract void aposRemover(N no, int chave);

    protected abstract N rotacionarEsquerda(N x);
    protected abstract N rotacionarDireita(N y);
}
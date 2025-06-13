public class ArvoreRubroNegra extends ArvoreBalanceada<No> {


    @Override
    protected No rotacionarEsquerda(No x) {
        No y = x.direita;
        No temp = y.esquerda;
        y.esquerda = x;
        x.direita = temp;
        return y;
    }

    @Override
    protected No rotacionarDireita(No y) {
        No x = y.esquerda;
        No temp = x.direita;
        x.direita = y;
        y.esquerda = temp;
        return x;
    }

    @Override
    protected No inserirRec(No no, int chave) {
        if (no == null) return new No(chave);
        if (chave < no.valor) {
            no.esquerda = inserirRec(no.esquerda, chave);
            no.esquerda.pai = no;
        } else if (chave > no.valor) {
            no.direita = inserirRec(no.direita, chave);
            no.direita.pai = no;
        }
        return no;
    }

    @Override
    protected void aposInserir(No no, int chave) {
    }

    @Override
    protected No removerRec(No no, int chave) {
        if (no == null) return null;
        if (chave < no.valor) no.esquerda = removerRec(no.esquerda, chave);
        else if (chave > no.valor) no.direita = removerRec(no.direita, chave);
        else {
            if (no.esquerda == null || no.direita == null) {
                No temp = (no.esquerda != null) ? no.esquerda : no.direita;
                no = (temp == null) ? null : temp;
            } else {
                No sucessor = minimo(no.direita);
                no.valor = sucessor.valor;
                no.direita = removerRec(no.direita, sucessor.valor);
            }
        }
        return no;
    }

    @Override
    protected void aposRemover(No no, int chave) {
    }

    private No minimo(No no) {
        while (no.esquerda != null) no = no.esquerda;
        return no;
    }
}
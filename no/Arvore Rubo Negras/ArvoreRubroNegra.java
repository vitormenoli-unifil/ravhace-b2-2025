public class ArvoreRubroNegra extends ArvoreBalanceada<No> {

    private static final boolean VERMELHO = true;
    private static final boolean PRETO = false;

    @Override
    protected No rotacionarEsquerda(No x) {
        No y = x.direita;
        No temp = y.esquerda;
        y.esquerda = x;
        x.direita = temp;
        y.pai = x.pai;
        x.pai = y;
        if (temp != null) temp.pai = x;
        return y;
    }

    @Override
    protected No rotacionarDireita(No y) {
        No x = y.esquerda;
        No temp = x.direita;
        x.direita = y;
        y.esquerda = temp;
        x.pai = y.pai;
        y.pai = x;
        if (temp != null) temp.pai = y;
        return x;
    }

    private void transplant(No u, No v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        if (v != null) {
            v.pai = u.pai;
        }
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
        insertFix(no);
    }

    protected void insertFix(No z) {
        while (z.pai != null && z.pai.cor == VERMELHO) {
            if (z.pai == z.pai.pai.esquerda) {
                No y = z.pai.pai.direita;
                if (y != null && y.cor == VERMELHO) {
                    z.pai.cor = PRETO;
                    y.cor = PRETO;
                    z.pai.pai.cor = VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.direita) {
                        z = z.pai;
                        rotacionarEsquerda(z);
                    }
                    z.pai.cor = PRETO;
                    z.pai.pai.cor = VERMELHO;
                    rotacionarDireita(z.pai.pai);
                }
            } else {
                No y = z.pai.pai.esquerda;
                if (y != null && y.cor == VERMELHO) {
                    z.pai.cor = PRETO;
                    y.cor = PRETO;
                    z.pai.pai.cor = VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.esquerda) {
                        z = z.pai;
                        rotacionarDireita(z);
                    }
                    z.pai.cor = PRETO;
                    z.pai.pai.cor = VERMELHO;
                    rotacionarEsquerda(z.pai.pai);
                }
            }
        }
        raiz.cor = PRETO;
    }

    @Override
    protected No removerRec(No no, int chave) {
        if (no == null) return null;
        if (chave < no.valor) {
            no.esquerda = removerRec(no.esquerda, chave);
        } else if (chave > no.valor) {
            no.direita = removerRec(no.direita, chave);
        } else {
            No y = no;
            boolean yOriginalColor = y.cor;
            No x;

            if (no.esquerda == null) {
                x = no.direita;
                transplant(no, no.direita);
            } else if (no.direita == null) {
                x = no.esquerda;
                transplant(no, no.esquerda);
            } else {
                y = minimo(no.direita);
                yOriginalColor = y.cor;
                x = y.direita;
                if (y.pai == no) {
                    if (x != null) x.pai = y;
                } else {
                    transplant(y, y.direita);
                    y.direita = no.direita;
                    if (y.direita != null) y.direita.pai = y;
                }
                transplant(no, y);
                y.esquerda = no.esquerda;
                if (y.esquerda != null) y.esquerda.pai = y;
                y.cor = no.cor;
            }

            if (yOriginalColor == PRETO && x != null) {
                deleteFix(x);
            }
        }
        return no;
    }

    @Override
    protected void aposRemover(No no, int chave) {
    }

    protected void deleteFix(No x) {
        while (x != raiz && corDe(x) == PRETO) {
            if (x == x.pai.esquerda) {
                No w = x.pai.direita;
                if (corDe(w) == VERMELHO) {
                    w.cor = PRETO;
                    x.pai.cor = VERMELHO;
                    rotacionarEsquerda(x.pai);
                    w = x.pai.direita;
                }
                if (corDe(w.esquerda) == PRETO && corDe(w.direita) == PRETO) {
                    w.cor = VERMELHO;
                    x = x.pai;
                } else {
                    if (corDe(w.direita) == PRETO) {
                        if (w.esquerda != null) w.esquerda.cor = PRETO;
                        w.cor = VERMELHO;
                        rotacionarDireita(w);
                        w = x.pai.direita;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = PRETO;
                    if (w.direita != null) w.direita.cor = PRETO;
                    rotacionarEsquerda(x.pai);
                    x = raiz;
                }
            } else {
                No w = x.pai.esquerda;
                if (corDe(w) == VERMELHO) {
                    w.cor = PRETO;
                    x.pai.cor = VERMELHO;
                    rotacionarDireita(x.pai);
                    w = x.pai.esquerda;
                }
                if (corDe(w.direita) == PRETO && corDe(w.esquerda) == PRETO) {
                    w.cor = VERMELHO;
                    x = x.pai;
                } else {
                    if (corDe(w.esquerda) == PRETO) {
                        if (w.direita != null) w.direita.cor = PRETO;
                        w.cor = VERMELHO;
                        rotacionarEsquerda(w);
                        w = x.pai.esquerda;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = PRETO;
                    if (w.esquerda != null) w.esquerda.cor = PRETO;
                    rotacionarDireita(x.pai);
                    x = raiz;
                }
            }
        }
        if (x != null) x.cor = PRETO;
    }

    private boolean corDe(No no) {
        return (no == null) ? PRETO : no.cor;
    }

    public No searchTree(No node, int key) {
        if (node == null || key == node.valor) {
            return node;
        }
        if (key < node.valor) {
            return searchTree(node.esquerda, key);
        } else {
            return searchTree(node.direita, key);
        }
    }

    public void inorder() {
        inorderHelper(raiz);
        System.out.println();
    }

    private void inorderHelper(No node) {
        if (node != null) {
            inorderHelper(node.esquerda);
            String colorSuffix = (node.cor == VERMELHO) ? "R" : "B";
            System.out.print(node.valor + colorSuffix + " ");
            inorderHelper(node.direita);
        }
    }

    private No minimo(No no) {
        while (no.esquerda != null) no = no.esquerda;
        return no;
    }
}

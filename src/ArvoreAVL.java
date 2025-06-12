public class ArvoreAVL {
    private NoAVL raiz;

    // Métodos públicos
    public void inserir(Show dado) {
        raiz = inserir(raiz, dado);
    }

    public Show buscar(String showId) {
        return buscar(raiz, showId);
    }

    public void remover(String showId) {
        raiz = remover(raiz, showId);
    }

    public boolean alterar(String showId, Show novoShow) {
        NoAVL no = buscarNo(raiz, showId);
        if (no != null) {
            no.dado = novoShow;
            return true;
        }
        return false;
    }

    // Métodos privados recursivos
    private NoAVL inserir(NoAVL no, Show dado) {
        if (no == null) return new NoAVL(dado);

        if (dado.compareTo(no.dado) < 0)
            no.esquerdo = inserir(no.esquerdo, dado);
        else if (dado.compareTo(no.dado) > 0)
            no.direito = inserir(no.direito, dado);
        else
            return no; // Duplicado, não insere

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        return balancear(no);
    }

    private Show buscar(NoAVL no, String showId) {
        if (no == null) return null;
        int cmp = showId.compareTo(no.dado.getShowId());
        if (cmp == 0) return no.dado;
        if (cmp < 0) return buscar(no.esquerdo, showId);
        return buscar(no.direito, showId);
    }

    // Método auxiliar para buscar o nó (usado no alterar)
    private NoAVL buscarNo(NoAVL no, String showId) {
        if (no == null) return null;
        int cmp = showId.compareTo(no.dado.getShowId());
        if (cmp == 0) return no;
        if (cmp < 0) return buscarNo(no.esquerdo, showId);
        return buscarNo(no.direito, showId);
    }

    // Método de remoção
    private NoAVL remover(NoAVL no, String showId) {
        if (no == null) return null;

        int cmp = showId.compareTo(no.dado.getShowId());
        if (cmp < 0) {
            no.esquerdo = remover(no.esquerdo, showId);
        } else if (cmp > 0) {
            no.direito = remover(no.direito, showId);
        } else {
            // Nó encontrado - casos de remoção
            if (no.esquerdo == null) {
                return no.direito;
            } else if (no.direito == null) {
                return no.esquerdo;
            } else {
                // Nó com dois filhos - encontrar o sucessor (menor da subárvore direita)
                NoAVL sucessor = encontrarMinimo(no.direito);
                no.dado = sucessor.dado;
                no.direito = remover(no.direito, sucessor.dado.getShowId());
            }
        }

        // Atualizar altura e rebalancear
        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        return balancear(no);
    }

    // Método auxiliar para encontrar o nó com valor mínimo
    private NoAVL encontrarMinimo(NoAVL no) {
        while (no.esquerdo != null) {
            no = no.esquerdo;
        }
        return no;
    }

    // Métodos de balanceamento
    private NoAVL balancear(NoAVL no) {
        int fb = fatorBalanceamento(no);

        // Rotação à direita (caso Left-Left ou Left-Right)
        if (fb > 1) {
            if (fatorBalanceamento(no.esquerdo) < 0) {
                no.esquerdo = rotacaoEsquerda(no.esquerdo); // Left-Right
            }
            return rotacaoDireita(no); // Left-Left
        }

        // Rotação à esquerda (caso Right-Right ou Right-Left)
        if (fb < -1) {
            if (fatorBalanceamento(no.direito) > 0) {
                no.direito = rotacaoDireita(no.direito); // Right-Left
            }
            return rotacaoEsquerda(no); // Right-Right
        }

        return no; // Nó já está balanceado
    }

    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAVL no) {
        return (no == null) ? 0 : altura(no.esquerdo) - altura(no.direito);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerdo;
        NoAVL T2 = x.direito;

        // Realizar rotação
        x.direito = y;
        y.esquerdo = T2;

        // Atualizar alturas
        y.altura = 1 + Math.max(altura(y.esquerdo), altura(y.direito));
        x.altura = 1 + Math.max(altura(x.esquerdo), altura(x.direito));

        return x; // Nova raiz
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direito;
        NoAVL T2 = y.esquerdo;

        // Realizar rotação
        y.esquerdo = x;
        x.direito = T2;

        // Atualizar alturas
        x.altura = 1 + Math.max(altura(x.esquerdo), altura(x.direito));
        y.altura = 1 + Math.max(altura(y.esquerdo), altura(y.direito));

        return y; // Nova raiz
    }

    // Método auxiliar para contar nós (útil para testes)
    public int tamanho() {
        return tamanho(raiz);
    }

    private int tamanho(NoAVL no) {
        if (no == null) return 0;
        return 1 + tamanho(no.esquerdo) + tamanho(no.direito);
    }

    // Método para verificar se a árvore está vazia
    public boolean isEmpty() {
        return raiz == null;
    }
}
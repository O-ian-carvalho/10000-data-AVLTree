public class NoAVL {
    Show dado;
    NoAVL esquerdo, direito;
    int altura;

    public NoAVL(Show dado) {
        this.dado = dado;
        this.altura = 1;
    }
}
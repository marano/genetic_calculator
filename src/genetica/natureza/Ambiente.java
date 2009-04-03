package genetica.natureza;

/**
 *
 * @author marano
 */
public class Ambiente {

    private FuncaoAptidao funcao;

    public Ambiente(FuncaoAptidao funcao) {
        this.funcao = funcao;
    }

    public int avaliar(Individuo individuo) {
        return funcao.avaliar(individuo);
    }
}

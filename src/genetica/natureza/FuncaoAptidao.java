package genetica.natureza;

/**
 *
 * @author marano
 */
public abstract class FuncaoAptidao {

    public abstract int avaliar(int valor);

    public int avaliar(Individuo individuo) {
        return avaliar(individuo.getValor());
    }
}
package genetica.natureza;

/**
 *
 * @author marano
 */
public class Individuo {

    private Genetica genetica;
    private Ambiente ambiente;

    public Individuo(Ambiente ambiente, Genetica genetica) {
        this.ambiente = ambiente;
        this.genetica = genetica;
    }

    public Individuo gerarFilho(Individuo outroPai) {
        return new Individuo(ambiente, genetica.crossover(outroPai.getGenetica()));
    }

    public int aptidao() {
        return ambiente.avaliar(this);
    }

    public Object getGenesString() {
        return genetica.toString();
    }

    public int getValor() {
        return genetica.getIntValue();
    }

    public Genetica getGenetica() {
        return genetica;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void mutar() {
        do {
            genetica.mutar();
        } while (aptidao() <= 0);
    }
}
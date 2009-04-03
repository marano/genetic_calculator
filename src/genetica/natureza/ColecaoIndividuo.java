package genetica.natureza;

/**
 *
 * @author marano
 */
public class ColecaoIndividuo {

    protected Individuo[] individuos;
    private Ambiente ambiente;

    public ColecaoIndividuo(Individuo[] individuos) {
        this.individuos = individuos;
    }

    public ColecaoIndividuo(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public void popular(int tamanhoPopulacao, Class<? extends Gene> classeGene) {
        individuos = new Individuo[tamanhoPopulacao];
        for (int i = 0; i < tamanhoPopulacao; i++) {
            individuos[i] = new Individuo(ambiente, new Genetica(classeGene));
        }
    }

    public Individuo[] getIndividuos() {
        return individuos;
    }

    public void setIndividuos(Individuo[] individuos) {
        this.individuos = individuos;
    }

    public Individuo get(int posicao) {
        return individuos[posicao];
    }

    public int tamanho() {
        return individuos.length;
    }

    public int totalAptidao() {
        int total = 0;
        for (Individuo individuo : individuos) {
            total += individuo.aptidao();
        }
        return total;
    }

    public void imprimir() {
        for (int i = 0; i < individuos.length; i++) {
            Individuo individuo = individuos[i];
            System.out.println("invidividuo " + individuo.getValor() + " -> " + individuo.aptidao());
        }

        System.out.println("-----------------total " + totalAptidao());
        System.out.println("------------------------------------");
    }
}
package genetica.roleta;

import genetica.natureza.Individuo;
import genetica.natureza.Populacao;

/**
 *
 * @author marano
 */
class IndividuoRoleta {

    private Populacao populacao;
    private Individuo individuo;
    private double porcentagem;
    private double limite;

    public IndividuoRoleta(Populacao populacao, Individuo individuo) {
        this.populacao = populacao;
        this.individuo = individuo;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public double getLimite() {
        return limite;
    }

    void inicializarPorcentagem() {
        porcentagem = (individuo.aptidao() / (double) populacao.totalAptidao()) * 100;
    }

    void inicializarLimites(double limiteAtual) {
        limite = limiteAtual + porcentagem;
    }

    boolean verificarSorteio(double sorteio) {
        return limite >= sorteio;
    }
}

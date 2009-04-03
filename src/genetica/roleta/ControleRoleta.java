package genetica.roleta;

import genetica.natureza.Gene;
import genetica.natureza.Individuo;
import genetica.natureza.Populacao;
import java.lang.Class;

/**
 *
 * @author marano
 */
public class ControleRoleta {

    private Roleta roleta;
    private ObservadorRoleta observadorRoleta;
    private int tamanhoPopulacao = 30;
    private Thread threadExecucao;
    private Class<? extends Gene> classeGene;

    public ControleRoleta(Roleta roleta, Class<? extends Gene> classeGene) {
        this.roleta = roleta;
        this.classeGene = classeGene;
        roleta.setControle(this);
    }

    public void parar() {
        roleta.interromper();
    }

    public int totalAptidao() {
        return roleta.getPopulacao().totalAptidao();
    }

    public int getQuantidadeIteracao() {
        return roleta.getTotalIteracoes();
    }

    public void setTotalIteracoes(int totalIteracoes) {
        roleta.setTotalIteracoes(totalIteracoes);
    }

    public int getTamanhoPopulacao() {
        return tamanhoPopulacao;
    }

    public void setTamanhoPopulacao(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    public void adicionarObservedor(ObservadorRoleta observador) {
        this.observadorRoleta = observador;
    }

    public void executar() {
        roleta.getPopulacao().popular(tamanhoPopulacao, classeGene);
        threadExecucao = new Thread(new Runnable() {

            public void run() {
                roleta.executarIteracoes();
            }
        }, "Executar Iterações");
        threadExecucao.start();
    }

    public Individuo[] getIndividuos() {
        return roleta.getPopulacao().getIndividuos();
    }

    public void dispararPopulacaoAlterada(Populacao populacao) {
        if (observadorRoleta != null) {
            observadorRoleta.populacaoAlterada(populacao);
        }
    }

    void dispararRoletaRodou(int iteracaoAtual, int totalIteracoes) {
        if (observadorRoleta != null) {
            observadorRoleta.roletaRodou(iteracaoAtual, totalIteracoes);
        }
    }

    void dispararInicioIteracoes() {
        if (observadorRoleta != null) {
            observadorRoleta.inicioIteracoes();
        }
    }

    void dispararFimIteracoes() {
        if (observadorRoleta != null) {
            observadorRoleta.fimIteracoes();
        }
    }
}
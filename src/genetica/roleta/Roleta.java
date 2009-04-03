package genetica.roleta;

import genetica.natureza.Populacao;
import genetica.natureza.Individuo;
import java.util.Random;

/**
 *
 * @author marano
 */
public class Roleta {

    private Populacao populacao;
    private ColecaoIndividuoRoleta individuosRoleta;
    private ControleRoleta controle;
    private int iteracaoAtual;
    private int totalIteracoes = 50;
    private boolean executando;
    private boolean interrompida;

    public Roleta(Populacao populacao) {
        this.populacao = populacao;
    }

    public void interromper() {
        if (executando) {
            interrompida = true;
        }
    }

    private void executarIteracao() {
        rodar();
        crossover();
        mutacao();
        dispararPopulacaoAlterada();
    }

    private void mutacao() {
        sortear().mutar();
    }

    private void crossover() {
        int quantidadePais = isPar(populacao.tamanho()) ? populacao.tamanho() : populacao.tamanho() - 1;
        Individuo[] pais = new Individuo[quantidadePais];
        for (int i = 0; i < pais.length; i++) {
            pais[i] = sortear();
        }
        Individuo[] filhos = new Individuo[quantidadePais];
        for (int i = 0; i < (pais.length - 1); i += 2) {
            filhos[i] = pais[i].gerarFilho(pais[i + 1]);
            filhos[i + 1] = pais[i + 1].gerarFilho(pais[i]);
        }
        populacao.setIndividuos(filhos);
    }

    private boolean isPar(int numero) {
        return numero % 2 == 0;
    }

    public void executarIteracoes() {
        executando = true;
        interrompida = false;
        dispararInicioIteracoes();
        for (iteracaoAtual = 1; iteracaoAtual <= totalIteracoes; iteracaoAtual++) {
            if (interrompida) {
                break;
            }
            executarIteracao();
        }
        executando = false;
        dispararFimIteracoes();
    }

    public void setIteracaoAtual(int iteracaoAtual) {
        this.iteracaoAtual = iteracaoAtual;
    }

    public int getTotalIteracoes() {
        return totalIteracoes;
    }

    public void setTotalIteracoes(int totalIteracoes) {
        this.totalIteracoes = totalIteracoes;
    }

    public void setControle(ControleRoleta controle) {
        this.controle = controle;
    }

    public Roleta rodar() {
        individuosRoleta = new ColecaoIndividuoRoleta(populacao);
        individuosRoleta.inicializarPorcentagens();
        individuosRoleta.inicializarLimites();
        dispararRoletaRodou();
        return this;
    }

    public Individuo sortear() {
        return individuosRoleta.sortear(new Random().nextDouble() * 100).getIndividuo();
    }

    public Populacao getPopulacao() {
        return populacao;
    }

    public void dispararPopulacaoAlterada() {
        if (controle != null) {
            controle.dispararPopulacaoAlterada(populacao);
        }
    }

    public void dispararRoletaRodou() {
        if (controle != null) {
            controle.dispararRoletaRodou(iteracaoAtual, totalIteracoes);
        }
    }

    public void dispararInicioIteracoes() {
        if (controle != null) {
            controle.dispararInicioIteracoes();
        }
    }

    public void dispararFimIteracoes() {
        if (controle != null) {
            controle.dispararFimIteracoes();
        }
    }
}

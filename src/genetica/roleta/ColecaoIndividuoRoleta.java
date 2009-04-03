/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetica.roleta;

import genetica.natureza.Populacao;

/**
 *
 * @author marano
 */
class ColecaoIndividuoRoleta {

    private Populacao populacao;
    private IndividuoRoleta[] individuos;

    public ColecaoIndividuoRoleta(Populacao populacao) {
        this.populacao = populacao;
        individuos = new IndividuoRoleta[populacao.tamanho()];
        for (int i = 0; i < populacao.tamanho(); i++) {
            individuos[i] = new IndividuoRoleta(populacao, populacao.get(i));
        }
    }

    void inicializarPorcentagens() {
        for (IndividuoRoleta individuoRoleta : individuos) {
            individuoRoleta.inicializarPorcentagem();
        }
    }

    void inicializarLimites() {
        double limiteAtual = 0;
        for (IndividuoRoleta individuoRoleta : individuos) {
            individuoRoleta.inicializarLimites(limiteAtual);
            limiteAtual += individuoRoleta.getPorcentagem();
        }
    }

    IndividuoRoleta sortear(double sorteio) {
        for (IndividuoRoleta individuo : individuos) {
            if (individuo.verificarSorteio(sorteio)) {
                return individuo;
            }
        }
        throw new RuntimeException("Não foi possível definir o indivíduo sorteado!");
    }
}

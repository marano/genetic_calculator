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
public interface ObservadorRoleta {

    public void roletaRodou(int iteracaoAtual, int totalIteracoes);

    public void populacaoAlterada(Populacao populacao);

    public void inicioIteracoes();

    public void fimIteracoes();
}

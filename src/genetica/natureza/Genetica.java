package genetica.natureza;

import genetica.suporte.Log;
import java.util.Random;

/**
 *
 * @author marano
 */
public class Genetica<T extends Gene> {

    private Gene[] genes;
    private static int chancesDeMutacao = 3;
    private static int chancesDeCrossover = 50;
    private Class<T> classeGene;

    public Genetica(Class<T> classeGene) {
        this.classeGene = classeGene;
        genes = new Gene[]{
                    gerarGene(),
                    gerarGene(),
                    gerarGene(),
                    gerarGene(),
                    gerarGene()};
    }

    public Genetica(Class<T> classeGene, T[] genes) {
        this.classeGene = classeGene;
        this.genes = genes;
    }

    public Class<T> getClasseGene() {
        return classeGene;
    }

    public Genetica crossover(Genetica outraGenetica) {
        Gene[] genesFilho = new Gene[tamanho()];
        int pontoCrossover = (int) (genesFilho.length / 2);
        for (int i = 0; i < genesFilho.length; i++) {
//            if (deveTrocar()) {
//                genesFilho[i] = outraGenetica.genes[i];
//            } else {
//                genesFilho[i] = genes[i];
//            }
            if (i < pontoCrossover) {
                genesFilho[i] = genes[i];
            } else {
                genesFilho[i] = outraGenetica.genes[i];
            }
        }
        Genetica geneticaFilho = new Genetica(classeGene, genesFilho);
        Log.info(this, "Genetica.crossover " + this + " e " + outraGenetica + " = " + geneticaFilho);
        return geneticaFilho;
    }

    public Gene[] clonar() {
        Gene[] clone = new Gene[genes.length];
        for (int i = 0; i < clone.length; i++) {
            clone[i] = genes[i].clonar();
        }
        return clone;
    }

    public void mutar() {
        for (int i = 0; i < genes.length; i++) {
            if (deveMutar()) {
                trocar(i);
            }
        }
    }

    public boolean deveMutar() {
        return new Random().nextInt(101) <= chancesDeMutacao;
    }

    public boolean deveTrocar() {
        return new Random().nextInt(101) <= chancesDeCrossover;
    }

    public void trocar(int indice) {
        genes[indice].mutar();
    }

    public Gene[] getGenes() {
        return genes;
    }

    private T gerarGene() {
        try {
            return classeGene.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível gerar um novo gene!", ex);
        }
    }

    public int getIntValue() {
        int numero = 0;
        for (int i = genes.length - 1; i >= 0; i--) {
            int posicao = genes.length - i - 1;
            numero += genes[i].intValue() * (Math.pow(2, posicao));
        }
        return numero;
    }

    private int tamanho() {
        return genes.length;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        for (Gene gene : genes) {
            texto.append(gene.toString());
        }
        return texto.toString();
    }
}

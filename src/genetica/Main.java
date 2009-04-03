package genetica;

import genetica.apresentacao.Monitor;
import genetica.apresentacao.TelaLogo;
import genetica.natureza.Populacao;
import genetica.natureza.Ambiente;
import genetica.natureza.FuncaoAptidao;
import genetica.natureza.GeneBinario;
import genetica.roleta.ControleRoleta;
import genetica.roleta.Roleta;
import genetica.suporte.Log;
import javax.swing.UIManager;

/**
 *
 * @author marano
 */
public class Main {

    public Main() {
        carregarLookAndFeel();

        exibirLogo();

        Log.setLogAtivado(false);

        FuncaoAptidao funcao = new FuncaoExercicio1();

        Populacao populacao = new Populacao(new Ambiente(funcao));

        new Monitor(new ControleRoleta(new Roleta(populacao), GeneBinario.class));
    }

    private void exibirLogo() {
        TelaLogo telaLogo = new TelaLogo();
    }

    private class FuncaoExercicio1 extends FuncaoAptidao {

        @Override
        public int avaliar(int valor) {
            return (-(valor * valor)) + (40 * valor) - 50;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    private void carregarLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

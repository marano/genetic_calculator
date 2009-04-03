package genetica.apresentacao;

/**
 *
 * @author marano
 */
public interface ListaNotificavel {

    public int getLinhaSelecionada();

    public int[] getLinhasSelecionadas();

    public void notificar();

    public void notificar(int indice);

    public void notificarAdicao(int indice);

    public void notificarRemocao(int indice);
}


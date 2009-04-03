package genetica.natureza;

import java.util.Random;

/**
 *
 * @author marano
 */
public class GeneBinario extends Gene {

    public GeneBinario() {
        super();
    }

    public GeneBinario(boolean valor) {
        super(valor);
    }

    @Override
    protected Object gerarValor() {
        return new Random().nextBoolean();
    }

    @Override
    public int intValue() {
        return ((Boolean) valor).booleanValue() ? 1 : 0;
    }
}

package genetica.natureza;

/**
 *
 * @author marano
 */
public class Gene {

    protected Object valor;

    public Gene() {
        valor = gerarValor();
    }

    public Gene(Object valor) {
        this.valor = valor;
    }

    protected Object gerarValor() {
        throw new RuntimeException("Não foi possível gerar um novo valor para este gene!");
    }

    public Object getValor() {
        return valor;
    }

    public Gene clonar() {
        return new Gene(valor);
    }

    public void mutar() {
        if (valor instanceof Boolean) {
            boolean booleano = ((Boolean) valor).booleanValue();
            valor = booleano ? false : true;
        } else {
            throw new RuntimeException("Não existe mutação definida para este Gene!");
        }
    }

    public int intValue() {
        if (valor instanceof Number) {
            return ((Number) valor).intValue();
        } else if (valor instanceof Boolean) {
            return ((Boolean) valor).booleanValue() ? 1 : 0;
        } else {
            return Integer.parseInt(valor.toString());
        }
    }

    @Override
    public String toString() {
        return "" + intValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gene other = (Gene) obj;
        if (this.valor != other.valor && (this.valor == null || !this.valor.equals(other.valor))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        return hash;
    }
}

package genetica.suporte;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marano
 */
public class Log {

    private static StringBuilder texto = new StringBuilder("Inicializando log ...");
    private static List<RegistroLog> registros = new LinkedList<RegistroLog>();
    private static boolean logAtivado = true;
    private static ObservadorLog observador;

    public static void info(Object origem, String texto) {
        if (logAtivado) {
            RegistroLog registro = new RegistroLog(origem.getClass(), texto);
            registros.add(registro);

            StringBuilder textoNovo = new StringBuilder("\n");
            textoNovo.append(registro);
            Log.texto.append(textoNovo);

            observador.logAtualizado(textoNovo.toString());
        }
    }

    public static void setLogAtivado(boolean logAtivado) {
        Log.logAtivado = logAtivado;
    }

    public static String getTexto() {
        return texto.toString();
    }

    public static void setObservador(ObservadorLog observador) {
        Log.observador = observador;
    }
}

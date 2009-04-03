/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetica.suporte;

/**
 *
 * @author marano
 */
public class RegistroLog {

    private Class classe;
    private String mensagem;

    public RegistroLog(Class classe, String mensagem) {
        this.classe = classe;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return mensagem;
    }
}

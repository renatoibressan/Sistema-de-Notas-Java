package exceptions;

public class ArquivoInvalidoException extends Exception {
    public ArquivoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
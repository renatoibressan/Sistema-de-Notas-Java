package exceptions;

public class AlunoJaExisteException extends Exception {
    public AlunoJaExisteException(String mensagem) {
        super(mensagem);
    }
}
package com.academico.sistema.exceptions;

public class AlunoNaoEncontradoException extends Exception {
    public AlunoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
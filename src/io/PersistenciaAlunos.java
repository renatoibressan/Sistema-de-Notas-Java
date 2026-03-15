package io;
import exceptions.ArquivoInvalidoException;
import model.Aluno;

public interface PersistenciaAlunos {
    public void salvarNoArquivo(Aluno[] alunos, int total);
    public Aluno[] carregarDeArquivo() throws ArquivoInvalidoException;
}
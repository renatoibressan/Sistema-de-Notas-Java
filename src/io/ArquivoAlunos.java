package io;
import model.Aluno;
import io.PersistenciaAlunos;
import exceptions.ArquivoInvalidoException;
import java.util.HashMap;


public class ArquivoAlunos implements PersistenciaAlunos {
    private HashMap<Integer, Aluno> aluno = new HashMap<>();
    @Override
    public void salvarNoArquivo(Aluno[] alunos, int total) {
    }
    @Override
    public Aluno[] carregarDeArquivo() throws ArquivoInvalidoException {
        Aluno[] temp = new Aluno[4];
        // throw new ArquivoInvalidoException("Arquivo invalido!");
        return temp;
    }
}
package io;
import model.Aluno;
import service.GerenciadorAlunos;
import io.PersistenciaAlunos;
import exceptions.ArquivoInvalidoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class ArquivoAlunos implements PersistenciaAlunos {
    private HashMap<Integer, Aluno> alunos;
    private List<Aluno> lista = new ArrayList<>(alunos.values());
    @Override
    public void salvarNoArquivo(Aluno[] alunos, int total) {
        Collections.sort(lista, Comparator.comparing(Aluno::getNome));
    }
    @Override
    public Aluno[] carregarDeArquivo() throws ArquivoInvalidoException {
        Aluno[] temp = new Aluno[4];
        // throw new ArquivoInvalidoException("Arquivo invalido!");
        return temp;
    }
}
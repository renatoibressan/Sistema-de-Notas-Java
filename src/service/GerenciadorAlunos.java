package service;
import model.Aluno;
import exceptions.AlunoNaoEncontradoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GerenciadorAlunos {
    private HashMap<Integer, Aluno> alunos;
    private List<Aluno> lista = new ArrayList<>(alunos.values());
    private int total;
    private int ultimaMatricula;
    public int gerarMatricula() {
        return ultimaMatricula + 1;
    }
    public void cadastrarAluno(String nome, int matricula) {
    }
    public void registrarNotas(int matricula, double n1, double n2, double n3) {
    }
    public Aluno buscarAluno(int matricula) throws AlunoNaoEncontradoException {
        Aluno temp = new Aluno("Joao", matricula);
        // throw new AlunoNaoEncontradoException("Aluno nao encontrado!");
        return temp;
    }
    public void listarAlunos() {
        Collections.sort(lista, Comparator.comparing(Aluno::getNome));
    }
}
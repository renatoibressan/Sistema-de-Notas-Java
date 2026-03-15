package service;
import model.Aluno;
import exceptions.AlunoNaoEncontradoException;
import exceptions.NotaInvalidaException;
import java.util.HashMap;
import java.time.LocalDate;

public class GerenciadorAlunos {
    private HashMap<Integer, Aluno> alunos;
    private int ultimaMatricula;
    private int anoAtual;
    public GerenciadorAlunos(int ultimaMatriculaInicial) {
        alunos = new HashMap<>();
        ultimaMatricula = ultimaMatriculaInicial;
        anoAtual = LocalDate.now().getYear();
    }
    public int gerarMatricula() {
        int contador, novaMatricula;
        if (ultimaMatricula == 0) contador = 1;
        else {
            contador = ultimaMatricula % 100000;
            contador++;
        }
        novaMatricula = anoAtual * 100000 + contador;
        ultimaMatricula = novaMatricula;
        return novaMatricula;
    }
    public void cadastrarAluno(String nome) {
        int matricula = gerarMatricula();
        Aluno aluno = new Aluno(nome, matricula);
        alunos.put(matricula, aluno);
    }
    public void registrarNotas(int matricula, double... notas) throws AlunoNaoEncontradoException {
        Aluno aluno = alunos.get(matricula);
        if (aluno == null) throw new AlunoNaoEncontradoException("Aluno nao encontrado!");
        try {
            aluno.registrarNotas(notas);
        } catch (NotaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
    public Aluno buscarAluno(int matricula) throws AlunoNaoEncontradoException {
        Aluno aluno = alunos.get(matricula);
        if (aluno == null) throw new AlunoNaoEncontradoException("Aluno nao encontrado!");
        else return aluno;
    }
    public void listarAlunos() {
    }
}
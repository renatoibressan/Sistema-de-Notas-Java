package service;
import model.Aluno;
import exceptions.AlunoNaoEncontradoException;
import exceptions.DivisaoPorZeroException;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;

public class GerenciadorAlunos {
    private TreeMap<Integer, Aluno> alunos;
    private int ultimaMatricula;
    public GerenciadorAlunos(int ultimaMatriculaInicial) {
        alunos = new TreeMap<>();
        ultimaMatricula = ultimaMatriculaInicial;
    }
    public TreeMap<Integer, Aluno> getAlunos() {
        return alunos;
    }
    public int getUltimaMatricula() {
        return ultimaMatricula;
    }
    public void setUltimaMatricula(int ultimaMatricula) {
        this.ultimaMatricula = ultimaMatricula;
    }
    public void inserirAlunoExistente(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }
    public int gerarMatricula() {
        int contador, novaMatricula;
        int anoAtual = LocalDate.now().getYear();
        if (ultimaMatricula == 0) contador = 1;
        else {
            contador = ultimaMatricula % 100000;
            contador++;
        }
        novaMatricula = anoAtual * 100000 + contador;
        ultimaMatricula = novaMatricula;
        return novaMatricula;
    }
    public Aluno cadastrarAluno(String nome) {
        int matricula = gerarMatricula();
        Aluno aluno = new Aluno(nome, matricula);
        alunos.put(matricula, aluno);
        return aluno;
    }
    public Aluno buscarAluno(int matricula) throws AlunoNaoEncontradoException {
        Aluno aluno = alunos.get(matricula);
        if (aluno == null) throw new AlunoNaoEncontradoException("Aluno nao encontrado!");
        else return aluno;
    }
    public void listarAlunos() {
        List<Aluno> listaOrdenada = new ArrayList<>(alunos.values());
        Collections.sort(listaOrdenada);
        for (Aluno aluno : listaOrdenada) {
            System.out.println("\nNome do aluno: " + aluno.getNome());
            System.out.println("matricula do aluno: " + aluno.getMatricula());
            System.out.println("Notas do aluno: ");
            for (double nota : aluno.getNotas()) {
                System.out.print(String.format("%.2f", nota) + " ");
            }
            try {
                double media = aluno.calcularMedia();
                System.out.println("\nMedia: " + String.format("%.2f", media));
            } catch (DivisaoPorZeroException e) {
                 System.out.println("\n" + e.getMessage());
            }
        }
    }
}
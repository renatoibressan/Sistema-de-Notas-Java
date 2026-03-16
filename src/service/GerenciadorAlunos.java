package service;
import model.Aluno;
import exceptions.AlunoNaoEncontradoException;
import exceptions.DivisaoPorZeroException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;

public class GerenciadorAlunos {
    private HashMap<Integer, Aluno> alunos;
    private int ultimaMatricula;
    private int anoAtual;
    private double media;
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
    public Aluno cadastrarAluno(String nome) {
        int matricula = gerarMatricula();
        Aluno aluno = new Aluno(nome, matricula);
        alunos.put(matricula, aluno);
        return aluno;
    }
    // public void registrarNotas(int matricula, double... notas) throws AlunoNaoEncontradoException {
    //     Aluno aluno = alunos.get(matricula);
    //     if (aluno == null) throw new AlunoNaoEncontradoException("Aluno nao encontrado!");
    //     else {
    //         try {
    //             aluno.registrarNotas(notas);
    //         } catch (NotaInvalidaException e) {
    //             System.out.println("\n" + e.getMessage());
    //         }
    //     }
    // }
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
                media = aluno.calcularMedia();
                System.out.println("\nMedia: " + String.format("%.2f", media));
            } catch (DivisaoPorZeroException e) {
                 System.out.println("\n" + e.getMessage());
            }
        }
    }
}
package com.academico.sistema.model;
import com.academico.sistema.exceptions.DivisaoPorZeroException;
import com.academico.sistema.exceptions.NotaInvalidaException;
import java.util.ArrayList;
import java.util.List;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private int matricula;
    private List<Double> notas;
    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new ArrayList<>();
    }
    public int getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public List<Double> getNotas() {
        return notas;
    }
    public void registrarNotas(double... notas) throws NotaInvalidaException {
        for (double nota : notas) {
            if (nota < 0.0 || nota > 10.0) throw new NotaInvalidaException("Nota invalida!");
            this.notas.add(nota);
        }
    }
    public double calcularMedia() throws DivisaoPorZeroException {
        double soma = 0.0;
        if (notas.size() == 0) throw new DivisaoPorZeroException("Notas nao encontradas!");
        else {
            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.size();
        }
    }
    public int compareTo(Aluno another) {
        return Integer.compare(this.matricula, another.matricula);
    }
}
package model;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private int matricula;
    private double[] notas;
    public Aluno(String nome, int matricula) {
    }
    public int getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public void registrarNotas(double n1, double n2, double n3) {
    }
    public double calcularMedia() {
        double soma = 0.0;
        return soma;
    }
    public int compareTo(Aluno another) {
        return Integer.compare(this.matricula, another.matricula);
    }
}
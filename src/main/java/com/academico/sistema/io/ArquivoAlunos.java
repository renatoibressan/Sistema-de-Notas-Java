package com.academico.sistema.io;
import com.academico.sistema.model.Aluno;
import com.academico.sistema.service.GerenciadorAlunos;
import com.academico.sistema.exceptions.NotaInvalidaException;
import java.util.Map;
import java.io.*;


public class ArquivoAlunos implements PersistenciaAlunos {
    private String caminhoArquivo;
    public ArquivoAlunos(String nomeArquivo) {
        this.caminhoArquivo = nomeArquivo;
    }
    @Override
    public void salvarNoArquivo(GerenciadorAlunos gerenciador) throws IOException {
        File arquivo = new File(caminhoArquivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            Map<Integer, Aluno> mapa = gerenciador.getAlunos();
            for (Aluno aluno : mapa.values()) {
                StringBuilder stringNotas = new StringBuilder();
                for (double nota : aluno.getNotas()) {
                    stringNotas.append(nota);
                    stringNotas.append("; ");
                }
                if (stringNotas.length() > 0) stringNotas.setLength(stringNotas.length() - 2);
                String linha = aluno.getMatricula() + " | " + aluno.getNome() + " | " + stringNotas;
                writer.write(linha);
                writer.newLine();
            }
        }
    }
    @Override
    public void carregarDeArquivo(GerenciadorAlunos gerenciador) throws IOException {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) return;
        int maiorMatricula = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            int linhaNumero = 0;
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhaNumero++;
                try {
                    String[] partes = linha.split(" \\| ");
                    if (partes.length != 3) throw new IllegalArgumentException("Formato invalido!");
                    int matricula = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String stringNotas = partes[2];
                    Aluno aluno = new Aluno(nome, matricula);
                    if (!stringNotas.isEmpty()) {
                        String[] strNotasArray = stringNotas.split("; ");
                        boolean alunoValido = true;
                        for (String strNotas : strNotasArray) {
                            double nota = Double.parseDouble(strNotas);
                            try {
                                aluno.registrarNotas(nota);
                            } catch (NotaInvalidaException e) {
                                System.out.println("\n" + e.getMessage());
                                alunoValido = false;
                                break;
                            }
                        }
                        if (alunoValido) gerenciador.inserirAlunoExistente(aluno);
                    }
                    if (matricula > maiorMatricula) maiorMatricula = matricula;
                } catch (Exception  e) {
                    System.out.println("\nErro na linha " + linhaNumero + ": " + linha);
                }
            }
        }
        gerenciador.setUltimaMatricula(maiorMatricula);
    }
}
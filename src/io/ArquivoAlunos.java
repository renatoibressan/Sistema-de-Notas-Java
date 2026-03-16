package io;
import model.Aluno;
import service.GerenciadorAlunos;
import io.PersistenciaAlunos;
import exceptions.ArquivoInvalidoException;
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
    public void carregarDeArquivo(GerenciadorAlunos gerenciadorAlunos) throws IOException, ArquivoInvalidoException {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) return;
        BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
        reader.close();
        throw new ArquivoInvalidoException("Arquivo invalido!");
    }
}
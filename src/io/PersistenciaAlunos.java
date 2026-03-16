package io;
import service.GerenciadorAlunos;
import exceptions.ArquivoInvalidoException;
import java.io.*;


public interface PersistenciaAlunos {
    public void salvarNoArquivo(GerenciadorAlunos gerenciador) throws IOException;
    public void carregarDeArquivo(GerenciadorAlunos gerenciadorAlunos) throws IOException, ArquivoInvalidoException;
}
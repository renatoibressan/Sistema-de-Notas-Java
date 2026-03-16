package io;
import service.GerenciadorAlunos;
import java.io.*;


public interface PersistenciaAlunos {
    public void salvarNoArquivo(GerenciadorAlunos gerenciador) throws IOException;
    public void carregarDeArquivo(GerenciadorAlunos gerenciador) throws IOException;
}
package com.academico.sistema.io;
import com.academico.sistema.service.GerenciadorAlunos;
import java.io.*;


public interface PersistenciaAlunos {
    public void salvarNoArquivo(GerenciadorAlunos gerenciador) throws IOException;
    public void carregarDeArquivo(GerenciadorAlunos gerenciador) throws IOException;
}
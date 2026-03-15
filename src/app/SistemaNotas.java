package app;
import model.Aluno;
import service.GerenciadorAlunos;
import io.*;
import exceptions.*;
import java.util.Scanner;
import java.util.Locale;

public class SistemaNotas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        PersistenciaAlunos arq = new ArquivoAlunos();
        Aluno aluno;
        char option = 'X';
    }
}
package app;
import model.Aluno;
import service.GerenciadorAlunos;
import io.*;
import exceptions.AlunoNaoEncontradoException;
import exceptions.DivisaoPorZeroException;
import exceptions.NotaInvalidaException;
import java.util.Scanner;
import java.util.Locale;
import java.io.IOException;

public class SistemaNotas {
    public static void main(String[] args) throws InterruptedException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        GerenciadorAlunos gerenciador;
        PersistenciaAlunos arquivo;
        int opcao = -1, matricula = 0;
        double nota = 10.1, media;
        String nomeTeste;
        String nomeArquivo = "alunos_" + System.currentTimeMillis() + ".txt";
        String load = "...";
        gerenciador = new GerenciadorAlunos(matricula);
        System.out.println("\n====== SISTEMA GERENCIADOR DE NOTAS E ALUNOS ======\n");
        System.out.println("Desenvolvido por: Renato Ikeda Bressan");
        while (opcao != 0) {
            System.out.println("\nOpcoes:\n1. Cadastrar aluno\n2. Registrar notas\n3. Listar alunos");
            System.out.println("4. Buscar aluno\n5. Salvar em arquivo\n6. Carregar de arquivo\n0. Sair do programa\n");
            System.out.print("Insira uma das opcoes acima: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("\nInsira um nome para cadastro: ");
                    sc.nextLine();
                    nomeTeste = sc.nextLine();
                    Aluno aluno = gerenciador.cadastrarAluno(nomeTeste);
                    System.out.println("\nAluno cadastrado!" + "\nNome: " + aluno.getNome() + "\nMatricula: " + aluno.getMatricula());
                    break;
                case 2:
                    System.out.print("\nEntre com uma matricula para procura do aluno: ");
                    matricula = sc.nextInt();
                    try {
                        Aluno a = gerenciador.buscarAluno(matricula);
                        while (true) {
                            System.out.print("\nInsira uma nota de 0 a 10 (ou -1 para encerrar o processo): ");
                            nota = sc.nextDouble();
                            if (nota == -1.0) {
                                break;
                            }
                            try {
                                a.registrarNotas(nota);
                            } catch (NotaInvalidaException ee) {
                                System.out.println("\n" + ee.getMessage());
                            }
                        }
                        System.out.println("\nNotas de " + a.getNome() + " registradas com sucesso!");
                    } catch (AlunoNaoEncontradoException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\nAlunos listados:");
                    gerenciador.listarAlunos();
                    break;
                case 4:
                    System.out.print("\nEntre com uma matricula para procura do aluno: ");
                    matricula = sc.nextInt();
                    try {
                        Aluno a = gerenciador.buscarAluno(matricula);
                        System.out.println("\nAluno encontrado!\n");
                        System.out.println("Dados do aluno:\nNome: " + a.getNome());
                        System.out.println("Matricula: " + a.getMatricula());
                        System.out.println("Notas:");
                        for (double n : a.getNotas()) {
                            System.out.print(String.format("%.2f", n) + " ");
                        }
                        System.out.print("\n");
                        try {
                            media = a.calcularMedia();
                            System.out.println("Media: " + String.format("%.2f", media));
                        } catch (DivisaoPorZeroException ee) {
                            System.out.println("\n" + ee.getMessage());
                        }
                    } catch (AlunoNaoEncontradoException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;
                case 5:
                    arquivo = new ArquivoAlunos(nomeArquivo);
                    try {
                        arquivo.salvarNoArquivo(gerenciador);
                        System.out.println("\nArquivo criado com sucesso!");
                    } catch (IOException e) {
                        System.out.println("\nNao foi possivel escrever no arquivo!");
                    }
                    break;
                case 6:
                    arquivo = new ArquivoAlunos(nomeArquivo);
                    try {
                        arquivo.carregarDeArquivo(gerenciador);
                    } catch (IOException e) {
                        System.out.println("\nNao foi possivel ler do arquivo!");
                    }
                    break;
                case 0:
                    System.out.print("\nEncerrando o programa");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("\nOpcao invalida!\n");
                    sc.nextLine();
                    System.out.print("Retornando ao menu do programa principal");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    System.out.print("\n");
            }
        }
        sc.close();
    }
}
package com.academico.sistema.servlet;
import com.academico.sistema.service.GerenciadorAlunos;
import com.academico.sistema.io.ArquivoAlunos;
import com.academico.sistema.model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/arquivo/salvar", "/arquivo/carregar"})
public class ArquivoServlet extends HttpServlet {
    private GerenciadorAlunos getGerenciador() {
        return (GerenciadorAlunos) getServletContext().getAttribute("gerenciador");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArquivoAlunos arquivo = new ArquivoAlunos("alunos.txt");
        String caminho = request.getServletPath();
        switch (caminho) {
            case "/arquivo/salvar":
                try {
                    arquivo.salvarNoArquivo(getGerenciador());
                    request.setAttribute("mensagem", "Arquivo criado com sucesso!");
                } catch (IOException e) {
                    request.setAttribute("erro", "Não foi possível escrever no arquivo!");
                }
                request.getRequestDispatcher("/alunos.jsp").forward(request, response);
                break;
            case "/arquivo/carregar":
                try {
                    arquivo.carregarDeArquivo(getGerenciador());
                    request.setAttribute("mensagem", "Alunos carregados com sucesso!");
                } catch (IOException e) {
                    request.setAttribute("erro", "Não foi possível ler do arquivo!");
                }
                List<Aluno> alunos = getGerenciador().listarAlunos();
                request.setAttribute("alunos", alunos);
                request.getRequestDispatcher("/alunos.jsp").forward(request, response);
                break;
        }
    }
}
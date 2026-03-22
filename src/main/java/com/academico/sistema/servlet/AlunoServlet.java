package com.academico.sistema.servlet;
import com.academico.sistema.model.Aluno;
import com.academico.sistema.service.GerenciadorAlunos;
import com.academico.sistema.exceptions.AlunoNaoEncontradoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/alunos/cadastrar", "/alunos/listar", "/alunos/buscar"})
public class AlunoServlet extends HttpServlet {
    private GerenciadorAlunos getGerenciador() {
        return (GerenciadorAlunos) getServletContext().getAttribute("gerenciador");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath();
        switch (caminho) {
            case "/alunos/listar":
                List<Aluno> alunos = getGerenciador().listarAlunos();
                request.setAttribute("alunos", alunos);
                request.getRequestDispatcher("/alunos.jsp").forward(request, response);
                break;
            case "/alunos/buscar":
                try {
                    int matricula = Integer.parseInt(request.getParameter("matricula"));
                    Aluno aluno = getGerenciador().buscarAluno(matricula);
                    request.setAttribute("mensagem", "Aluno encontrado!");
                    request.setAttribute("aluno", aluno);
                    request.getRequestDispatcher("/alunos.jsp").forward(request, response);
                } catch (AlunoNaoEncontradoException e) {
                    request.setAttribute("erro", e.getMessage());
                    request.getRequestDispatcher("/alunos.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("erro", "Matrícula inválida.");
                    request.getRequestDispatcher("/alunos.jsp").forward(request, response);
                }
                break;
            case "/alunos/cadastrar":
                request.getRequestDispatcher("/cadastrar.jsp").forward(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String caminho = request.getServletPath();
        if (caminho.equals("/alunos/cadastrar")) {
            String nome = request.getParameter("nome");
            Aluno aluno = getGerenciador().cadastrarAluno(nome);
            request.setAttribute("mensagem", "Aluno cadastrado! Nome: " + aluno.getNome() + " | Matrícula: " + aluno.getMatricula());
            List<Aluno> alunos = getGerenciador().listarAlunos();
            request.setAttribute("alunos", alunos);
            request.getRequestDispatcher("/alunos.jsp").forward(request, response);
        }
    }
}
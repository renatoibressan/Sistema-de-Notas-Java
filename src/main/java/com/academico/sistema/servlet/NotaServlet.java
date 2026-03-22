package com.academico.sistema.servlet;
import com.academico.sistema.service.GerenciadorAlunos;
import com.academico.sistema.exceptions.AlunoNaoEncontradoException;
import com.academico.sistema.exceptions.NotaInvalidaException;
import com.academico.sistema.model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notas/registrar")
public class NotaServlet extends HttpServlet {
    private GerenciadorAlunos getGerenciador() {
        return (GerenciadorAlunos) getServletContext().getAttribute("gerenciador");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/notas.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            double nota = Double.parseDouble(request.getParameter("nota"));
            Aluno aluno = getGerenciador().buscarAluno(matricula);
            aluno.registrarNotas(nota);
            request.setAttribute("mensagem", "Notas de " + aluno.getNome() + " registradas com sucesso!");
            request.getRequestDispatcher("/notas.jsp").forward(request, response);
        } catch (AlunoNaoEncontradoException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("/notas.jsp").forward(request, response);
        } catch (NotaInvalidaException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("/notas.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("erro", "Dados inválidos.");
            request.getRequestDispatcher("/notas.jsp").forward(request, response);
        }
    }
}
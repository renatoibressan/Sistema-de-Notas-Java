<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.academico.sistema.model.Aluno" %>
<%@ page import="com.academico.sistema.exceptions.DivisaoPorZeroException" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Alunos</title>
</head>
<body>
    <h1>Alunos Cadastrados</h1>

    <%-- Mensagens de erro e sucesso --%>
    <% if (request.getAttribute("erro") != null) { %>
        <p style="color:red;"><%= request.getAttribute("erro") %></p>
    <% } %>
    <% if (request.getAttribute("mensagem") != null) { %>
        <p style="color:green;"><%= request.getAttribute("mensagem") %></p>
    <% } %>

    <%
        List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
        if (alunos != null && !alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
    %>
        <div>
            <p><strong>Nome:</strong> <%= aluno.getNome() %></p>
            <p><strong>Matrícula:</strong> <%= aluno.getMatricula() %></p>
            <p><strong>Notas:</strong> <%= aluno.getNotas() %></p>
            <%-- Média do aluno, igual à main --%>
            <p><strong>Média:</strong>
            <%
                try {
                    out.print(String.format("%.2f", aluno.calcularMedia()));
                } catch (DivisaoPorZeroException e) {
                    out.print(e.getMessage());
                }
            %>
            </p>
        </div>
        <hr>
    <%
            }
        } else {
    %>
        <p>Nenhum aluno cadastrado.</p>
    <% } %>

    <a href="<%= request.getContextPath() %>/alunos/cadastrar">Cadastrar novo aluno</a> |
    <a href="<%= request.getContextPath() %>/notas/registrar">Registrar notas</a>

    <br><br>

    <form action="<%= request.getContextPath() %>/arquivo/salvar" method="post">
        <button type="submit">💾 Salvar em arquivo</button>
    </form>

    <form action="<%= request.getContextPath() %>/arquivo/carregar" method="post">
        <button type="submit">📂 Carregar de arquivo</button>
    </form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Aluno</title>
</head>
<body>
    <h1>Cadastrar Aluno</h1>

    <%-- Mensagens de erro e sucesso --%>
    <% if (request.getAttribute("erro") != null) { %>
        <p style="color:red;"><%= request.getAttribute("erro") %></p>
    <% } %>
    <% if (request.getAttribute("mensagem") != null) { %>
        <p style="color:green;"><%= request.getAttribute("mensagem") %></p>
    <% } %>

    <form action="<%= request.getContextPath() %>/alunos/cadastrar" method="post">
        <label>Nome do aluno:</label>
        <input type="text" name="nome" required />
        <button type="submit">Cadastrar</button>
    </form>

    <br>
    <a href="<%= request.getContextPath() %>/alunos/listar">Voltar para lista</a>
</body>
</html>
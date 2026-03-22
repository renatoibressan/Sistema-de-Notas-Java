<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Nota</title>
</head>
<body>
    <h1>Registrar Nota</h1>

    <%-- Mensagens de erro e sucesso --%>
    <% if (request.getAttribute("erro") != null) { %>
        <p style="color:red;"><%= request.getAttribute("erro") %></p>
    <% } %>
    <% if (request.getAttribute("mensagem") != null) { %>
        <p style="color:green;"><%= request.getAttribute("mensagem") %></p>
    <% } %>

    <form action="<%= request.getContextPath() %>/notas/registrar" method="post">
        <label>Matrícula do aluno:</label>
        <input type="number" name="matricula" required />
        <br><br>
        <label>Nota (0 a 10):</label>
        <input type="number" step="0.1" min="0" max="10" name="nota" required />
        <br><br>
        <button type="submit">Registrar</button>
    </form>

    <br>
    <a href="<%= request.getContextPath() %>/alunos/listar">Voltar para lista</a>
</body>
</html>
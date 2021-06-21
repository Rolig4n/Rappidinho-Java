<%-- 
    Document   : listarEstado
    Created on : 30/05/2021, 22:04:40
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Estados</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
    </tr>
        <table align="center" border="1">
            <thead>
            <th colspan="6" align="center">Estados</th>
            <tr>
                <th class="border-top-0">ID</th>
                <th class="border-top-0">Nome</th>
                <th class="border-top-0">Sigla</th>
                <th class="border-top-0" colspan="2">Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="estado" items="${estados}">
                <tr>    
                    <td>${estado.idEstado}</td>
                    <td>${estado.nomeEstado}</td>
                    <td>${estado.siglaEstado}</td>
                    <td><a href="CarregarEstado?idestado=${estado.idEstado}">Alterar</a></td>
                    <td><a href="ExcluirEstado?idestado=${estado.idEstado}">Excluir</a></td>
                </tr>
            </c:forEach>
</tbody>
</table>
        <br></br>
           <div align="center">
            <a href="index.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/cadastros/estado/cadastrarEstado.jsp">Cadastrar Novo Estado</a>
        </div>
</body>
</html>
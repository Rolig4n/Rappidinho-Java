<%-- 
    Document   : listarCidade
    Created on : 30/05/2021, 22:04:30
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Cidades</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
    </tr>
        <table align="center" border="1">
            <thead>
            <th colspan="6" align="center">Cidades</th>
            <tr>
                <th class="border-top-0">ID</th>
                <th class="border-top-0">Nome</th>
                <th class="border-top-0">Estado</th>
                <th class="border-top-0" colspan="2">Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cidade" items="${cidades}">
                <tr>    
                    <td>${cidade.idCidade}</td>
                    <td>${cidade.nomeCidade}</td>
                    <td>${cidade.estado.siglaEstado}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarCidade?idcidade=${cidade.idCidade}">Alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirCidade?idcidade=${cidade.idCidade}">Excluir</a></td>
                </tr>
            </c:forEach>
</tbody>
</table>
        <br></br>
           <div align="center">
            <a href="index.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/DadosCidade">Cadastrar Nova Cidade</a>
        </div>
</body>
</html>
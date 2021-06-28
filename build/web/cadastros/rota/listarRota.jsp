<%-- 
    Document   : listarRota
    Created on : 18/06/2021, 17:55:27
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Rotas</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
</tr>
<table align="center" border="1">
    <thead>
    <th colspan="11" align="center">Rotas</th>
    <tr>
        <th class="border-top-0">ID</th>
        <th class="border-top-0">Nome Rota</th>
        <th class="border-top-0">Latitude Saída Rota</th>
        <th class="border-top-0">Longitude Saída Rota</th>
        <th class="border-top-0">Latitude Chegada Rota</th>
        <th class="border-top-0">Longitude Chegada Rota</th>
        <th class="border-top-0">Status</th>
        <th class="border-top-0">ID Pessoa</th>
        <th class="border-top-0">Nome Pessoa</th>
        <th class="border-top-0" colspan="2">Editar</th>
    </tr>
</thead>
<tbody>
    <c:forEach var="rota" items="${rotas}">
        <tr>    
            <td>${rota.idRota}</td>
            <td>${rota.nomeRota}</td>
            <td>${rota.latSaidaRota}</td>
            <td>${rota.lngSaidaRota}</td>
            <td>${rota.latChegadaRota}</td> 
            <td>${rota.lngChegadaRota}</td> 
            <td>${rota.statusRota}</td> 
            <td>${rota.contratado.idPessoa}</td> 
            <td>${rota.pessoa.nomePessoa}</td>  
            <td><a href="${pageContext.request.contextPath}/CarregarRota?idrota=${rota.idRota}">Alterar</a></td>
            <td><a href="${pageContext.request.contextPath}/ExcluirRota?idrota=${rota.idRota}">Excluir</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>
<br></br>
<div align="center">
    <a href="/index.jsp">Home</a>
    <a href="${pageContext.request.contextPath}/DadosRota">Cadastrar Nova Rota</a>
</div>
</body>
</html>

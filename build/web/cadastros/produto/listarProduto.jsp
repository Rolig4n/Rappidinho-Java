<%-- 
    Document   : listarProduto
    Created on : 20/06/2021, 12:36:33
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Produtos</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
</tr>
<table align="center" border="1">
    <thead>
    <th colspan="8" align="center">Produtos</th>
    <tr>
        <th class="border-top-0">Foto</th>
        <th class="border-top-0">ID</th>
        <th class="border-top-0">Nome do Produto</th>
        <th class="border-top-0">Descrição do Produto</th>
        <th class="border-top-0">Produto da Pessoa:</th>
        <th class="border-top-0" colspan="2">Editar</th>

    </tr>
</thead>
<tbody>
    <c:forEach var="produto" items="${produtos}">
        <tr>  
            <td><img src="${pageContext.request.contextPath}/MostrarFotoProduto?idproduto=${produto.idProduto}" height="100" width="100" /></td>
            <td>${produto.idProduto}</td>
            <td>${produto.nomeProduto}</td>
            <td>${produto.descricaoProduto}</td>
            <td>${produto.pessoa.nomePessoa}</td>
            <td><a href="${pageContext.request.contextPath}/CarregarProduto?idproduto=${produto.idProduto}">Alterar</a></td>
            <td><a href="${pageContext.request.contextPath}/ExcluirProduto?idproduto=${produto.idProduto}">Excluir</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>
<br></br>
<div align="center">
    <a href="index.jsp">Home</a>
    <a href="${pageContext.request.contextPath}/DadosProduto">Cadastrar Novo Produto</a>
</div>
</body>
</html>

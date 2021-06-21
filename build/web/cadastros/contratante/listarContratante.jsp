<%-- 
    Document   : listarContratante
    Created on : 13/06/2021, 13:26:09
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Contratantes</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
    </tr>
        <table align="center" border="1">
            <thead>
            <th colspan="11" align="center">Contratantes</th>
            <tr>
                <th class="border-top-0">Foto</th>
                <th class="border-top-0">ID</th>
                <th class="border-top-0">Nome</th>
                <th class="border-top-0">Email</th>
                <th class="border-top-0">CPF</th>
                <th class="border-top-0">Endereço</th>
                <th class="border-top-0">Telefone</th>
                <th class="border-top-0">Cidade</th>
                <th class="border-top-0">Estado</th>
                <th class="border-top-0" colspan="2">Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="contratante" items="${contratantes}">
                <tr>  
                    <td><img src="${pageContext.request.contextPath}/MostrarFotoContratante?idpessoa=${contratante.idPessoa}" height="150" width="150" /></td>
                    <td>${contratante.idPessoa}</td>
                    <td>${contratante.nomePessoa}</td>
                    <td>${contratante.emailPessoa}</td>
                    <td>${contratante.cpfPessoa}</td>
                    <td>${contratante.enderecoPessoa}</td>
                    <td>${contratante.telefonePessoa}</td>
                    <td>${contratante.cidade.nomeCidade}</td>
                    <td>${contratante.estado.siglaEstado}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarContratante?idpessoa=${contratante.idPessoa}">Alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirContratante?idpessoa=${contratante.idPessoa}">Excluir</a></td>
                </tr>
            </c:forEach>
</tbody>
</table>
        <br></br>
           <div align="center">
            <a href="index.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/DadosContratante">Cadastrar Novo Contratante>
        </div>
</body>
</html>


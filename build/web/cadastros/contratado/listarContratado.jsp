<%-- 
    Document   : listarContratado
    Created on : 13/06/2021, 13:28:00
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Contratados</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
    </tr>
        <table align="center" border="1">
            <thead>
            <th colspan="11" align="center">Contratados</th>
            <tr>
                <th class="border-top-0">Foto</th>
                <th class="border-top-0">ID</th>
                <th class="border-top-0">Nome</th>
                <th class="border-top-0">Email</th>
                <th class="border-top-0">CPF</th>
                <th class="border-top-0">CNH</th>
                <th class="border-top-0">Endereço</th>
                <th class="border-top-0">Telefone</th>
                <th class="border-top-0">Cidade</th>
                <th class="border-top-0">Estado</th>
                <th class="border-top-0" colspan="2">Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="contratado" items="${contratados}">
                <tr>  
                    <td><img src="${pageContext.request.contextPath}/MostrarFotoContratado?idpessoa=${contratado.idPessoa}" height="150" width="150" /></td>
                    <td>${contratado.idPessoa}</td>
                    <td>${contratado.nomePessoa}</td>
                    <td>${contratado.emailPessoa}</td>
                    <td>${contratado.cpfPessoa}</td>
                    <td>${contratado.cnhContratado}</td>
                    <td>${contratado.enderecoPessoa}</td>
                    <td>${contratado.telefonePessoa}</td>
                    <td>${contratado.cidade.nomeCidade}</td>
                    <td>${contratado.estado.siglaEstado}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarContratado?idpessoa=${contratado.idPessoa}">Alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirContratado?idpessoa=${contratado.idPessoa}">Excluir</a></td>
                </tr>
            </c:forEach>
</tbody>
</table>
        <br></br>
           <div align="center">
            <a href="index.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/DadosContratado">Cadastrar Novo Contratado</a>
        </div>
</body>
</html>


<%-- 
    Document   : listarAdministrador]
    Created on : 30/05/2021, 20:41:31
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Administradores</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
    </tr>
        <table align="center" border="1">
            <thead>
            <th colspan="11" align="center">Administradores</th>
            <tr>
                <th class="border-top-0">ID</th>
                <th class="border-top-0">Nome</th>
                <th class="border-top-0">Email</th>
                <th class="border-top-0">CPF</th>
                <th class="border-top-0">RG</th>
                <th class="border-top-0">Endereço</th>
                <th class="border-top-0">Telefone</th>
                <th class="border-top-0">Cidade</th>
                <th class="border-top-0">Estado</th>
                <th class="border-top-0" colspan="2">Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="administrador" items="${administradores}">
                <tr>    
                    <td>${administrador.idPessoa}</td>
                    <td>${administrador.nomePessoa}</td>
                    <td>${administrador.emailPessoa}</td>
                    <td>${administrador.cpfPessoa}</td>
                    <td>${administrador.rgAdministrador}</td>
                    <td>${administrador.enderecoPessoa}</td>
                    <td>${administrador.telefonePessoa}</td>
                    <td>${administrador.cidade.nomeCidade}</td>
                    <td>${administrador.estado.siglaEstado}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarAdministrador?idpessoa=${administrador.idPessoa}">Alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirAdministrador?idpessoa=${administrador.idPessoa}">Excluir</a></td>
                </tr>
            </c:forEach>
</tbody>
</table>
        <br></br>
           <div align="center">
            <a href="index.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/DadosAdministrador">Cadastrar Novo Admin</a>
        </div>
</body>
</html>

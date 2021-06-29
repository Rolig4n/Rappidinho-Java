<%-- 
    Document   : listarVeiculo
    Created on : 20/06/2021, 11:19:12
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Lista de Veiculos</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
    </tr>
        <table align="center" border="1">
            <thead>
            <th colspan="8" align="center">Veiculos</th>
            <tr>
                <th class="border-top-0">ID</th>
                <th class="border-top-0">Nome do Veículo</th>
                <th class="border-top-0">Renavam do Veículo</th>
                <th class="border-top-0">Tipo de Veículo</th>
                <th class="border-top-0">Nome Contratado</th>
                <th class="border-top-0" colspan="2">Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="veiculo" items="${veiculos}">
                <tr>    
                    <td>${veiculo.idVeiculo}</td>
                    <td>${veiculo.nomeVeiculo}</td>
                    <td>${veiculo.renavamVeiculo}</td>
                    <td>${veiculo.tipoVeiculo}</td>
                    <td>${veiculo.pessoa.nomePessoa}</td>
                    <td><a href="CarregarVeiculo?idveiculo=${veiculo.idVeiculo}">Alterar</a></td>
                    <td><a href="ExcluirVeiculo?idveiculo=${veiculo.idVeiculo}">Excluir</a></td>
                </tr>
            </c:forEach>
</tbody>
</table>
        <br></br>
           <div align="center">
            <a href="${pageContext.request.contextPath}/DadosVeiculo">Cadastrar Novo Veiculo</a>
        </div>
</body>
</html>
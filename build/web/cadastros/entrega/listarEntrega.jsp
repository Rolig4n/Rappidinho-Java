<%-- 
    Document   : listarEntrega
    Created on : 13/06/2021, 13:32:48
    Author     : fbrcmmelo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

        <title>Lista de Entregas</title>
    </head>
    <body>
    <tr>
    <hr>
    <th colspan="2" align="center">${mensagem}</th>
    <th colspan="2" align="center">${resposta}</th>
</tr>
<table align="center" border="1">
    <thead>
    <center><p>(A)<b>Aguardando</b> (T)<b>Em Transporte</b> (R)<b>Realizada</b></p></center>
    <th colspan="13" align="center">Entregas</th>
    <tr>
        <th class="border-top-0">ID</th>
        <th class="border-top-0">Data</th>
        <th class="border-top-0">Status Entrega</th>
        <th class="border-top-0">ID Contratado</th>
        <th class="border-top-0">ID Pedido</th>
        <th class="border-top-0" colspan="2">Editar</th>
        <th class="border-top-0" colspan="2">Alterar Status</th>
        

    </tr>
</thead>
<tbody>
    <tr>
        <c:forEach var="entrega" items="${entregas}">
            <td>${entrega.idEntrega}</td>
            <td>${entrega.dataEntrega}</td>
            <td>${entrega.statusEntrega}</td>
            <td>${entrega.contratado.idContratado}</td>
            <td>${entrega.pedido.idPedido}</td>
            <td><a href="${pageContext.request.contextPath}/CarregarEntrega?identrega=${entrega.idEntrega}">Alterar</a></td>
            <td><a href="${pageContext.request.contextPath}/ExcluirEntrega?identrega=${entrega.idEntrega}">Excluir</a></td>
            <td><a href="${pageContext.request.contextPath}/AlterarStatusEntrega?identrega=${entrega.idEntrega}&statusentrega=t">Em Transporte</a></td>
            <td><a href="${pageContext.request.contextPath}/AlterarStatusEntrega?identrega=${entrega.idEntrega}&statusentrega=r">Realizada</a></td>

        </c:forEach>
    </tr>
</tbody>
</table>
<br></br>
<div align="center">
    <a href="${pageContext.request.contextPath}/cadastros.jsp">Voltar</a>
    <a href="${pageContext.request.contextPath}/DadosEntrega">Cadastrar Novo Entrega</a>
</div>
</body>
</html>
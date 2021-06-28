<%-- 
    Document   : listarPedido
    Created on : 20/06/2021, 11:19:41
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
            <title>Lista de Pedidos</title>
        </head>
        <body>
        <tr>
        <hr>
        <th colspan="2" align="center">${mensagem}</th>
        </tr>
            <table align="center" border="1">
                <thead>
                <th colspan="11" align="center">Pedidos</th>
                <tr>
                    <th class="border-top-0">ID</th>
                    <th class="border-top-0">Data Pedido</th>
                    <th class="border-top-0">Latitude Destino</th>
                    <th class="border-top-0">Longitude Destino</th>
                    <th class="border-top-0">Produto</th>
                    <th class="border-top-0">Contratado</th>
                    <th class="border-top-0">Rota</th>
                    <th class="border-top-0">Status do Pedido</th>
                    <th class="border-top-0">Excluir</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pedido" items="${pedidos}">
                    <tr>    
                        <td>${pedido.idPedido}</td>
                        <td>${pedido.dataPedido}</td>
                        <td>${pedido.latDestinoPedido}</td> 
                        <td>${pedido.lngDestinoPedido}</td>
                        <td>${pedido.produto.nomeProduto}</td> 
                        <td>${pedido.pessoa.nomePessoa}</td> 
                        <td>${pedido.rota.nomeRota}</td>
                        <td>${pedido.statusPedido}</td> 
                        <td><a href="${pageContext.request.contextPath}/ExcluirPedido?idpedido=${pedido.idPedido}">Excluir</a></td>
                    </tr>
                </c:forEach>
    </tbody>
    </table>
            <br></br>
               <div align="center">
                   <a href="${pageContext.request.contextPath}/cadastros.jsp">Voltar</a>
                <a href="${pageContext.request.contextPath}/DadosPedido">Cadastrar Novo Pedido</a>
            </div>
    </body>
    </html>

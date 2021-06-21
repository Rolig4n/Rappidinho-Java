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
            <title>Lista de Entregaes</title>
        </head>
        <body>
        <tr>
        <hr>
        <th colspan="2" align="center">${mensagem}</th>
        </tr>
            <table align="center" border="1">
                <thead>
                <th colspan="11" align="center">Entregas</th>
                <tr>
                    <th class="border-top-0">ID</th>
                    <th class="border-top-0">Data Pedido</th>
                    <th class="border-top-0">Data Entrega</th>
                    <th class="border-top-0">Pedido</th>
                    <th class="border-top-0">Rota</th>
                    <th class="border-top-0">Remetente</th>
                    <th class="border-top-0">Latitude Saída</th>
                    <th class="border-top-0">Longitude Saída</th>
                    <th class="border-top-0">Latitude Destino</th>
                    <th class="border-top-0">Longitude Destino</th>
                    <th class="border-top-0">Status</th>
                    <th class="border-top-0" colspan="2">Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entrega" items="${entregaes}">
                    <tr>    
                        <td>${entrega.idEntrega}</td>
                        <td>${entrega.pedido.dataPedido}</td>
                        <td>${entrega.dataEntrega}</td>
                        <td>${entrega.pedido.idPedido}</td>
                        <td>${entrega.rota.nomeRota}</td> 
                        <td>${entrega.contratante.nomeContratante}</td> 
                        <td>${entrega.rota.latSaidaRota}</td> 
                        <td>${entrega.rota.lngSaidaRota}</td> 
                        <td>${entrega.rota.latDestinoPedido}</td> 
                        <td>${entrega.rota.lngDestinoPedido}</td> 
                        <td>${entrega.status}</td> 
                        <td><a href="${pageContext.request.contextPath}/CarregarEntrega?idpessoa=${entrega.idEntrega}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/ExcluirEntrega?idpessoa=${entrega.idEntrega}">Excluir</a></td>
                    </tr>
                </c:forEach>
    </tbody>
    </table>
            <br></br>
               <div align="center">
                <a href="/index.jsp">Home</a>
                <a href="${pageContext.request.contextPath}/DadosEntrega">Cadastrar Nova Entrega</a>
            </div>
    </body>
    </html>

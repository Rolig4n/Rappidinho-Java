<%-- 
    Document   : cadastrarPedido
    Created on : 20/06/2021, 13:06:51
    Author     : fbrcmmelo
--%> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Pedido</title>
    </head>
    <body>
    <tr>
    <p>Cadastro de Pedidos</p>
    <hr>
    <form name="cadastrarPedido" action="${pageContext.request.contextPath}/CadastrarPedido" method="POST">
        <p>ID:</p>
        <label><input type="number" id="idpedido" name="idpedido" value="${pedido.idPedido}" readonly="true"/></label>
        <p>Data:</p>
        <label><input type="text" name="datapedido" id="datapedido" value="<fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${datapedido}"></fmt:formatDate>" ></label>
        <p>Latitude Destino Pedido:</p>
        <label><input type="number" id="latdestinopedido" step="0.00000001" value="${pedido.latDestinoPedido}" placeholder="" name="latdestinopedido" maxlength="10" required="true"/></label>
        <p>Longitude Destino Pedido:</p>
        <label><input type="number" id="lngdestinopedido" step="0.00000001" value="${pedido.lngDestinoPedido}" placeholder="" name="lngdestinopedido" maxlength="11" required="true"/></label>
        <p>ID Contratado:</p>
        <select id="idcontratado" name="idcontratado">
            <c:forEach var="contratado" items="${contratados}">
                <option value="${contratado.idContratado}" ${pedido.contratado.idContratado == contratado.idContratado ? 'selected' : '' }>${contratado.nomePessoa}</option>   
            </c:forEach>
        </select>
        <p>Produto:</p>
        <select name="idproduto" id="idproduto">
            <c:forEach var="produto" items="${produtos}">                        
                <option value="${produto.idProduto}" ${pedido.produto.idProduto == produto.idProduto ? 'selected' : ''} >${produto.nomeProduto}</option>                               
            </c:forEach> </select>
        <p>Rota:</p>
        <select name="idrota" id="idrota">
            <c:forEach var="rota" items="${rotas}">                        
                <option value="${rota.idRota}" ${pedido.rota.idRota == rota.idRota ? 'selected' : ''} >${rota.nomeRota}</option>                               
            </c:forEach> </select>
        <p>Contratante:</p>
        <label><input type="number" id="idpessoa" value="${pessoa.idPessoa}" name="idpessoa" placeholder="ID" readonly="true"/></label>
        <br></br>        
        <input type="submit" value="Cadastrar" name="cadastrar">
        <input type="reset" value="Limpar" name="Limpar ">
    </form>
    <br></br>
    <div align="center">
        <a href="ListarPedido">Voltar</a>

    </div>
</body>
</html>
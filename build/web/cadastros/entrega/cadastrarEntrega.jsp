<%-- 
    Document   : cadastrarEntrega
    Created on : 13/06/2021, 13:31:48
    Author     : fbrcmmelo
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Cadastro de Entrega</title>

    <body>
    <tr>
    <p>Cadastro de Entregaes</p>
    <hr>
</tr>
<form name="cadastrarEntrega" action="${pageContext.request.contextPath}/CadastrarEntrega" method="POST">
    <p>ID:</p>
    <label><input type="number" id="identrega" value="${entrega.idEntrega}" name="identrega" placeholder="ID" readonly="true"/></label>
    <p>Data:</p>
    <label><input type="data-form" id="dataentrega" value="${entrega.dataEntrega}" required="true" placeholder="Data" name="dataentrega" maxlength="100"/></label>
    <p>Pedido:</p>
    <select name="idpedido" id="idpedido">
        <c:forEach var="pedido" items="${pedidos}">                        
            <option value="${pedido.idPedido}" ${entrega.pedido.idPedido == pedido.idPedido ? 'selected' : ''} >${pedido.idPedido}</option>                               
        </c:forEach>
    </select>
    <p>Rota:</p>
    <select name="idrota" id="idrota">
        <c:forEach var="rota" items="${rotas}">                        
            <option value="${rota.idRota}" ${entrega.rota.idRota == rota.idRota ? 'selected' : ''} >${rota.nomeRota}</option>                               
        </c:forEach>
    </select>
    <br></br>
    <input type="submit" value="Cadastrar" name="cadastrar">
    <input type="reset" value="Limpar" name="Limpar ">
</form>
<br></br>
<div align="center">
    <a href="ListarEntrega">Voltar</a>

</div>
</body>
</html>

<%-- 
    Document   : cadastrarEntrega
    Created on : 13/06/2021, 13:31:48
    Author     : fbrcmmelo
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Cadastro de Entrega</title>

    <body>
    <tr>
    <p>Cadastro de Entregas</p>
    <hr>
</tr>
<form name="cadastrarEntrega" action="${pageContext.request.contextPath}/CadastrarEntrega" method="POST">
    <p>ID:</p>
    <label><input type="number" id="identrega" value="${entrega.idEntrega}" name="identrega" placeholder="ID" readonly="true"/></label>
     <p>Data:</p>
    <label><input type="text" name="dataentrega" id="dataentrega" value="<fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${dataentrega}"></fmt:formatDate>"/></label>
    <p>Status:</p>
    <label><input type="text" id="statusentrega" value="${entrega.statusEntrega}" name="statusentrega" placeholder="Status" readonly="true"/></label><p>Pedido / Contratado:<p>
    <select name="idpedido" id="idpedido">
        <c:forEach var="pedido" items="${pedidos}">                        
            <option value="${pedido.idPedido}" ${entrega.pedido.idPedido == pedido.idPedido ? 'selected' : ''} >${pedido.idPedido}</option>                               
            <label><input type="number" id="idcontratado" value="${pedido.contratado.idContratado}" name="idcontratado" placeholder="ID Contratado" readonly="true"/></label>
       <label><input type="text" id="nomepessoa" value="${pedido.pessoa.nomePessoa}" name="nomepessoa" placeholder="Pessoa" readonly="true"/></label> </c:forEach>
    </select>
    <p>Rota:</p>
        <c:forEach var="pedido" items="${pedidos}">                        
       <label><input type="text" id="nomerota" value="${pedido.rota.nomeRota}" name="nomerota" placeholder="Rota" readonly="true"/></label>
        </c:forEach>
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
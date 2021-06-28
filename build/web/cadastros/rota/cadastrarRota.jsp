<%-- 
    Document   : cadastrarRota
    Created on : 18/06/2021, 17:55:11
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Cadastro de Rota</title>

    <body>
    <tr>
    <p>Cadastro de Rotas</p>${contratado.idContratado}
    <hr>
</tr>
<form name="cadastrarRota" action="${pageContext.request.contextPath}/CadastrarRota" method="POST">
    <p>ID:</p>
    <label><input type="number" id="idrota" value="${rota.idRota}" name="idrota" placeholder="ID" readonly="true"/></label>
    <p>Nome da Rota:<p>
    <label><input type="text" id="nomerota" value="${rota.nomeRota}" required="true" placeholder="Exemplo Da Cidade à Cidade" name="nomerota" maxlength="100"/></label>
    <p>Latitude Saída Rota:</p>
    <label><input type="number" id="latsaidarota" step="0.00000001" value="${rota.latSaidaRota}" placeholder="" name="latsaidarota" maxlength="10"></label>
    <p>Longitude Saída Rota:</p>
    <label><input type="number" id="lngsaidarota" step="0.00000001" value="${rota.lngSaidaRota}" placeholder="" name="lngsaidarota" maxlength="11" /></label>
    <p>Latitude Destino Rota:</p>
    <label><input type="number" id="latchegadarota" step="0.00000001" value="${rota.latChegadaRota}" placeholder="" name="latchegadarota" maxlength="10"/></label>
    <p>Longitude Destino Rota:</p>
    <label><input type="number" id="lngchegadarota" step="0.00000001" value="${rota.lngChegadaRota}" placeholder="" name="lngchegadarota" maxlength="11"/></label>
    <p>Contratado:</p>
    <select name="idpessoa" id="idpessoa">
        <c:forEach var="contratado" items="${contratados}">                        
            <option value="${contratado.idPessoa}" ${rota.contratado.idPessoa == contratado.idPessoa ? 'selected' : ''} >${contratado.idPessoa}</option>                               
        </c:forEach>
            <select>  
            <br></br>
    <input type="submit" value="Cadastrar" name="cadastrar">
    <input type="reset" value="Limpar" name="Limpar ">
</form>
<br></br>
<div align="center">
    <a href="${pageContext.request.contextPath}/ListarRota">Voltar</a>

</div>
</body>
</html>

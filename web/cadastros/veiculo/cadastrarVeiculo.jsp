<%-- 
    Document   : cadastrarVeiculo
    Created on : 20/06/2021, 11:18:59
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Cadastro de Veiculo</title>

    <body>
    <tr>
    <p>Cadastro de Veiculos</p>
    <hr>
</tr>
<form name="cadastrarVeiculo" action="${pageContext.request.contextPath}/CadastrarVeiculo" method="POST">
    <p>ID:</p>
    <label><input type="number" id="idveiculo" value="${veiculo.idVeiculo}" name="idveiculo" placeholder="ID" readonly="true"/></label>
    <p>Nome do Veículo:<p>
        <label><input type="text" id="nomeveiculo" value="${veiculo.nomeVeiculo}" required="true" placeholder="Nome do Veiculo" name="nomeveiculo" maxlength="100"/></label>
    <p>Renavam do Veículo:</p>
    <label><input type="text" id="renavamveiculo" value="${veiculo.renavamVeiculo}" required="true" placeholder="Renavam do Veiculo" name="renavamveiculo" maxlength="9"></label>
    <p>Tipo do Veículo:</p>
    <label><input type="text" id="tipoveiculo" value="${veiculo.tipoVeiculo}" required="true" placeholder="Ex:Caminhão,Passeio,Motocicleta,C/ Carroceria" name="tipoveiculo" maxlength="100"/></label>
    <p>ID Dono Veículo:</p>
    <label><input type="number" id="idpessoa" value="${contratado.idPessoa}" name="idpessoa" readonly="true" placeholder="ID"/></label></td>

<br></br>
<input type="submit" value="Cadastrar" name="cadastrar">
<input type="reset" value="Limpar" name="Limpar ">
</form>
<br></br>
<div align="center">
    <a href="${pageContext.request.contextPath}/ListarVeiculo">Voltar</a>

</div>
</body>
</html>

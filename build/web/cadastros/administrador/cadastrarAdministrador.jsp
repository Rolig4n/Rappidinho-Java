<%-- 
   Document   : cadastrarAdministrador
   Created on : 30/05/2021, 20:41:17
   Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Cadastro de Admin's</title>
    </head>
    <body>
    <tr>
    <p>Cadastro de Administradores</p>
    <hr>
</tr>
<form name="cadastrarAdminstrador" action="${pageContext.request.contextPath}/CadastrarAdministrador" method="POST">
    <p>ID:</p>
    <label><input type="number" id="idpessoa" value="${administrador.idPessoa}" name="idpessoa" placeholder="ID" readonly="true"/></label>
    <p>Nome:</p>
    <label><input type="text" id="nomepessoa" value="${administrador.nomePessoa}" required="true" placeholder="Nome" name="nomepessoa" maxlength="100"/></label>
    <p>Email:</p>
    <label><input type="text" id="emailpessoa" value="${administrador.emailPessoa}" required="true" placeholder="Email" name="emailpessoa" maxlength="100"/></label>
    <p>Senha:</p>
    <label><input type="password" id="senhapessoa" value="${administrador.senhaPessoa}" required="true" placeholder="Senha" name="senhapessoa" maxlength="100"/></label>
    <p>CPF:</p>
    <label><input type="text" id="cpfpessoa" value="${administrador.cpfPessoa}" required="true" placeholder="CPF" name="cpfpessoa" maxlength="14"/></label>
    <p>Rg:</p>
    <label><input type="text" id="rgadministrador" value="${administrador.rgAdministrador}" required="true" placeholder="RG" name="rgadministrador" maxlength="12"/></label>
    <p>Endereço:</p>
    <label><input type="text" id="enderecopessoa" value="${administrador.enderecoPessoa}" required="true" placeholder="Rua .., numero .." name="enderecopessoa" maxlength="100"/></label>
    <p>Telefone:</p>
    <label><input type="text" id="telefonepessoa" value="${administrador.telefonePessoa}" required="true" placeholder="(xx)99xxx-xxxx" name="telefonepessoa" maxlength="14"/></label>
    <p>Cidade:</p>
    <select name="idcidade" id="idcidade">
        <c:forEach var="cidade" items="${cidades}">                        
            <option value="${cidade.idCidade}" ${pessoa.cidade.idCidade == cidade.idCidade ? 'selected' : ''} >${cidade.nomeCidade}</option>                               
        </c:forEach>
    </select>

    <br></br>
    <input type="submit" value="Cadastrar" name="cadastrar">
    <input type="reset" value="Limpar" name="Limpar ">
</form>
<br></br>
<div align="center">
    <a href="ListarAdministrador">Voltar</a>
</div>
</body>
</html>

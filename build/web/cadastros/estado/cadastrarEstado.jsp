<%-- 
    Document   : cadastrarEstado
    Created on : 30/05/2021, 22:04:20
    Author     : fbrcmmelo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Cadastro de Estados</title>
    
    <body>
    <tr>
        <p>Cadastro de Estado</p>
    <hr>
    </tr>
    <form name="cadastrarEstado" action="${pageContext.request.contextPath}/CadastrarEstado" method="POST">
        <p>ID:</p>
        <label><input type="number" id="idestado" value="${estado.idEstado}" name="idestado" readonly="true"/></label>
        <p>Nome:</p>
        <label><input type="text"id="nomeestado" value="${estado.nomeEstado}" required="true" name="nomeestado" maxlength="100"/></label>
        <p>Sigla:</p>
        <label><input type="text" id="siglaestado" value="${estado.siglaEstado}" required="true" name="siglaestado" maxlength="2"/></label>
        <br></br>
        <input type="submit" value="Cadastrar" name="cadastrar">
        <input type="reset" value="Limpar" name="Limpar ">
    </form>
         <br></br>
           <div align="center">
            <a href="ListarEstado">Voltar</a>
        </div>
</body>
</html>
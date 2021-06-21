<%-- 
    Document   : cadastrarCidade
    Created on : 30/05/2021, 22:04:05
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Cadastro de Cidades</title>

    <body>
    <tr>
    <p>Cadastro de Cidades</p>
    <hr>
</tr>
<form name="cadastrarCidade" action="${pageContext.request.contextPath}/CadastrarCidade" method="POST">
    <p>ID:</p>
    <label><input type="number" id="idcidade" value="${cidade.idCidade}" name="idcidade" readonly="true"/></label>
    <p>Nome:</p>
    <label><input type="text"id="nomecidade" value="${cidade.nomeCidade}" required="true" name="nomecidade" maxlength="100"/></label>
    <p>Estado:</p>
    <select name="idestado" id="idestado">
        <c:forEach var="estado" items="${estados}">                        
            <option value="${estado.idEstado}" ${cidade.estado.idEstado == estado.idEstado ? 'selected' : ''} >${estado.nomeEstado}</option>                               
        </c:forEach>
    </select>

    <br></br>
    <input type="submit" value="Cadastrar" name="cadastrar">
    <input type="reset" value="Limpar" name="Limpar ">
</form>
     <br></br>
           <div align="center">
            <a href="ListarCidade">Voltar</a>
      
        </div>
</body>
</html>
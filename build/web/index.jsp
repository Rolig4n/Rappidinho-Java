<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rappdinho</title>
    </head>
    <body>
        <div id="login" align="center">
        <h1>Acesso ao Sistema</h1>
        
        <form name="logarpessoa" action="${pageContext.request.contextPath}/LogarPessoa" method="POST">
            
            <p><label for="emailpessoa">Email: </label><input type="email" name="emailpessoa" id="emailpessoa" required /></p>
            <p><label for="senhapessoa">Senha: </label><input type="password" name="senhapessoa" id="senhapessoa" required /></p>
            <input type="hidden" name="acao" value="logar">
            <p><input type="submit" name="logar" id="logar" value="Acessar" /></p>            
        </form>
        </div>
        <div id="error" align="center">
        ${erro}    
        </div>
        <div id ="cadastrar" align="center">
            <p>Não tem conta ? <a href="Cadastrar" role="button">Cadastrar-se</a></p>
        </div>
        
            
                
    </body>
</html>
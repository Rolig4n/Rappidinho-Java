<%-- 
    Document   : preCadastro
    Created on : 19/06/2021, 17:27:40
    Author     : fbrcmmelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo de Conta</title>
    </head>
    <body>
    <center>
        <h1>Deseja se Cadastrar como :</h1>
        <h3><a href="${pageContext.request.contextPath}/DadosContratante">Contratante</a>
            <p>Permite o Usuário solicitar entregas de seus produtos à outros usuários do sistema.</p></h3>
        <h3><a href="${pageContext.request.contextPath}/DadosContratado">Contratado</a>
            <p>Permite o Usuário realizar entregas e solicitar pedidos à outros usuários no sistema.</p></h3>
        <p>Observação: Neste tipo de conta, é necessário que o usuário tenha um veículo particular
            e tenha a Habilitação de Motorista (CNH) habilitada para tal serviço.</p>
        <p>Termos de Uso e Política de Privacidade <a href="">Ler, Clique Aqui</a></p>
    </center>
    </body>
</html>

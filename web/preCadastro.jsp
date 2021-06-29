<%-- 
    Document   : preCadastro
    Created on : 19/06/2021, 17:27:40
    Author     : fbrcmmelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="head.jsp"></c:import>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Tipo de Conta</title>
        </head>
        <body>
            <!--Loader-->
            <div class="preloader">
                <div class="lds-ripple">
                    <div class="lds-pos"></div>
                    <div class="lds-pos"></div>
                </div>
            </div>

            <div class="error-box" id="login" align="center">
                <img src="${pageContext.request.contextPath}/plugins/images/Rappdinho A.png" width="380" alt="logo" />
            <div class="row justify-content-center card-body">
                <h1 class="text-danger">Login</h1>
                <h1>Deseja se Cadastrar como :</h1>
                <h3><a href="${pageContext.request.contextPath}/DadosContratante">Contratante</a>
                    <p>Permite o Usuário solicitar entregas de seus produtos à outros usuários do sistema.</p></h3>
                <h3><a href="${pageContext.request.contextPath}/DadosContratado">Contratado</a>
                    <p>Permite o Usuário realizar entregas e solicitar pedidos à outros usuários no sistema.</p></h3>
                <p>Observação: Neste tipo de conta, é necessário que o usuário tenha um veículo particular
                    e tenha a Habilitação de Motorista (CNH) habilitada para tal serviço.</p>
                <p>Termos de Uso e Política de Privacidade <a href="#">Ler, Clique Aqui</a></p>
            </div>
        </div>

        <!--Import dos scripts-->
        <c:import url="scripts.jsp"></c:import>
    </body>
</html>

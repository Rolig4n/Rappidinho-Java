<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="head.jsp"></c:import>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Rappidinho Delivery</title>
        </head>
        <body>
            <!--Loader-->
            <div class="preloader">
                <div class="lds-ripple">
                    <div class="lds-pos"></div>
                    <div class="lds-pos"></div>
                </div>
            </div>

            <div class="card white-box" id="login" align="center">
                <div id="error" align="center">
                ${mensagem}
                <img src="${pageContext.request.contextPath}/plugins/images/Rappdinho A.png" width="380" alt="logo" />
            </div>
            <div class="row justify-content-center card-body">
                <h1 class="text-danger">Login</h1>
                <form class="col-8 form-horizontal form-material" name="logarpessoa" action="${pageContext.request.contextPath}/LogarPessoa" method="POST">
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="emailpessoa">Email</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="email" name="emailpessoa" id="emailpessoa" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="senhapessoa">Senha</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="password" name="senhapessoa" id="senhapessoa" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <input type="hidden" name="acao" value="logar">
                    <p><input type="submit" name="logar" id="logar" value="Acessar" class="btn btn-danger text-white"/></p>            
                </form>
                <div id ="cadastrar" align="center">
                    <p>
                        Não tem conta ? Cadastrar-se como <br><a href="${pageContext.request.contextPath}/DadosContratante" role="button">Contratante</a>
                        ou <a href="${pageContext.request.contextPath}/DadosContratado" role="button">Entregador</a> agora!
                    </p>
                </div>
            </div>
        </div>

        <!--Import dos scripts-->
        <c:import url="scripts.jsp"></c:import>
    </body>
</html>
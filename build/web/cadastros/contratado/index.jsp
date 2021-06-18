<%-- 
    Document   : index
    Created on : 17/06/2021, 19:37:15
    Author     : fbrcmmelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<c:choose>
    <c:when test="${pessoa.tipoPessoa eq 'M'}">
         <c:import url="/cabecalho.jsp"></c:import>
            <title>Rappidinho</title>

            <body>
                <!--Loader-->
                <div class="preloader">
                    <div class="lds-ripple">
                        <div class="lds-pos"></div>
                        <div class="lds-pos"></div>
                    </div>
                </div>

                <!--Corpo da pagina-->
                <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
                     data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

                    <!--Cabeçalho-->
               

                    <!--Menu-->
                <c:import url="/menu.jsp"></c:import>

                    <!--Conteudo-->

                    <div class="page-wrapper">
                        <!--taca os bag aqui dentro-->
                        <h3>${saudacao}</h3>
                    <br />
                    <span><a href="${pageContext.request.contextPath}/LogarPessoa?acao=logout">Sair</a></span>
                    <!--Rodape-->
                    <c:import url="/footer.jsp"></c:import>
                    </div>
                </div>

         
        </c:when>
        <c:otherwise>
            <c:redirect url="../index.jsp"></c:redirect>
        </c:otherwise>
    </c:choose>
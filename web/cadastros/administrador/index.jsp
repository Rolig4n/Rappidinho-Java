<%-- 
    Document   : index
    Created on : 17/06/2021, 19:35:54
    Author     : fbrcmmelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<c:choose>
    <c:when test="${pessoa.tipoPessoa eq 'A'}">
        <html>
            <head>
                <c:import url="../head.jsp"></c:import>
                    <title>Rappidinho</title>
                </head>
                <body>

                    <!--Corpo da pagina-->
                    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
                         data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

                        <!--Cabeçalho-->
                    <c:import url="cabecalho.jsp"></c:import>

                        <!--Menu-->
                    <c:import url="menu.jsp"></c:import>

                        <!--Conteudo-->

                        <div class="page-wrapper">
                            <!--taca os bag aqui dentro-->
                            <h3>${saudacao}</h3>
                        <br />
                        <span><a href="${pageContext.request.contextPath}/LogarPessoa?acao=logout">Sair</a></span>
                        <!--Rodape-->
                        <c:import url="footer.jsp"></c:import>
                        </div>
                    </div>

                    <!--Import dos scripts-->
                <c:import url="scripts.jsp"></c:import>

                </body>
            </html>
    </c:when>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
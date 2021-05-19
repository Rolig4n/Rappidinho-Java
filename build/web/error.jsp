<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="head.jsp"></c:import>
            <title>404</title>
        </head>

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

                <!--CabeÃ§alho-->
            <c:import url="cabecalho.jsp"></c:import>

                <!--Menu-->
            <c:import url="menu.jsp"></c:import>

                <!--Conteudo-->
                <div class="page-wrapper">
                    <div class="text-center">
                        <h1 class="text-danger">erro n#</h1>
                        <h3 class="text-uppercase">descrição erro</h3>
                    </div>
                </div>
            </div>

            <!--Import dos scripts-->
        <c:import url="scripts.jsp"></c:import>

    </body>
</html>
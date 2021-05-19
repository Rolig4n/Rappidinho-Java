<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="head.jsp"></c:import>
            <title>Index</title>
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

                <!--Cabeçalho-->
            <c:import url="cabecalho.jsp"></c:import>

                <!--Menu-->
            <c:import url="menu.jsp"></c:import>

                <!--Conteudo-->
                <div class="page-wrapper">
                    <!--taca os bag aqui dentro-->

                    <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-10 col-sm-12">
                            <div class="white-box">
                                <div class="d-md-flex mb-3">
                                    <h3 class="box-title mb-0">Entregas feitas recentemente <a href="novaEntrega" class="btn btn-danger text-white">
                                            <i class="fa fa-plus" aria-hidden="true"></i> Entrega
                                        </a>
                                    </h3>
                                </div>
                                <div class="table-responsive">
                                    <table class="table no-wrap">
                                        <thead>
                                            <tr>
                                                <th class="border-top-0">#</th>
                                                <th class="border-top-0">Entregador</th>
                                                <th class="border-top-0">Data</th>
                                                <th class="border-top-0">Valor</th>
                                                <th class="border-top-0">Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="nome-variavel" items="${null}">
                                            <tr>
                                                <td>${null} <!-- id entrega--></td>
                                                <td>${null} <!-- entregador--></td>
                                                <td>${null} <!-- data entrega--></td>
                                                <td>${null} <!-- valor entrega--></td>
                                                <td><span class="${(null==1)? "text-success" : "text-danger"}">${null} <!-- status entrega--></span></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <!--Rodape-->
                <c:import url="footer.jsp"></c:import>
                </div>
            </div>

            <!--Import dos scripts-->
        <c:import url="scripts.jsp"></c:import>

    </body>
</html>
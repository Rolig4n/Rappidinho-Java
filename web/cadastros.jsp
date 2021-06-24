<%-- 
    Document   : cadastros
    Created on : 30/05/2021, 22:36:50
    Author     : fbrcmmelo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="/head.jsp"></c:import>
            <title>Cadastros</title>
        </head>

        <body>

            <!--Corpo da pagina-->
            <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
                 data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

                <!--CabeÃ§alho-->
            <c:import url="/cabecalho.jsp"></c:import>

                <!--Menu-->
            <c:import url="/menu.jsp"></c:import>

                <!--Conteudo-->
                <div class="page-wrapper">
                    <!--taca os bag aqui dentro-->

                    <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-10 col-sm-12">
                            <div class="white-box">
                                <div class="d-md-flex mb-3">
                                    <h3 class="box-title mb-0">Cadastros
                                    </h3>
                                </div>
                                <div class="table-responsive">
                                    <table class="table no-wrap">
                                        <thead>

                                            <tr>
                                                <th class="border-top-0"><h3 class="box-title mb-0">Estados</h3></th>
                                                <th class="border-top-0"><a href="${pageContext.request.contextPath}/ListarEstado" class="btn btn-danger text-white">
                                                    <i class="fa fa-plus" aria-hidden="true"></i> Estado
                                                </a></th>
                                        </tr>
                                        <tr>
                                            <th class="border-top-0"><h3 class="box-title mb-0">Cidades</h3></th>
                                            <th class="border-top-0"><a href="${pageContext.request.contextPath}/ListarCidade" class="btn btn-danger text-white">
                                                    <i class="fa fa-plus" aria-hidden="true"></i> Cidade
                                                </a></th>
                                        </tr>
                                        <tr>
                                            <th class="border-top-0"><h3 class="box-title mb-0">Administradores</h3></th>
                                            <th class="border-top-0"><a href="${pageContext.request.contextPath}/ListarAdministrador" class="btn btn-danger text-white">
                                                    <i class="fa fa-plus" aria-hidden="true"></i> Administrador
                                                </a></th>
                                        </tr>
                                        <tr>
                                            <th class="border-top-0"><h3 class="box-title mb-0">Contratantes</h3></th>
                                            <th class="border-top-0"><a href="${pageContext.request.contextPath}/ListarContratante" class="btn btn-danger text-white">
                                                    <i class="fa fa-plus" aria-hidden="true"></i> Contratante
                                                </a></th>
                                        </tr>
                                        <tr>
                                            <th class="border-top-0"><h3 class="box-title mb-0">Contratados</h3></th>
                                            <th class="border-top-0"><a href="${pageContext.request.contextPath}/ListarContratado" class="btn btn-danger text-white">
                                                    <i class="fa fa-plus" aria-hidden="true"></i> Contratado
                                                </a></th>
                                        </tr>
                                        <tr>
                                            <th class="border-top-0"><h3 class="box-title mb-0">Entregas</h3></th>
                                            <th class="border-top-0"><a href="${pageContext.request.contextPath}/ListarEntrega" class="btn btn-danger text-white">
                                                    <i class="fa fa-plus" aria-hidden="true"></i> Entrega
                                                </a></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <!--Rodape-->
                <c:import url="/footer.jsp"></c:import>
            </div>
        </div>
    </body>
</html>

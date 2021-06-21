<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="/cabecalho.jsp"></c:import>
            <title>Painel de controle</title>
            <style type="text/css">
                /* Always set the map height explicitly to define the size of the div
                 * element that contains the map. */
                #map {
                    height: 100%;
                }
            </style>
            <script src="map.js" type="text/javascript"></script>
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

                <!--Cabecalho-->


                <!--Menu-->
            <c:import url="/menu.jsp"></c:import>

                <!--Conteudo-->
                <div class="page-wrapper">

                    <div class="row justify-content-center">
                        <!-- Mapa -->
                        <div class="col-10">
                            <div class="white-box">
                                <h3>Mapa local</h3>
                                <div id="map"></div>
                            </div>
                        </div>
                        <!-- Fim Mapa -->
                    </div>

                    <!--Widgets-->
                    <div class="row justify-content-center">
                        <!--Entregas Recentes-->
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

                    <!--Contato do pedido-->
                    <div class="col-md-10 col-lg-10 col-sm-12">
                        <div class="card white-box p-0">
                            <div class="card-body">
                                <h3 class="box-title mb-0">Ultimas Conversas</h3>
                            </div>
                            <div class="comment-widgets">
                                <!--Conversas por linha-->
                                <c:forEach var="nome-variavel" items="${null}">
                                    <div class="d-flex flex-row comment-row p-3 mt-0">
                                        <div class="p-2"><img src="${null}" alt="imagem usuario" width="50" class="rounded-circle"></div>
                                        <div class="comment-text ps-2 ps-md-3 w-100">
                                            <h5 class="font-medium">${null} <!--Nome entregador/contratante--></h5>
                                            <span class="mb-3 d-block">${null} <!--Mensagem--></span>
                                            <div class="comment-footer d-md-flex align-items-center">
                                                <span class="badge bg-primary rounded">${null} <!--Estatus pedido--></span>
                                                <div class="text-muted fs-2 ms-auto mt-2 mt-md-0">${null} <!--Data--></div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

                <!--Rodape-->
                <c:import url="/footer.jsp"></c:import>
                </div>
            <!--Script Mapa-->
            <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
            <script async
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBlMjViBMx8ncT__yCeclp42-_r8seA1RI&callback=initMap&libraries=&v=weekly">
            </script>
    </body>
</html>
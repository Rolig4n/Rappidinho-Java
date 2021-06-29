<%-- 
    Document   : cadastrarEntrega
    Created on : 13/06/2021, 13:31:48
    Author     : fbrcmmelo
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="/head.jsp"></c:import>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Cadastro de Entrega</title>

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
                    <div class="row justify-content-center">
                        <!-- Column -->
                        <div class="col-xlg-4 col-lg-10 col-md-10">
                            <div class="white-box text-center">
                                <h1>Cadastro de Entrega</h1>
                            </div>
                        </div>

                        <div class="col-xlg-6 col-lg-10 col-md-10">
                            <div class="card">
                                <div class="row justify-content-center card-body">
                                    <form class="col-10 row form-horizontal form-material" name="cadastrarEntrega" action="${pageContext.request.contextPath}/CadastrarEntrega" method="POST">
                                    <div class="form-group col-md-2 col-sm-12">
                                        <label class="col-12 p-0">ID</label>
                                        <div class="col-12 border-bottom p-0">
                                            <input type="number" id="identrega" value="${entrega.idEntrega}" name="identrega" placeholder="ID" readonly="true" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-5 col-sm-12">
                                        <label class="col-12 p-0">Data</label>
                                        <div class="col-12 border-bottom p-0">
                                            <input type="text" name="dataentrega" id="dataentrega" value="<fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${dataentrega}"></fmt:formatDate>" placeholder="dd/mm/aaaa" class="form-control p-0 border-0">
                                            </div>
                                        </div>
                                        <div class="form-group col-md-5 col-sm-12">
                                            <label class="col-md-12 p-0">Status</label>
                                            <div class="col-md-12 border-bottom p-0">
                                                <input type="text" id="statusentrega" value="${entrega.statusEntrega}" name="statusentrega" placeholder="Status" readonly="true" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-md-12 p-0">Rota</label>
                                        <c:forEach var="pedido" items="${pedidos}">                        
                                            <div class="col-md-12 border-bottom p-0">
                                                <input type="text" id="nomerota" value="${pedido.rota.nomeRota}" name="nomerota" placeholder="Rota" readonly="true" class="form-control p-0 border-0">
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-md-12 p-0">Pedido / Contrado</label>
                                        <div class="col-sm-12 border-bottom">
                                            <select class="form-select shadow-none p-0 border-0 form-control-line" name="idpedido" id="idpedido">
                                                <option value="">Selecione</option>
                                                <c:forEach var="pedido" items="${pedidos}">                        
                                                    <option value="${pedido.idPedido}" ${entrega.pedido.idPedido == pedido.idPedido ? 'selected' : ''}>${pedido.idPedido}<input type="number" id="idcontratado" value="${pedido.contratado.idContratado}" name="idcontratado" placeholder="ID Contratado" readonly="true"/></option>                               
                                                    <label><input class="form-control p-0 border-0" type="number" id="idcontratado" value="${pedido.contratado.idContratado}" name="idcontratado" placeholder="ID Contratado" readonly="true"/></label>
                                                    <label><input class="form-control p-0 border-0" type="text" id="nomepessoa" value="${pedido.pessoa.nomePessoa}" name="nomepessoa" placeholder="Pessoa" readonly="true"/></label>
                                                    </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-12 row">
                                        <div class="col-md-6 col-sm-12">
                                            <input class="btn btn-success text-white" type="submit" value="Cadastrar" name="cadastrar">
                                        </div>
                                        <div class="col-md-6 col-sm-12">
                                            <input class="btn btn-danger text-white" type="reset" value="Limpar" name="Limpar">
                                        </div>

                                    </div>
                                </form>
                                <div class="col-md-6 col-sm-12">
                                    <a href="ListarAdministrador">Voltar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                    
            </div>
            <c:import url="/footer.jsp"></c:import>
            </div>

            <!--Import dos scripts-->
        <c:import url="/scripts.jsp"></c:import>
    </body>
</html>
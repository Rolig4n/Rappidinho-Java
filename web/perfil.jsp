<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
         <c:import url="/head.jsp"></c:import>
        <title>Perfil - ${null}</title>
    </head>
    <body>
        <!--Corpo da pagina-->
        <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
             data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

            <!--Cabeçalho-->
            <c:import url="/cabecalho.jsp"></c:import>

                <!--Menu-->
            <c:import url="/menu.jsp"></c:import>

                <!--Conteudo-->
                <div class="page-wrapper">

                    <!-- Row -->
                    <div class="row justify-content-center">
                        <!-- Column -->
                        <div class="col-xlg-4 col-lg-10 col-md-10">
                            <div class="white-box">
                                <div class="row justify-content-center overlay-box">
                                    <div class="col-8 user-content">
                                        <!-- src="caminho do banco" -->
                                        <img src="plugins/images/users/genu.jpg${null}" class="thumb-lg img-circle" alt="img">
                                    <h4 class="text-black mt-2">User Name ${null}</h4>
                                    <h5 class="text-black mt-2">User E-mail ${null}</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <!-- Column -->
                    <div class="col-xlg-6 col-lg-10 col-md-10">
                        <div class="card">
                            <div class="row justify-content-center card-body">
                                <form class="col-10 row form-horizontal form-material" action="atualizarPerfil" name="atualizarPerfil" method="POST">
                                    <div class="form-group col-md-10">
                                        <label class="col-md-12 p-0">Nome completo</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="nomepessoa" value="${administrador.nomePessoa}" required="true" placeholder="Nome" name="nomepessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-8">
                                        <label for="example-email" class="col-md-12 p-0">E-mail</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="emailpessoa" value="${administrador.emailPessoa}" required="true" placeholder="Email" name="emailpessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="col-md-12 p-0">Senha</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="password" id="senhapessoa" value="${administrador.senhaPessoa}" required="true" placeholder="Senha" name="senhapessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-md-12 p-0">Telefone</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="telefonepessoa" value="${administrador.telefonePessoa}" required="true" placeholder="(xx)99xxx-xxxx" name="telefonepessoa" maxlength="14" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="col-md-12 p-0">Endere�o</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="enderecopessoa" value="${administrador.enderecoPessoa}" required="true" placeholder="Rua exemplo, 0000, bairro" name="enderecopessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-md-12 p-0">Descri��o do perfil</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <textarea rows="2" class="form-control p-0 border-1">${null}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-sm-12">Tipo Perfil</label>
                                        <div class="col-sm-12 border-bottom">
                                            <select class="form-select shadow-none p-0 border-0 form-control-line">
                                                <option selected="${null}">Entregador</option>
                                                <option selected="${null}">Contratante</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Mostrar campo veiculos caso entregador -->
                                    <c:choose>
                                        <c:when test="${null.equals(entregador)}">
                                            <div class="form-group col-12">
                                                <label class="col-sm-12">Veiculo</label>
                                                <div class="col-sm-12 border-bottom">
                                                    <select class="form-select shadow-none p-0 border-0 form-control-line">
                                                        <c:forEach var="nome-variavel" items="${null}">
                                                            <option selected="${null}">${null}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <div class="form-group col-12">
                                        <div class="col-sm-12">
                                            <button class="btn btn-success">Atualizar perfil</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                </div>
                <!-- Row -->

            </div>
        </div>

        <!--Import dos scripts-->
        <c:import url="/footer.jsp"></c:import>

    </body>
</html>
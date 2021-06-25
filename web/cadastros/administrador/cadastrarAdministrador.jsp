<%-- 
   Document   : cadastrarAdministrador
   Created on : 30/05/2021, 20:41:17
   Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <c:import url="../../head.jsp"></c:import>
            <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
            <title>Rappidinho - Cadastro de Admin's</title>
        </head>
        <body>
            <!--Corpo da pagina-->
            <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
                 data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

                <!--CabeÃ§alho-->
            <c:import url="../../cabecalho.jsp"></c:import>

                <!--Menu-->
            <c:import url="../../menu.jsp"></c:import>

                <!--Conteudo-->
                <div class="page-wrapper">
                    <div class="row justify-content-center">
                        <!-- Column -->
                        <div class="col-xlg-4 col-lg-10 col-md-10">
                            <div class="white-box text-center">
                                <h1>Cadastro de Administrador</h1>
                            </div>
                        </div>

                        <div class="col-xlg-6 col-lg-10 col-md-10">
                            <div class="card">
                                <div class="row justify-content-center card-body">
                                    <form class="col-10 row form-horizontal form-material" name="cadastrarAdminstrador" action="${pageContext.request.contextPath}/CadastrarAdministrador" method="POST">
                                    <div class="form-group col-md-2 col-sm-12">
                                        <label class="col-12 p-0">ID</label>
                                        <div class="col-12 border-bottom p-0">
                                            <input type="number" id="idpessoa" value="${administrador.idPessoa}" name="idpessoa" placeholder="ID" readonly="true" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-10 col-sm-12">
                                        <label class="col-12 p-0">Nome completo</label>
                                        <div class="col-12 border-bottom p-0">
                                            <input type="text" id="nomepessoa" value="${administrador.nomePessoa}" required="true" placeholder="Nome" name="nomepessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 col-sm-12">
                                        <label class="col-md-12 p-0">Email</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="emailpessoa" value="${administrador.emailPessoa}" required="true" placeholder="Email" name="emailpessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 col-sm-12">
                                        <label class="col-md-12 p-0">Senha</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="password" id="senhapessoa" value="${administrador.senhaPessoa}" required="true" placeholder="Senha" name="senhapessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 col-sm-12">
                                        <label class="col-md-12 p-0">CPF</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="cpfpessoa" value="${administrador.cpfPessoa}" required="true" placeholder="CPF" name="cpfpessoa" maxlength="14" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 col-sm-12">
                                        <label class="col-md-12 p-0">Rg</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="rgadministrador" value="${administrador.rgAdministrador}" required="true" placeholder="RG" name="rgadministrador" maxlength="12" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 col-sm-12">
                                        <label class="col-md-12 p-0">Telefone</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="telefonepessoa" value="${administrador.telefonePessoa}" required="true" placeholder="(xx)99xxx-xxxx" name="telefonepessoa" maxlength="14" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-md-12 p-0">Endereço</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input type="text" id="enderecopessoa" value="${administrador.enderecoPessoa}" required="true" placeholder="Rua exemplo, 0000, bairro" name="enderecopessoa" maxlength="100" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-md-12 p-0">Cidade</label>
                                        <div class="col-sm-12 border-bottom">
                                            <select class="form-select shadow-none p-0 border-0 form-control-line" name="idcidade" id="idcidade">
                                                <option value="">Selecione</option>
                                                <c:forEach var="cidade" items="${cidades}">                        
                                                    <option value="${cidade.idCidade}" ${pessoa.cidade.idCidade == cidade.idCidade ? 'selected' : ''} >${cidade.nomeCidade}</option>                               
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-12 row">
                                        <div class="col-md-6 col-sm-12">
                                            <input class="btn btn-success text-white" type="submit" value="Cadastrar" name="cadastrar">
                                        </div>
                                        <div class="col-md-6 col-sm-12">
                                            <input class="btn btn-danger text-white" type="reset" value="Limpar" name="Limpar ">
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
        </div>

        <!--Import dos scripts-->
        <c:import url="../../scripts.jsp"></c:import>
    </body>
</html>

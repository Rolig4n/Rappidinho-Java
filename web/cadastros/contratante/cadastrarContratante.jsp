<%-- 
    Document   : cadastrarContratante
    Created on : 13/06/2021, 13:27:01
    Author     : fbrcmmelo
--%>

<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <c:import url="/head.jsp"></c:import>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Cadastro de Contratante</title><script type="text/javascript">

                function isImg(file) {
                    var img = file;
                    img.src = "${pageContext.request.contextPath}/plugins/images/avatar.png";
                }

        </script>
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
                <h1 class="text-danger">Cadastrar Contratante</h1>
                <form class="col-8 form-horizontal form-material" name="cadastrarContratante" action="${pageContext.request.contextPath}/CadastrarContratante" method="POST" enctype="multipart/form-data">
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="idpessoa">ID</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="number" id="idpessoa" value="${contratante.idPessoa}" name="idpessoa" placeholder="ID" readonly="true" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <img src="${pageContext.request.contextPath}/plugins/images/genu.jpg" alt="Avatar" width="100" height="100" ${contratante.fotoContratante != null ? 'hidden' : ''} />
                        <img src="${pageContext.request.contextPath}/MostrarFotoContratante?idpessoa=${contratante.idPessoa}" width="150" heigth="150" id="fotocontratante" alt="Foto Contratante" ${contratante.fotoContratante == null ? 'hidden' : ''} onerror="isImg(this);" />
                        <label class="col-md-12 p-0" for="fotocontratante">Foto</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="file" name="fotocontratante" id="fotocontratante" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="nomepessoa">Nome</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="text" id="nomepessoa" value="${contratante.nomePessoa}" required="true" placeholder="Nome" name="nomepessoa" maxlength="100" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="emailpessoa">Email</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="text" id="emailpessoa" value="${contratante.emailPessoa}" required="true" placeholder="Email" name="emailpessoa" maxlength="100" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="senhapessoa">Senha</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="password" id="senhapessoa" value="${contratante.senhaPessoa}" required="true" placeholder="Senha" name="senhapessoa" maxlength="100" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="cpfpessoa">CPF</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="text" id="cpfpessoa" value="${contratante.cpfPessoa}" required="true" placeholder="CPF" name="cpfpessoa" maxlength="14" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="enderecopessoa">Endereço</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="text" id="enderecopessoa" value="${contratante.enderecoPessoa}" required="true" placeholder="Rua .., numero .." name="enderecopessoa" maxlength="100" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="telefonepessoa">Telefone</label>
                        <div class="col-md-6 border-bottom p-0">
                            <input type="text" id="telefonepessoa" value="${contratante.telefonePessoa}" required="true" placeholder="(xx)99xxx-xxxx" name="telefonepessoa" maxlength="14" class="form-control p-0 border-0" required />
                        </div>
                    </div>
                    <div class="form-group mb-4">
                        <label class="col-md-12 p-0" for="idcidade">Cidade</label>
                        <div class="col-md-6 border-bottom p-0">
                            <select class="form-select shadow-none p-0 border-0 form-control-line" name="idcidade" id="idcidade">
                                <c:forEach var="cidade" items="${cidades}">                        
                                    <option value="${cidade.idCidade}" ${pessoa.cidade.idCidade == cidade.idCidade ? 'selected' : ''} >${cidade.nomeCidade}</option>                               
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <input type="hidden" name="acao" value="logar">
                    <p>
                        <input type="submit" value="Cadastrar" name="cadastrar" class="btn btn-danger text-white"/>
                        <input type="reset" value="Limpar" name="Limpar" class="btn btn-danger text-white"/>
                    </p>            
                </form>
            </div>
        </div>

        <!--Import dos scripts-->
        <c:import url="/scripts.jsp"></c:import>
    </body>
</html>

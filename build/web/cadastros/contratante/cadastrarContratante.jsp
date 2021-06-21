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
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Contratante</title><script type="text/javascript">

            function isImg(file) {
                var img = file;
                img.src = "${pageContext.request.contextPath}/plugins/images/avatar.png";
            }

        </script>
    </head>
    <body>
    <tr>
    <p>Cadastro de Contratantes</p>
    <hr>
</tr>
<form name="cadastrarContratante" action="${pageContext.request.contextPath}/CadastrarContratante" method="POST" enctype="multipart/form-data">
    <p>ID:</p>
    <label><input type="number" id="idpessoa" value="${contratante.idPessoa}" name="idpessoa" placeholder="ID" readonly="true"/></label>
    <br></br>
    <img src="${pageContext.request.contextPath}/plugins/images/avatar.png" alt="Avatar" width="100" height="100" ${contratante.fotoContratante != null ? 'hidden' : ''} /> <img src="${pageContext.request.contextPath}/MostrarFotoContratante?idpessoa=${contratante.idPessoa}" width="150" heigth="150" id="fotocontratante" alt="Foto Contratante" ${contratante.fotoContratante == null ? 'hidden' : ''} onerror="isImg(this);" /> <br />
    <label for="fotocontratante">Foto: </label>
    <input type="file" name="fotocontratante" id="fotocontratante" /> <br></br>
    <p>Nome:</p>
    <label><input type="text" id="nomepessoa" value="${contratante.nomePessoa}" required="true" placeholder="Nome" name="nomepessoa" maxlength="100"/></label>
    <p>Email:</p>
    <label><input type="text" id="emailpessoa" value="${contratante.emailPessoa}" required="true" placeholder="Email" name="emailpessoa" maxlength="100"/></label>
    <p>Senha:</p>
    <label><input type="password" id="senhapessoa" value="${contratante.senhaPessoa}" required="true" placeholder="Senha" name="senhapessoa" maxlength="100"/></label>
    <p>CPF:</p>
    <label><input type="text" id="cpfpessoa" value="${contratante.cpfPessoa}" required="true" placeholder="CPF" name="cpfpessoa" maxlength="14"/></label>
    <p>Endereço:</p>
    <label><input type="text" id="enderecopessoa" value="${contratante.enderecoPessoa}" required="true" placeholder="Rua .., numero .." name="enderecopessoa" maxlength="100"/></label>
    <p>Telefone:</p>
    <label><input type="text" id="telefonepessoa" value="${contratante.telefonePessoa}" required="true" placeholder="(xx)99xxx-xxxx" name="telefonepessoa" maxlength="14"/></label>
    <p>Cidade:</p>
    <select name="idcidade" id="idcidade">
        <c:forEach var="cidade" items="${cidades}">                        
            <option value="${cidade.idCidade}" ${pessoa.cidade.idCidade == cidade.idCidade ? 'selected' : ''} >${cidade.nomeCidade}</option>                               
        </c:forEach>
    </select>

    <br></br>
    <input type="submit" value="Cadastrar" name="cadastrar">
    <input type="reset" value="Limpar" name="Limpar ">
</form>
<br></br>
<div align="center">
    <a href="ListarContratante">Voltar</a>

</div>
</body>
</html>

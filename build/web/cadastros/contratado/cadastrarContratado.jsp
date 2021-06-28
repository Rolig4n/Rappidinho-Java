<%-- 
    Document   : cadastrarContratado
    Created on : 13/06/2021, 13:28:26
    Author     : fbrcmmelo
--%>

<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Contratados</title><script type="text/javascript">

            function isImg(file) {
                var img = file;                
                img.src = "${pageContext.request.contextPath}/plugins/images/avatar.png";
            }

        </script>
    </head>
    <body>
    <tr>
    <p>Cadastro de Contratados</p>
    <hr>
</tr>
<form name="cadastrarContratado" action="${pageContext.request.contextPath}/CadastrarContratado" method="POST" enctype="multipart/form-data">
    <p>ID Pessoa:</p>
    <label><input type="number" id="idpessoa" value="${contratado.idPessoa}" name="idpessoa" placeholder="ID" readonly="true"/></label>
    <br></br>
    <img src="${pageContext.request.contextPath}/plugins/images/avatar.png" alt="Avatar" width="100" height="100" ${contratado.fotoContratado != null ? 'hidden' : ''} /> <img src="${pageContext.request.contextPath}/MostrarFotoContratado?idpessoa=${contratado.idPessoa}" width="150" heigth="150" id="fotocontratado" alt="Foto Contratado" ${contratado.fotoContratado == null ? 'hidden' : ''} onerror="isImg(this);" /> <br />
    <label for="fotocontratado">Foto: </label>
    <input type="file" name="fotocontratado" id="fotocontratado" /> <br></br>
    <p>Nome:</p>
    <label><input type="text" id="nomepessoa" value="${contratado.nomePessoa}" required="true" placeholder="Nome" name="nomepessoa" maxlength="100"/></label>
    <p>Email:</p>
    <label><input type="text" id="emailpessoa" value="${contratado.emailPessoa}" required="true" placeholder="Email" name="emailpessoa" maxlength="100"/></label>
    <p>Senha:</p>
    <label><input type="password" id="senhapessoa" value="${contratado.senhaPessoa}" required="true" placeholder="Senha" name="senhapessoa" maxlength="100"/></label>
    <p>CPF:</p>
    <label><input type="text" id="cpfpessoa" value="${contratado.cpfPessoa}" required="true" placeholder="CPF" name="cpfpessoa" maxlength="14"/></label>
    <p>CNH:</p>
    <label><input type="text" id="cnhcontratado" value="${contratado.cnhContratado}" required="true" placeholder="CNH" name="cnhcontratado" maxlength="11"/></label>
    <p>Endereço:</p>
    <label><input type="text" id="enderecopessoa" value="${contratado.enderecoPessoa}" required="true" placeholder="Rua .., numero .." name="enderecopessoa" maxlength="100"/></label>
    <p>Telefone:</p>
    <label><input type="text" id="telefonepessoa" value="${contratado.telefonePessoa}" required="true" placeholder="(xx)99xxx-xxxx" name="telefonepessoa" maxlength="14"/></label>
   <p>Cidade:</p>
    <select name="idcidade" id="idcidade">
        <c:forEach var="cidade" items="${cidades}">                        
            <option value="${cidade.idCidade}" ${pessoa.cidade.idCidade == cidade.idCidade ? 'selected' : ''} >${cidade.nomeCidade}</option>                               
        </c:forEach>
    </select>
    ${mensagem}
    <br></br>
    <input type="submit" value="Cadastrar" name="cadastrar">
    <input type="reset" value="Limpar" name="Limpar ">
</form>
</body>
</html>

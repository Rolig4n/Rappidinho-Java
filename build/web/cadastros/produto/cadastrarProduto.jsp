<%-- 
    Document   : cadastrarProduto
    Created on : 20/06/2021, 12:36:12
    Author     : fbrcmmelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Produtos</title><script type="text/javascript">

            function isImg(file) {
                var img = file;                
                img.src = "${pageContext.request.contextPath}/plugins/images/avatar.png";
            }

        </script>
    </head>
    <body>
    <tr>
    <p>Cadastro de Produtos</p>
    <hr>
</tr>
<form name="cadastrarProduto" action="${pageContext.request.contextPath}/CadastrarProduto" method="POST" enctype="multipart/form-data">
    <p>ID:</p>
    <label><input type="number" id="idproduto" value="${produto.idProduto}" name="idproduto" placeholder="ID" readonly="true"/></label>
    <br></br>
    <img src="${pageContext.request.contextPath}/plugins/images/avatar.png" alt="Avatar" width="100" height="100" ${produto.fotoProduto != null ? 'hidden' : ''} /> <img src="${pageContext.request.contextPath}/MostrarFotoProduto?idproduto=${produto.idProduto}" width="150" heigth="150" id="fotoproduto" alt="Foto Produto" ${produto.fotoProduto == null ? 'hidden' : ''} onerror="isImg(this);" /> <br />
    <label for="fotoproduto">Foto: </label>
    <input type="file" name="fotoproduto" id="fotoproduto" /> <br></br>
    <p>Nome:</p>
    <label><input type="text" id="nomeproduto" value="${produto.nomeProduto}" required="true" placeholder="Nome do Produto" name="nomeproduto" maxlength="100"/></label>
    <p>Descrição:</p>
    <label><input type="text" id="descricaoproduto" value="${produto.descricaoProduto}" required="true" placeholder="Descrição do Produto" name="descricaoproduto" maxlength="100"/></label>
    <p>Pessoa:</p>
    <label><input type="number" id="idpessoa" value="${contratado.idPessoa}" name="idpessoa" placeholder="ID" readonly="true"/></label>
    <br></br>
    <input type="submit" value="Cadastrar" name="cadastrar">
    <input type="reset" value="Limpar" name="Limpar ">
</form>
    <br></br>
<div align="center">
    <a href="${pageContext.request.contextPath}/ListarProduto">Voltar</a>
</div>
</body>
</html>

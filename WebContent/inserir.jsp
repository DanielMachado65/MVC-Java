<%-- 
    Document   : inserir.jsp
    Created on : 19/09/2018, 22:30:58
    Author     : blue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir JSP</title>
    </head>
    <body>
        <h1>Formulário de Cadastro</h1>
        <form action="CadastrarUsuarioServlet" method="POST">
           Nome: <input type="text" name="nome">
           Login: <input type="text" name="login"><br/>
           Senha: <input type="password" name="password"/><br/>
            <input type="submit" value="Salvar">
        </form>           
        
    </body>
</html>
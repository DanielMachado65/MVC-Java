<%--
    Document   : clientesNovo
    Created on : 20/09/2018, 22:31:16
    Author     : blue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String nome = (String) session.getAttribute("nome");

        if (nome == null) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
            rd.forward(request, response);
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
      <div class="container">
        <div class="row">
          <div class="col-md-12">

            <h1>Formulário de Cadastro de Cliente</h1>
            <form action="NovoClienteServlet" method="POST">
                Nome:   <input type="text" name="nome" value=""/><br/>
                CPF:    <input type="text" name="cpf" value=""/><br/>
                Email:  <input type="text" name="email" value=""/><br/>
                Data:   <input type="text" name="data" value=""/><br/>
                Rua:    <input type="text" name="rua" value=""/><br/>
                N°:     <input type="text" name="nr" value=""/><br/>
                CEP:    <input type="text" name="cep" value=""/><br/>
                Cidade: <input type="text" name="cidade" value=""/><br/>
                UF:     <input type="text" name="uf" value=""/><br/>
                <input type="submit" value="Salvar" class="btn btn-primary">
                <input type="button" value="Cancelar" class="btn btn-outline-secondary" onclick="window.open('ClientesServlet')">
            </form>

          </div>
        </div>
      </div>
        <style media="screen">

          form, h1 {
            width: 90%;
            margin: 0 auto;
          }

          input {
            width: 100%;
            padding: 5px 0px;
            border: none;
            box-shadow: 0px 0px 5px rgba( 0, 0, 0, .5);
            border-radius: 8px;
          }
        </style>
    </body>
</html>
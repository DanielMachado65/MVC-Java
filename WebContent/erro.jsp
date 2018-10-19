<%-- 
    Document   : erro.jsp
    Created on : 19/09/2018, 22:09:37
    Author     : blue
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ufpr.tads.web2.beans.Usuario"%>
<%@page import="com.ufpr.tads.web2.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nome = (String) session.getAttribute("nome");

    if (nome == null) {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp" + "?" + "msg=Usuário deve se autenticar para acessar o sistema.");
        request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");
        rd.forward(request, response);
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro JSP</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        </head>
    <body>
        <% String pag = (String)request.getAttribute("pag"); %>
        <% String mensagem = (String)request.getAttribute("msg"); %>
        <div class="container">
            <br>
            <br>
            <br>
            <br>
            <br>
          <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
              <div class="panel panel-danger">
                <div class="panel-heading">
                  <h3 class="text-center">
                  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                  <b><% out.println(mensagem); %></b>
                  </h3>
                </div>
                <div class="panel-body">
                  <p>A página que você está procurando pode ter sido removida, mudado de nome, ou está temporariamente indisponível. Tente o seguinte:</p>

                    <ul class="list-group">
                      <li class="list-group-item">Certifique-se de que o endereço do site exibido na barra de endereços do seu navegador está escrito e formatado corretamente.</li>
                      <li class="list-group-item">Esqueça que isso aconteceu, e vá para a <a href="/lostDreams/"><b>Página Inicial</b></a> :)</li>
                      <li class="list-group-item">            
                          <div class="footer">Em caso de problemas contactar o administrador:
                            <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
                            <jsp:getProperty name="configuracao" property="email" />
                          </div>
                      </li>
                      </ul>
                  </div>
                </div>
              </div>
            </div>
        </div>
    </body>
</html>
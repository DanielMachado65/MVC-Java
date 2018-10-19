<%--
    Document   : portal
    Created on : 16/09/2018, 16:14:53
    Author     : Leonardo
--%>
<%@page import="com.ufpr.tads.web2.dao.UsuarioDAO"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page import="com.ufpr.tads.web2.beans.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ufpr.tads.web2.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
	String nome = (String) session.getAttribute("nome");

	if (nome == null) {
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp" + "?" + "msg=Usuário deve se autenticar para acessar o sistema.");
		request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");
		rd.forward(request, response);
	}
	String msg = (String) request.getAttribute("msg");
	String alert = (String) request.getAttribute("alert");
	
	UsuarioDAO dao = new UsuarioDAO();
	List<Usuario> lista = new ArrayList<Usuario>();
	lista = dao.buscarTodos();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Poppins:400,700"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<title>Portal JSP</title>
</head>
<body>
	<%-- Validação da erro --%>
	<%
		if (msg != null) {
	%>
	<div class="alert alert-${alert}" role="alert">${msg}</div>
	<%
		}
	%>
	<%-- Portal --%>
	<section id="portal">
		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<ul class="nav nav-pills nav-fill">
						<li class="nav-item"><a class="nav-link" href="inserir.jsp">Cadastro
								de Clientes</a></li>
						<li class="nav-item"><a class="nav-link" href="LogoutServlet">Sair</a>
						</li>
						<li class="nav-item"><a class="nav-link disabled" href="#">
								Olá, <jsp:useBean id="loginbean"
									class="com.ufpr.tads.web2.beans.LoginBean" scope="application" />
								<jsp:getProperty name="loginbean" property="nome" />
						</a></li>
					</ul>

					<table>
						<thead>
							<tr>
								<th>Nome</th>
								<th>Login</th>
								<th>Senha</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Usuario usuario : lista) {
							%>
							<tr>
								<td><%=usuario.getNome()%></td>
								<td><%=usuario.getLogin()%></td>
								<td><%=usuario.getSenha()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<a href="inserir.jsp" class="btn btn-primary">Inserir</a> <a
						href='LogoutServlet' class="btn btn-primary">Logout</a>
					<footer>
						Em caso de problemas contactar o administrador:
						<jsp:useBean id="configuracao"
							class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
						<jsp:getProperty name="configuracao" property="email" />
					</footer>

				</div>
			</div>
		</div>
	</section>
</body>
</html>
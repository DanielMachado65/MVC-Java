<%-- 
    Document   : index
    Created on : 20/09/2018, 22:43:50
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
	String msg = (String) request.getAttribute("msg");
	String login = (String) session.getAttribute("nome");
	if(login!=null){
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp" + "?" + "msg=Usuário deve se autenticar para acessar o sistema.");
		request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");
		rd.forward(request, response);
	}
%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Poppins:400,700"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!-- Index Login -->
	<section id="index-login">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="box">

						<!-- Title -->
						<h1 class="title">Login</h1>

						<!-- Form -->
						<form action="LoginServlet" method="POST">
							<input type="text" name="login" value="" placeholder="Login" />
							<input type="password" name="password" value=""
								placeholder="Senha" /> <input type="submit" value="Entrar">
						</form>
						<%
							if (msg != null) {
						%>
						<!-- Alert -->
						<div class="alert alert-danger" role="alert">
							${msg}
						</div>
						<%
							}
						%>

						<!-- Footer -->
						<footer>
							Em caso de problemas contactar o administrador:
							<jsp:useBean id="configuracao"
								class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
							<jsp:getProperty name="configuracao" property="email" />
						</footer>

					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
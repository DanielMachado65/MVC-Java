package com.ufpr.tads.web2.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ufpr.tads.web2.dao.ClienteDAO;

@WebServlet("/RemoverClienteServlet")
public class RemoverClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoverClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		ClienteDAO dao = new ClienteDAO();
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("nome");
		if (login != null) {
			int id_usuario = (Integer.parseInt(request.getParameter("id")));
			dao.removerCliente(id_usuario);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ClientesServlet");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
			request.setAttribute("pag", "index.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

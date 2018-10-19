package com.ufpr.tads.web2.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.dao.ClienteDAO;

@WebServlet("/NovoClienteServlet")
public class NovoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NovoClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		ClienteDAO dao = new ClienteDAO();
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("nome");
		if (login != null) {
			Cliente cliente = new Cliente();

			DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date data = new java.sql.Date(fmt.parse(request.getParameter("data")).getTime());
			cliente.setCpf_cliente(request.getParameter("cpf_cliente"));
			cliente.setNome_cliente(request.getParameter("cpf_cliente"));
			cliente.setEmail_cliente(request.getParameter("cpf_cliente"));
			cliente.setData_cliente(data);
			cliente.setRua_cliente(request.getParameter("rua_cliente"));
			cliente.setNr_cliente(Integer.parseInt(request.getParameter("cpf_cliente")));
			cliente.setCep_cliente(request.getParameter("cep_cliente"));
			cliente.setCidade_cliente(request.getParameter("cidade_cliente"));
			cliente.setUf_cliente(request.getParameter("uf_cliente"));

			int retorno = dao.addCliente(cliente);
			request.setAttribute("idGerado", retorno);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ufpr.tads.web2.beans.Cliente;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "Teste", urlPatterns = { "/Teste" })
public class Teste extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws Exception
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			try {
				ConnectionFactory.getConnection();

				ClienteDAO dao = new ClienteDAO();
				Cliente cliente = new Cliente();

				String dataString = "10/02/1999";

				DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
				cliente.setCpf_cliente("08882412911");
				cliente.setNome_cliente("Daniel");
				cliente.setEmail_cliente("daniel@gmail.com");
				cliente.setData_cliente(data);
				cliente.setRua_cliente("rua meu piru");
				cliente.setNr_cliente(123);
				cliente.setCep_cliente("1131273");
				cliente.setCidade_cliente("Curitiba");
				cliente.setUf_cliente("PR");

				dao.editarCliente(cliente, 3);

			} catch (ClassNotFoundException ex) {
				Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
			}

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Teste</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Teste at " + "CARREGADO" + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}

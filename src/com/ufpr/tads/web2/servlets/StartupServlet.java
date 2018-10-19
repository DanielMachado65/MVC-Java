package com.ufpr.tads.web2.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ufpr.tads.web2.beans.ConfigBean;


@WebServlet(name = "StartupServlet", urlPatterns = "/StartupServelt", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		ConfigBean confg = new ConfigBean();
		confg.setEmail("administrador@gmail.com");
                System.out.println("AAAAAAA");
		ServletContext contexto = config.getServletContext();
		contexto.setAttribute("configuracao", confg);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
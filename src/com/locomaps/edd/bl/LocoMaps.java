package com.locomaps.edd.bl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/accueil")
public class LocoMaps extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String VIEW_PAGES_URL="/WEB-INF/accueil.jsp";   


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocoMaps() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String passwd = request.getParameter("password");
		
		if (login.equals("sylvain") ){
			RequestDispatcher dispat =	request.getRequestDispatcher("/Welcome");
			dispat.forward(request,response);
		}
		else{
			doGet(request, response);
		}
		}

}

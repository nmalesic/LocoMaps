package com.locomaps.edd.bl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.bd.DataProvider;
import com.locomaps.edd.bl.model.bd.Persistance;
import com.locomaps.edd.bl.model.bd.PersistanceManager;
import com.locomaps.edd.bl.model.bd.PersistanceParameter;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/identification")
public class Identification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String VIEW_PAGES_URL="/WEB-INF/identification.jsp";   


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Identification() {
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

		// Lecture de la liste des utilisateurs de la session
		HttpSession sessionScope = request.getSession();

		Persistance persistance = PersistanceManager.getPersitanceSession(sessionScope); //GestionSession.getPersitanceSession(sessionScope);

		
		HashMap<String,User> listeUser = persistance.listAllUser();
		sessionScope.setAttribute("listeUser", listeUser);

		String email = request.getParameter("email");
		String passwd = request.getParameter("password");

		User userSession = persistance.getUserByEmail(email); 

		if (userSession == null){
			// L'utilisateur n'existe pas dans la session
			doGet(request, response);
			
		} else {
			// L'utilisateur existe dans la session
			// Test du password

			if (passwd.equals(userSession.getPassword())){
				sessionScope.setAttribute("userSession", userSession);
				response.sendRedirect("accueil");

			} else {
				// Le mot de passe est incorrect
				doGet(request, response);
			}

			}
		}

		

}

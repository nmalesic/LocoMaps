package com.locomaps.edd.bl;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.MapsUtils;
import com.locomaps.edd.bl.model.User;

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

		String login = request.getParameter("email");
		String passwd = request.getParameter("password");
		
		String origin = request.getParameter("origin");
		String waypoint = request.getParameter("waypoint1")+"|"+request.getParameter("waypoint2")+"|"+request.getParameter("waypoint3");
		
		
		//User UserSession = null;
		
		HttpSession sessionScope = request.getSession();
		String frame = MapsUtils.composeItineraire(origin,"64+rue+jean+rostand+31670+Labege",waypoint);
		request.setAttribute("frame", frame);
		
		User UserSession = GestionSession.getUserSession(sessionScope);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
		//sessionScope.getAttribute("UserSession");
		
		/*RequestDispatcher dispat =	request.getRequestDispatcher("/accueil");
		dispat.forward(request,response);
		*/
		
//		if (login.equals("sylvain") ){
//			RequestDispatcher dispat =	request.getRequestDispatcher("/accueil");
//			dispat.forward(request,response);
//		}
//		else{
//			doGet(request, response);
//		}
		
		
		
//		if (UserSession == null){
//			// L'utilisateur n'existe pas dans la session
//			doGet(request, response);
//			
//		} else {
//			// L'utilisateur existe dans la session
//			// Test du password
//
//			if (passwd.equals(UserSession.getPassword())){
//				sessionScope.setAttribute("UserSession", UserSession);
//				RequestDispatcher dispat =	request.getRequestDispatcher("/accueil");
//				dispat.forward(request,response);
//			} else {
//				// Le mot de passe est incorrect
//			}
//				doGet(request, response);
//			}
		}

}

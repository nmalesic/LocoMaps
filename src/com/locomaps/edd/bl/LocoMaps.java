package com.locomaps.edd.bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.Adresse2D;
import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.Location;
import com.locomaps.edd.bl.model.MapsUtils;
import com.locomaps.edd.bl.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


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

		
		String result = request.getParameter("result");
		String coords = request.getParameter("coords");
		String coordslat = request.getParameter("coordslat");
		String coordslng = request.getParameter("coordslng");

	  	Location coordLatlng = null;
	  	GoogleGeoCodeResponse gsonCoords = null;
	  	Adresse2D adressOrigin = null;
	  	ArrayList<User> listUserDansRayon = null;
		  
	  	// Récupération complète des info de la coordonnées
		  if(result != null) {
			    
			    final GsonBuilder gsonBuilder = new GsonBuilder();
			    final Gson gson = gsonBuilder.create();
			    gsonCoords = gson.fromJson( result, GoogleGeoCodeResponse.class);
			    adressOrigin = new Adresse2D(origin,gsonCoords);
			   
			    
			    // Recherche des voisins
			    listUserDansRayon = MapsUtils.chercheVoisin(adressOrigin.getGcoord().geometry.location, 5000);
		  }		  
		  
		HttpSession sessionScope = request.getSession();
		if (login!=null){ 
			origin = MapsUtils.getOrigin(sessionScope);
			System.out.println(origin);
			request.setAttribute("origin", origin);	
			}
		String frame = MapsUtils.composeItineraire(origin,"64+rue+jean+rostand+31670+Labege",waypoint);
		request.setAttribute("frame", frame);
		
		User userSession = GestionSession.getUserSession(sessionScope);

		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);


		//this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
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

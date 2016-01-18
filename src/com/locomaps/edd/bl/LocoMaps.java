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

import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.Latlng;
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

		
		String result = request.getParameter("JFM_RESULT");
		String coords = request.getParameter("coords");
		String coordslat = request.getParameter("coordslat");
		String coordslng = request.getParameter("coordslng");

	  	Latlng coordLatlng = null;
	  	GoogleGeoCodeResponse gsonCoords = null;
		
	   // Récupération uniquement de la coordonnée
//		  if(coords != null) {
//			    final GsonBuilder gsonBuilder = new GsonBuilder();
//			    final Gson gson = gsonBuilder.create();
//			    coordLatlng = gson.fromJson( coords, Latlng.class);
//		  }
		  
	  	// Récupération complète des info de la coordonnées
		  if(result != null) {
			    
			    final GsonBuilder gsonBuilder = new GsonBuilder();
			    final Gson gson = gsonBuilder.create();
			    gsonCoords = gson.fromJson( result, GoogleGeoCodeResponse.class);
		  }		  
		  
		HttpSession sessionScope = request.getSession();
		String frame = MapsUtils.composeItineraire(origin,"64+rue+jean+rostand+31670+Labege",waypoint);
		request.setAttribute("frame", frame);
		
		User userSession = GestionSession.getUserSession(sessionScope);

		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);

		}

}

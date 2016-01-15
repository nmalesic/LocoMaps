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

import com.locomaps.edd.bl.model.User;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/profil.jsp";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		String waypoint = request.getParameter("waypoint");
		
		composeItineraire(origin,destination,waypoint);
		doGet(request, response);
	}
	
	public String composeItineraire(String origin, String destination, String waypoint){
		
	/*	origin="Toulouse";
		destination="64+rue+rostand+labege";
		waypoint="";*/
		
		StringBuilder sb = new StringBuilder("");
		sb.append("https://www.google.com/maps/embed/v1/directions?origin=");
		sb.append(origin);
		sb.append("&destination=");
		sb.append(destination);
		sb.append("&key=AIzaSyDHdpHkRbHmVj4tZ4pt96z7lntPfvQ3naM");
		
		sb.append(waypoint);
				
		return sb.toString();
	}

	
}


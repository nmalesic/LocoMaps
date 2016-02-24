package com.locomaps.edd.bl.webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.locomaps.edd.bl.GestionSession;
import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.Location;
import com.locomaps.edd.bl.model.MapsUtils;
import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.db.Persistance;
import com.locomaps.edd.bl.model.db.PersistanceManager;

/**
 * Servlet implementation class UserWebService
 */
@WebServlet("/user")
public class UserWebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserWebService() {
        super();
        // TODO Auto-generated constructor stub
    }

//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sessionScope = request.getSession();
		User userSession = GestionSession.getUserSession(sessionScope);
		
		Persistance persistance = PersistanceManager.getPersitanceSession(sessionScope); //GestionSession.getPersitanceSession(sessionScope);
		

	    PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

        String paramUserValue = request.getParameter("getNeighbours");
        String paramLatValue = request.getParameter("lat");
        String paramLngValue = request.getParameter("lng");
        String paramRadiusValue = request.getParameter("radius");

        String paramConnectUserValue = request.getParameter("connectuser");
        String paramConnectPwdValue = request.getParameter("pwd");

        String paramAllUserValue = request.getParameter("alluser");
        
        if (paramAllUserValue != null) {
            ArrayList<User> neighBours = new ArrayList<User>();
    		HashMap<String,User> listeUser = persistance.listAllUser();
    		for (Entry<String,User> u : listeUser.entrySet()) {
    			neighBours.add(securityUser(u.getValue()));
    		}
    	    response.getWriter().print(ListUserPOJO2JSON(neighBours));

        } else if (paramConnectUserValue != null && paramConnectPwdValue != null) {
        	User user = persistance.getUserByEmail(paramConnectUserValue);
        	String pass = user.getPassword();
			if (paramConnectPwdValue.equals(pass)){
				user = securityUser(user);
	    	    response.getWriter().print(UserPOJO2JSON(user));
			} else {
				response.getWriter().print("{}");
			}

        } else if (paramUserValue != null && paramLatValue != null && paramLngValue != null) {
        	
		    // Recherche des voisins
        	ArrayList<User> listUserDansRayon = new ArrayList<User>() ;
        	Location location = new Location(paramLatValue, paramLngValue);
        	String rayon = paramRadiusValue!=null?paramRadiusValue:"5";
		    listUserDansRayon = MapsUtils.chercheVoisin(sessionScope,location, Integer.parseInt(rayon));
		    for (User user : listUserDansRayon) {
		    	securityUser(user);
			}

        	//User user = securityUser((persistance.getUserByEmail(paramUserValue)));
    	    response.getWriter().print(ListUserPOJO2JSON(listUserDansRayon));

        }
        


//        UserPOJO a;
//        Location loc;
//        LocoAddress locoAddress;
//
//        a = new UserPOJO("LocoMapsRABOIS","Sylvain","pion de 6","a@a.a","a","a", null, "0102030405","M","false");
//        loc = new Location("43.5563336","1.528394");
//        locoAddress = new LocoAddress("10 Avenue de Gameville","","31650","Saint-Orens-de-Gameville",loc);
//        locoAddress.setLocation(loc);
//        a.setAddress(locoAddress);
//        neighBours.add(a);
//
//        a = new UserPOJO("LocoMapsCHAMAYOU","Olivier","objet composition detache","b@b.b","b","b", null, "0602030405","M","false");
//        loc = new Location("43.6575","1.4853");
//        locoAddress = new LocoAddress("10 Rue du Pic du Midi","","31240","L Union",loc);
//        locoAddress.setLocation(loc);
//        a.setAddress(locoAddress);
//        neighBours.add(a);
//
//        a = new UserPOJO("LocoMapsCOEURET","Fabrice","Singleton","c@c.c","c","c", null, "0702030405","M","false");
//        loc = new Location("43.5175497","1.5057399");
//        locoAddress = new LocoAddress("Place Clemence Isaure","","31320","Castanet-Tolosan",loc);
//        locoAddress.setLocation(loc);
//        a.setAddress(locoAddress);
//        neighBours.add(a);
//        
//        

	    //response.getWriter().print(UserPOJO2JSON(a));
	    
//	    response.getWriter().print(ListUserPOJO2JSON(neighBours));

	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String UserPOJO2JSON(User user) {
		String result = null;
		if (user != null) {
			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
			result = gson.toJson(user, User.class);
		}
		return result;
	}
	
	public String ListUserPOJO2JSON(ArrayList<User> listUser) {

		String result = null;
		if (listUser != null) {
			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
	        Type listType = new TypeToken<ArrayList<User>>() {
	        }.getType();
			result = gson.toJson(listUser, listType);
		}
		return result;
	}
	
	private User securityUser(User user) {
		user.setPassword("");
		return user;
	}

}

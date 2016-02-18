package com.locomaps.edd.bl.webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.Location;

/**
 * Servlet implementation class UserWebService
 */
@WebServlet("/user/getAllUser")
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

	    PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    String paramName;
	    
	    paramName = "user";
        String paramUserValue = request.getParameter(paramName);

	    paramName = "alluser";
        String paramAllUserValue = request.getParameter(paramName);
        
        ArrayList<UserPOJO> neighBours = new ArrayList<UserPOJO>();

        UserPOJO a;
        Location loc;
        LocoAddress locoAddress;

        a = new UserPOJO("LocoMapsRABOIS","Sylvain","pion de 6","a@a.a","a","a", null, "0102030405","M","false");
        loc = new Location("43.5563336","1.528394");
        locoAddress = new LocoAddress("10 Avenue de Gameville","","31650","Saint-Orens-de-Gameville",loc);
        locoAddress.setLocation(loc);
        a.setAddress(locoAddress);
        neighBours.add(a);

        a = new UserPOJO("LocoMapsCHAMAYOU","Olivier","objet composition detache","b@b.b","b","b", null, "0602030405","M","false");
        loc = new Location("43.6575","1.4853");
        locoAddress = new LocoAddress("10 Rue du Pic du Midi","","31240","L Union",loc);
        locoAddress.setLocation(loc);
        a.setAddress(locoAddress);
        neighBours.add(a);

        a = new UserPOJO("LocoMapsCOEURET","Fabrice","Singleton","c@c.c","c","c", null, "0702030405","M","false");
        loc = new Location("43.5175497","1.5057399");
        locoAddress = new LocoAddress("Place Clemence Isaure","","31320","Castanet-Tolosan",loc);
        locoAddress.setLocation(loc);
        a.setAddress(locoAddress);
        neighBours.add(a);
        
        

	    //response.getWriter().print(UserPOJO2JSON(a));
	    
	    response.getWriter().print(ListUserPOJO2JSON(neighBours));

	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String UserPOJO2JSON(UserPOJO userPOJO) {
		String result = null;
		if (userPOJO != null) {
			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
			result = gson.toJson(userPOJO, UserPOJO.class);
		}
		return result;
	}
	
	public String ListUserPOJO2JSON(ArrayList<UserPOJO> listUserPOJO) {

		String result = null;
		if (listUserPOJO != null) {
			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
	        Type listType = new TypeToken<ArrayList<UserPOJO>>() {
	        }.getType();
			result = gson.toJson(listUserPOJO, listType);
		}
		return result;
	}

}

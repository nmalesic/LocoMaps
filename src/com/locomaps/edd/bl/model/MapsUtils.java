package com.locomaps.edd.bl.model;

import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.GestionSession;

public class MapsUtils {

	
	//String destination = request.getParameter("destination");
	//String waypoint = request.getParameter("waypoint");
	
	//composeItineraire(origin,destination,waypoint);	
	public String getOrigin (HttpSession sessionScope){
		StringBuilder origin =new StringBuilder("");
		User user = GestionSession.getUserSession(sessionScope);
		origin.append(user.getAdresse1().replaceAll("\\s+","+"));
		origin.append("+");
		origin.append(user.getAdresse1().replaceAll("\\s+","+"));
		origin.append("+");
		origin.append(user.getCP().replaceAll("\\s+","+"));
		origin.append("+");
		origin.append(user.getVille().replaceAll("\\s+","+"));
		
		return origin.toString();
	}
	
	public String getDestination(){
		
		return "64+rue+jean+Rostand";
	}
	
// <iframe width="600" height="450" frameborder="1" style="border:0px"
//src="https://www.google.com/maps/embed/v1/directions?origin=Toulouse&destination=64+rue+rostand+labege&key=AIzaSyDHdpHkRbHmVj4tZ4pt96z7lntPfvQ3naM&waypoints=Ramonville+st+agne" 
// allowfullscreen></iframe>

	
	
	
public static String composeItineraire(String origin, String destination, String waypoint){
		
		StringBuilder sb = new StringBuilder("");
		sb.append("<iframe width=\"600\" height=\"450\" frameborder=\"1\" style=\"border:0px\" src=\"");
		sb.append("https://www.google.com/maps/embed/v1/directions?origin=");
		sb.append(origin);
		sb.append("&destination=");
		sb.append(destination);
		sb.append("&key=AIzaSyDHdpHkRbHmVj4tZ4pt96z7lntPfvQ3naM");
		/*if (waypoint != null || !waypoint.equals(" ")){
			sb.append("&").append(waypoint);
			}*/
		sb.append("\" allowfullscreen></iframe>");
		
		return sb.toString();
	}
}

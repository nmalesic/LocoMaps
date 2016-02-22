package com.locomaps.edd.bl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.db.Persistance;
import com.locomaps.edd.bl.model.db.PersistanceManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.locomaps.edd.bl.GestionSession;

public class MapsUtils {
  public static final String BL ="64+rue+jean+Rostand";
	

//	public static String getOrigin (HttpSession sessionScope){
//		StringBuilder origin =new StringBuilder("");
//		User user = GestionSession.getUserSession(sessionScope);
//		System.out.println(user.getAdresse1());
//		origin.append(user.getAdresse1().replaceAll("\\s+","+"));
//		origin.append("+");
//		origin.append(user.getAdresse1().replaceAll("\\s+","+"));
//		origin.append("+");
//		origin.append(user.getCP().replaceAll("\\s+","+"));
//		origin.append("+");
//		origin.append(user.getVille().replaceAll("\\s+","+"));
//		
//		return origin.toString();
//	}
//	
//	public String getDestination(){
//				return BL;
//	}
	
public static String composeItineraire(String origin, String destination, String waypoint){
		
		StringBuilder sb = new StringBuilder("");
		sb.append("<iframe width=\"600\" height=\"450\" frameborder=\"1\" style=\"border:0px;border-radius: 35px\" src=\"");
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


/**
 * Chercher les utilisateurs dont l'adresse est dans le rayon demand�
 * @param centre centre du cercle de recherche
 * @param Rayon Rayon de recherche
 * @return
 */
public static ArrayList<User>  chercheVoisin(HttpSession sessionScope, Location centre, int Rayon) {
	Persistance persistance = PersistanceManager.getPersitanceSession(sessionScope); //GestionSession.getPersitanceSession(sessionScope);
	
	HashMap<String,User> listeUser = persistance.listAllUser();
	
	//HashMap<String,User> listUserDansRayon = new HashMap<String,User>() ;
	ArrayList<User> listUserDansRayon = new ArrayList<User>() ;


	for(Map.Entry<String,User> user : listeUser.entrySet()){
		
		double dist = distance(Double.parseDouble(user.getValue().getAddress().getLocation().lat)
				,Double.parseDouble(centre.lat)
				,Double.parseDouble(user.getValue().getAddress().getLocation().lng)
				,Double.parseDouble(centre.lng)
				,(double)0
				,(double)0);
				
		//user.getKey();
		if (dist < Rayon*1000) {
			listUserDansRayon.add(user.getValue());
		}
		 
		}

	
		
//	for (User user : listeUser) {
//		
//		
//	}

			
	// TODO Chercher les utilisateurs dont l'adresse est dans le rayon demand�
	// On pourrait utiliser une requ�te de ce type pour filtrer les voisins dans un carr� inscrit dans le rayon demand�
	/*

select formatted_address, place_id
from address 
where address.lat between X1 and X2 
and address.Lng between y1 and y2

	 */
	// Puis utiliser une m�thode java pour calculer la distance et filtrer uniquement les coordonn�es inscrites dans le cercle
	/*
	 * Parcourir les coordonn�es lues pour calculer les distances en elles et le centre du cercle
	 * distance(lat1,lat2,lng1,lng2,0,0)
	 */
	
	return listUserDansRayon;
	
}

/*
 * Calculate distance between two points in latitude and longitude taking
 * into account height difference. If you are not interested in height
 * difference pass 0.0. Uses Haversine method as its base.
 * 
 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
 * el2 End altitude in meters
 * @returns Distance in Meters
 */
public static double distance(double lat1, double lat2, double lon1,
        double lon2, double el1, double el2) {

    final int R = 6371; // Radius of the earth

    Double latDistance = Math.toRadians(lat2 - lat1);
    Double lonDistance = Math.toRadians(lon2 - lon1);
    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000; // convert to meters

    double height = el1 - el2;

    distance = Math.pow(distance, 2) + Math.pow(height, 2);

    return Math.sqrt(distance);
}

/**
 * Enregistre en base de donn�e la coordonn�e associ�e � l'adresse
 * @param address
 * @return
 */
public static boolean StockCoord(Adresse2D address){
	boolean result = false;
	
	// TODO Enregistre en base de donn�e la coordonn�e associ�e � l'adresse
	
	return result;
}

/**
 * Renvoie la liste de toutes les coordonn�es
 * @return
 */
public static ArrayList<Adresse2D> listAllCoord() {
	ArrayList<Adresse2D> address = new ArrayList<Adresse2D>();
	
	// TODO Renvoie la liste de toutes les coordonn�es
	
	return address;
}


/**
 * Lecture de tous les User en base de donn�e
 * @return
 */
public static ArrayList<User> listAllUser() {
	ArrayList<User> listUser = new ArrayList<User>();
	
	// TODO Lecture de tous les User en base de donn�e
	
	return listUser;
}

public static GoogleGeoCodeResponse result2GCoord(String result) {
	// R�cup�ration compl�te des info de la coordonn�es
	GoogleGeoCodeResponse gsonCoords = null;
	if (result != null) {

		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		gsonCoords = gson.fromJson(result, GoogleGeoCodeResponse.class);
	}
	return gsonCoords;
}

public static String GCoord2result(GoogleGeoCodeResponse gsonCoords) {
	String result = null;
	if (gsonCoords != null) {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		result = gson.toJson(gsonCoords, GoogleGeoCodeResponse.class);
	}
	return result;
}

}

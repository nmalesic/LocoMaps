package com.locomaps.edd.bl;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.User;

public class GestionSession {

	/**
	 * Récupère la liste des utilisateurs enregistrés dans la session en cours
	 * Retour une hashmap vide s'il n'y a pas d'utilisateur
	 * Exemple d'utilisation :
	 * 
	 * HttpSession sessionScope = request.getSession();
	 * HashMap<String,User> listeUser = GestionSession.getListUser(sessionScope);
	 * 
	 * @param sessionScope
	 * @return
	 */
	static HashMap<String,User> getListUser(HttpSession sessionScope) {
		HashMap<String,User> listeUser = (HashMap<String, User>) sessionScope.getAttribute( "listeUser" ); 
		if (listeUser == null) {
			listeUser = new HashMap<String,User>();
		}
		return listeUser;
	}
	
	/**
	 * Récupère l'utilisateur à partir de son mail s'il est inscrit
	 * retourne null sinon
	 * 
	 * Exemple d'utilisation :
	 * 
	 * HttpSession sessionScope = request.getSession();
	 * User UserSession = GestionSession.getUserSessionbyEmail(sessionScope, email);
	 * 
	 * @param sessionScope
	 * @param email
	 * @return
	 */
	static User getUserSessionbyEmail(HttpSession sessionScope, String email) {
		HashMap<String,User> listeUser = getListUser(sessionScope);
		User UserSession = listeUser.get(email);
		return UserSession;
	}
	
	/**
	 * Retourne l'utilisateur en cours s'il est connecté
	 * Retourne null sinon
	 * 
	 * Exemple d'utilisation :
	 * 
	 * HttpSession sessionScope = request.getSession();
	 * User UserSession = GestionSession.getUserSession(sessionScope);
	 * 
	 * @param sessionScope
	 * @return
	 */
	static User getUserSession(HttpSession sessionScope) {
		//User UserSession = listeUser.get(email);
		//User UserSession = null;
		return (User)sessionScope.getAttribute("UserSession");
		//return UserSession;
	}
}

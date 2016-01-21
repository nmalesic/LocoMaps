package com.locomaps.edd.bl;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.bd.Persistance;
import com.locomaps.edd.bl.model.bd.PersistanceManager;
import com.locomaps.edd.bl.model.bd.PersistanceParameter;

public class GestionSession {

	/**
	 * Récupère l'objet persistence stocké dans la session et le crée à la première utilisation
	 * @param sessionScope
	 * @return
	 */
	public static Persistance getPersitanceSession(HttpSession sessionScope) {
		Persistance persistance = (Persistance) sessionScope.getAttribute("persistance");
		if (persistance == null) {
			persistance = PersistanceManager.getPersistance(PersistanceParameter.datatype);
			persistance.initDB(sessionScope);
			sessionScope.setAttribute("persistance", persistance);
		}
		return persistance;
	}

	/**
	 * Retourne l'utilisateur en cours s'il est connecté Retourne null sinon
	 * 
	 * Exemple d'utilisation :
	 * 
	 * HttpSession sessionScope = request.getSession(); User userSession =
	 * GestionSession.getuserSession(sessionScope);
	 * 
	 * @param sessionScope
	 * @return
	 */
	public static User getUserSession(HttpSession sessionScope) {
		return (User) sessionScope.getAttribute("userSession");
	}
}

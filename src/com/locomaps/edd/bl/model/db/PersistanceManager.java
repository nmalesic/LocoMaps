package com.locomaps.edd.bl.model.db;

import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.db.ConnexionDB;
import com.locomaps.edd.bl.db.mysql.MySqlDAO;
import com.locompas.edd.bl.model.bd.session.SessionConnection;

public class PersistanceManager {

	public static Persistance getPersistance(DataProvider providerType) {

		Persistance iDbConnection = null;
		switch (providerType) {
		case SESSION:
			//iDbConnection = new SessionConnection();
			break;
		case SQLITE:

			//iDbConnection = ConnexionDB.getInstance(PersistanceParameter.chaineDeConnexion);


			break;
		case MYSQL:
			iDbConnection = MySqlDAO.getInstance(PersistanceParameter.chaineDeConnexion,PersistanceParameter.username,PersistanceParameter.password);


			break;
		default:
			return null;
		}
		return iDbConnection;

	}

	
	public static Persistance getPersitanceSession(HttpSession sessionScope) {
		Persistance persistance = (Persistance) sessionScope.getAttribute("persistance");
		if (persistance == null) {
			persistance = PersistanceManager.getPersistance(PersistanceParameter.datatype);
			sessionScope.setAttribute("persistance", persistance);
		}
		return persistance;
	}
}

package com.locomaps.edd.bl.model.bd;

import javax.servlet.http.HttpSession;

import com.locompas.edd.bl.model.bd.session.SessionConnection;

public class PersistanceManager {

	public static Persistance getPersistance(DataProvider providerType) {

		Persistance iDbConnection = null;
		switch (providerType) {
		case SESSION:
			iDbConnection = new SessionConnection();
			break;
		case SQLITE:
			// TODO
			// iDbConnection = new SqliteConnection();
			iDbConnection = null;

			break;
		default:
			return null;
		}
		return iDbConnection;

	}

	
}

package com.locompas.edd.bl.model.bd.session;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.db.Persistance;
import com.locomaps.edd.bl.model.db.PersistanceManager;
import com.locomaps.edd.bl.model.db.PersistanceParameter;

public class SessionConnection { //implements Persistance{

//	public SessionConnection() {
//		super();
//	}
//
//	Boolean activeConnection;
//	HttpSession sessionScope;
//	
//	public HttpSession getSessionScope() {
//		return sessionScope;
//	}
//
//	private void setSessionScope(HttpSession sessionScope) {
//		if (sessionScope == null){
//			this.activeConnection = false;
//		} else {
//			this.activeConnection = true;
//		}
//		
//		this.sessionScope = sessionScope;
//	}
//
//	@Override
//	public HashMap<String, User> listAllUser() {
//		HashMap<String,User> listeUser = (HashMap<String, User>) sessionScope.getAttribute("listeUser"); 
//		if (listeUser == null) {
//			listeUser = new HashMap<String,User>();
//		}
//		return listeUser;
//	}
//
//	@Override
//	public User getUserByEMail(String email) {
//		HashMap<String,User> listeUser = listAllUser();
//		User userSession = listeUser.get(email);
//		
//		return userSession;
//	}
//	
//	@Override
//	public boolean change(User user) {
//		HashMap<String,User> listeUser = listAllUser();
//		listeUser.put(user.getEmail(),user);
//		
//		return true;
//	}
//	
//	@Override
//	public boolean addUser(User user) {
//		HashMap<String,User> listeUser = listAllUser();
//		// Ajout du nouvel utilisateur dans la session
//		listeUser.put(user.getEmail(),user);
//		
//		return true;
//	}
//
//	@Override
//	public boolean initDB(Object chaineDeConnexion) {
//		boolean retour = false;
//
//		if (chaineDeConnexion instanceof String) {
//			retour = false;
//		} else if (chaineDeConnexion instanceof HttpSession) {
//			this.setSessionScope((HttpSession)chaineDeConnexion);
//			retour = this.activeConnection;
//		}
//		return retour;
//	}
//



}

package com.locomaps.edd.bl.test;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.locomaps.edd.bl.GestionSession;
import com.locomaps.edd.bl.Register;
import com.locomaps.edd.bl.model.User;

public class GestionSessionTest {

	User user; 
	Register register;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//@Test
	public void getUserSessionbyEmailTest() 
	{
//		register = new Register();
//		register.getServletConfig();
//		GestionSession session = new GestionSession();
//		HttpServletRequest request = (HttpServletRequest) ((HttpServletRequest) register).getSession();
//		HttpSession sessionScope = request.getSession();
//		HashMap<String,User> listeUser = session.getListUser(sessionScope);
//		//String actionMessage;
//		//Boolean errorStatus;
//		//String errMsg;
//		//Map<String, String> erreurs = new HashMap<String, String>();
//
//		user = new User("COEURET","Fabrice","fabrice.coeuret","fabrice.coeuret@berger-levrault.com","123456789","123456789","8 rue de la paix",null,"31000","TOULOUSE","0632211444","Masculin","NON");
//
//		listeUser.put(user.getEmail(),user);
//
//		// Ajout du nouvel utilisateur dans la session
//		User userSession = session.getUserSessionbyEmail(sessionScope, user.getEmail());
//		assertEquals(user, userSession);
		
	}

}

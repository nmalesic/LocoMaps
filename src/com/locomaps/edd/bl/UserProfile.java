package com.locomaps.edd.bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.locomaps.edd.bl.model.Adresse2D;
import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.MapsUtils;
import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.db.Persistance;
import com.locomaps.edd.bl.model.db.PersistanceManager;
import com.locomaps.edd.bl.webservice.LocoAddress;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String VIEW_PAGES_URL="/WEB-INF/UserProfile.jsp";  

	public static final String FIELD_NOM_UTIL = "nomUtil";
	public static final String FIELD_PRENOM_UTIL = "prenomUtil";
	public static final String FIELD_PSEUDO = "pseudo";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD1 = "password";
	public static final String FIELD_PWD2 = "confirmPassword";
	public static final String FIELD_ADR1 = "adresse1";
	public static final String FIELD_ADR2 = "adresse2";
	public static final String FIELD_CP = "CP";
	public static final String FIELD_VILLE = "ville";
	public static final String FIELD_TEL = "telephone";
	public static final String FIELD_SEXE = "sexe";
	public static final String FIELD_FUMEUR = "fumeur";

	private Map<String, String> form = new HashMap<String, String>();
	private Map<String, String> erreurs = new HashMap<String, String>();
	Collection<String> listName = new ArrayList<String>();
	private String actionMessage;
	private String errMsg;
	private Boolean errorStatus;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sessionScope = request.getSession();

		Persistance persistance = PersistanceManager.getPersitanceSession(sessionScope);
		HashMap<String,User> listeUser = persistance.listAllUser();
		sessionScope.setAttribute("listeUser", listeUser);

		form = new HashMap<String, String>();
		erreurs = new HashMap<String, String>();

		errorStatus = false;

		String email = request.getParameter(FIELD_EMAIL);	
		User userCourant = persistance.getUserByEmail(email); 
		
//		errMsg = validateEmail(email);
//		if (errMsg !=null)
//		{
//			erreurs.put(FIELD_EMAIL, errMsg);
//			form.put(FIELD_EMAIL, "");
//			errorStatus = true;
//		}
//		else
//		{
//			if (! userCourant.getEmail().equals(email)){
//				userCourant.setEmail(email);
//			}
//		}


		String nomUtil = request.getParameter(FIELD_NOM_UTIL);
		errMsg = validateInfo(nomUtil,1);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_NOM_UTIL, errMsg);
			form.put(FIELD_NOM_UTIL, "");
			errorStatus = true;
		}
		else
		{
			if (! userCourant.getLastName().equals(nomUtil)){
				userCourant.setLastName(nomUtil);
			}
		}

		String prenomUtil = request.getParameter(FIELD_PRENOM_UTIL);
		errMsg = validateInfo(prenomUtil,2);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_PRENOM_UTIL, errMsg);
			form.put(FIELD_PRENOM_UTIL, "");
			errorStatus = true;
		}
		else
		{
			if (! userCourant.getFirstName().equals(prenomUtil)){
				userCourant.setFirstName(prenomUtil);
			}
		}

		String pseudo = request.getParameter(FIELD_PSEUDO);
		errMsg = validateInfo(pseudo,3);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_PSEUDO, errMsg);
			form.put(FIELD_PSEUDO, "");
			errorStatus = true;
		}
		else
		{
			if (! userCourant.getPseudo().equals(pseudo)){
				userCourant.setPseudo(pseudo);
			}
		}

		String adr1 = request.getParameter(FIELD_ADR1);

		errMsg = validateInfo(adr1,4);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_ADR1, errMsg);
			form.put(FIELD_ADR1, "");
			errorStatus = true;
		}
		else
		{
			if (! userCourant.getAdress1().equals(adr1)){
				userCourant.setAdress1(adr1);
			}		}

		String adr2 = request.getParameter(FIELD_ADR2);
		if (! userCourant.getAdress2().equals(adr2)){
			userCourant.setAdress2(adr2);}


		String cp = request.getParameter(FIELD_CP);


		errMsg = validateInfo(cp,5);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_CP, errMsg);
			form.put(FIELD_CP, "");
			errorStatus = true;
		}
		else
		{
			if (! userCourant.getCodePostal().equals(cp)){
				userCourant.setCodePostal(cp);		}
		}

		String ville = request.getParameter(FIELD_VILLE);
		errMsg = validateInfo(ville,6);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_VILLE, errMsg);
			form.put(FIELD_VILLE, "");
			errorStatus = true;
		}
		else
		{
			if (! userCourant.getCity().equals(ville)){
				userCourant.setCity(ville);		}
		}

		String tel = request.getParameter(FIELD_TEL);
		errMsg = validateTel(tel);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_TEL, errMsg);
			form.put(FIELD_TEL, tel);
			errorStatus = true;
		}
		else
		{
			if (! userCourant.getTelephone().equals(tel)){
				userCourant.setTelephone(tel);		}}


		String sexe = request.getParameter(FIELD_SEXE);
		if (! userCourant.getSex().equals(sexe)){
			userCourant.setSex(sexe);}

		String fumeur = request.getParameter(FIELD_FUMEUR);
		if (! userCourant.getSmoker().equals(fumeur)){
			userCourant.setSmoker(fumeur);}

		if (errorStatus)
		{
			actionMessage = "Echec de la modification";
			request.setAttribute("form", form);
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("actionMessage", actionMessage);
			request.setAttribute("errorStatus", errorStatus);

			doGet(request, response);
		}
		else{
			
			String result = request.getParameter("result");
//			
//		  	//GoogleGeoCodeResponse gsonCoords = null;
//		  	Adresse2D adressOrigin = null;
//			  
//		  	// R�cup�ration compl�te des info de la coordonn�es
//			  if(result != null) {
//				  adressOrigin = new Adresse2D(adr1,adr2,cp,ville,result);
//			  } else {
//				  //** Interdiction d'enregistr� une adresse non g�ocod�e
//					// Enregistrer le statut de l'action
//					actionMessage = "Echec de l'inscription";
//					errorStatus = true;
//					errMsg = "L'adresse n'a pas pu �tre g�ocod�e";
//					erreurs.put(FIELD_VILLE, errMsg);
//
//					request.setAttribute("form", form);
//					request.setAttribute("erreurs", erreurs);
//					request.setAttribute("actionMessage", actionMessage);
//					request.setAttribute("errorStatus", errorStatus);
//
//					doGet(request, response);
//			  }
//			
//			User newUser = null;
//			//Adresse2D newAdress = new Adresse2D(adr1, adr2, cp, ville, gsonCoords, result);
//			newUser = new User(nomUtil, prenomUtil, pseudo, email, pwd1, pwd2, adressOrigin, tel, sexe, fumeur);
//			
			//Adresse2D adresseAModifier = userCourant.getAddress();
			//userCourant.getAddress().setGcoord((adresseAModifier.result2GCoord(result)));
			
			// R�cup�ration compl�te des info de la coordonn�es
			  if(result != null) {
				  GoogleGeoCodeResponse gsonCoords = MapsUtils.result2GCoord(result);
				  userCourant.getAddress().setOnelineAddress(gsonCoords.formatted_address);
				  userCourant.getAddress().setLocation(gsonCoords.geometry.location);
				  
					sessionScope.setAttribute("userSession", userCourant);
					persistance.change(userCourant);
					response.sendRedirect("accueil");
			  } else {
				  //** Interdiction d'enregistr� une adresse non g�ocod�e
					// Enregistrer le statut de l'action
					actionMessage = "Echec de la modification";
					errorStatus = true;
					errMsg = "L'adresse n'a pas pu �tre g�ocod�e";
					erreurs.put(FIELD_VILLE, errMsg);

					request.setAttribute("form", form);
					request.setAttribute("erreurs", erreurs);
					request.setAttribute("actionMessage", actionMessage);
					request.setAttribute("errorStatus", errorStatus);

					doGet(request, response);
			  }
				  

		}



	}

	public String validateEmail(String mail)
	{
		String err = null;
		if ( mail != null && mail.trim().length() != 0 ) 
		{
			if ( !mail.matches( "([A-z0-9]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
			{
				err = "Veuillez saisir une adresse mail valide";
			}
		}
		else 
		{
			err = "L'adresse mail est obligatoire";
		}

		return err;
	}

	public String validatePwd(String pwd1, String pwd2)
	{
		String err = null;
		if (pwd1 == null)
		{
			err = "Le mot de passe est obligatoire";
		}
		else
		{
			if (pwd1.length() < 6)
			{
				err = "Le mot de passe doit contenir au minimum 8 caract�res";
			}


			if (!pwd1.equals(pwd2))
			{
				err = "Les mots de passes ne sont pas identiques";
			}
		}

		return err;
	}

	public String validateInfo(String name,int n)
	{
		String err = null;
		if (name == null || name.equals(""))
		{
			switch (n)
			{
			case 1:
				err = "Le nom d'utilisateur est obligatoire";
				break;
			case 2:
				err = "Le pr�nom est obligatoire";
				break;
			case 3:
				err = "Le pseudo est obligatoire";
				break;
			case 4:
				err = "L'adresse est obligatoire";
				break;
			case 5:
				err = "Le code postal est obligatoire";
				break;
			case 6:
				err = "La ville est obligatoire";
				break;
			}		

		}
		return err;
	}

	public String validateTel(String tel)
	{
		String err = null;
		if ( tel != null && tel.trim().length() != 0 ) 
		{
			//^(?:0|\+33)[1-9](?:([\/ -.]?)[0-9]{2})(?:\1[0-9]{2}){3}$

			if ( !tel.matches( "^(0|\\+33)[1-9][0-9]{8}$"))
			{
				err = "Veuillez saisir un num�ro de t�l�phone valide";
			}
		}

		return err;
	}

}

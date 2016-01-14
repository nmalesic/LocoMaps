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

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
//@WebServlet(name = "/Register", urlPatterns = {"/form.html"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String VIEW_PAGES_URL="/WEB-INF/Register.jsp";
       
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

	
	
	private Map<String, String> form = new HashMap<String, String>();
	private Map<String, String> erreurs = new HashMap<String, String>();
	Collection<String> listName = new ArrayList<String>();
	private String actionMessage;
	private String errMsg;
	private Boolean errorStatus;
	
	//private User newUser=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		form = new HashMap<String, String>();
		erreurs = new HashMap<String, String>();
		
		errorStatus = false;
		
		String nomUtil = request.getParameter(FIELD_NOM_UTIL);
		errMsg = validateInfo(nomUtil,1);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_NOM_UTIL, errMsg);
			form.put(FIELD_NOM_UTIL, nomUtil);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_NOM_UTIL, "");
			//if (!errorStatus)
			//	listName.add(nomUtil);
		}
	
		String prenomUtil = request.getParameter(FIELD_PRENOM_UTIL);
		errMsg = validateInfo(prenomUtil,2);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_PRENOM_UTIL, errMsg);
			form.put(FIELD_PRENOM_UTIL, prenomUtil);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_PRENOM_UTIL, "");
			//if (!errorStatus)
			//	listName.add(prenomUtil);
		}
		
		String pseudo = request.getParameter(FIELD_PSEUDO);
		errMsg = validateInfo(pseudo,3);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_PSEUDO, errMsg);
			form.put(FIELD_PSEUDO, pseudo);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_PSEUDO, "");
			//if (!errorStatus)
			//	listName.add(prenomUtil);
		}

		String email = request.getParameter(FIELD_EMAIL);
		errMsg = validateEmail(email);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_EMAIL, errMsg);
			form.put(FIELD_EMAIL, email);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_EMAIL, "");
		}

		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		errMsg = validatePwd(pwd1,pwd2);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_PWD1, errMsg);
			form.put(FIELD_PWD1, pwd1);
			form.put(FIELD_PWD2, pwd2);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_PWD1, "");
			form.put(FIELD_PWD2, "");
		}
		
		String adr1 = request.getParameter(FIELD_ADR1);

		errMsg = validateInfo(adr1,4);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_ADR1, errMsg);
			form.put(FIELD_ADR1, adr1);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_ADR1, "");
		}
		
		String cp = request.getParameter(FIELD_CP);

		errMsg = validateInfo(cp,5);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_CP, errMsg);
			form.put(FIELD_CP, cp);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_CP, "");
		}

		String ville = request.getParameter(FIELD_VILLE);
		errMsg = validateInfo(ville,6);
		if (errMsg !=null)
		{
			erreurs.put(FIELD_VILLE, errMsg);
			form.put(FIELD_VILLE, ville);
			errorStatus = true;
		}
		else
		{
			form.put(FIELD_VILLE, "");
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
			form.put(FIELD_TEL, "");
		}

		if (errorStatus)
		{
			actionMessage = "Echec de l'inscription";
		}
		else
		{
			actionMessage = "Succès de l'inscription";
			
			//newUser = new User(util, email, pwd1);
			
			//request.setAttribute("newUser", newUser);
		}
	
		request.setAttribute("form", form);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("actionMessage", actionMessage);
		request.setAttribute("errorStatus", errorStatus);

		//this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include( request, response );
		doGet(request, response);

	}
	
	private String validateEmail(String mail)
	{
		String err = null;
		if ( mail != null && mail.trim().length() != 0 ) 
		{
			if ( !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
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
	
	private String validatePwd(String pwd1, String pwd2)
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
				err = "Le mot de passe doit contenir au minimum 8 caractères";
			}
			
			
			if (!pwd1.equals(pwd2))
			{
				err = "Les mots de passes ne sont pas identiques";
			}
		}
		
		return err;
	}
	
	private String validateInfo(String name,int n)
	{
		String err = null;
		if (name == null)
		{
			switch (n)
			{
				case 1:
					err = "Le nom d'utilisateur est obligatoire";
					break;
				case 2:
					err = "Le prénom est obligatoire";
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

	private String validateTel(String tel)
	{
		String err = null;
		if ( tel != null && tel.trim().length() != 0 ) 
		{
			//^(?:0|\+33)[1-9](?:([\/ -.]?)[0-9]{2})(?:\1[0-9]{2}){3}$

			if ( !tel.matches( "^(0|\\+33)[1-9][0-9]{8}$"))
			{
				err = "Veuillez saisir un numéro de téléphone valide";
			}
		}
		
		return err;
	}
	
}

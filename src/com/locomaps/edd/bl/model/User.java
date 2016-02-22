package com.locomaps.edd.bl.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.locomaps.edd.bl.webservice.LocoAddress;

import java.io.Serializable;

public class User implements Serializable{

	private int id;
	private String lastName;
	private String firstName;
	private String pseudo;
	private String email;
	private String password;
	private String confirmPassword;

	/*
	 * private String adresse1; private String adresse2; private String CP;
	 * private String ville;
	 */

	private LocoAddress address;

	private String telephone;
	private String sex;
	private String smoker;

	/**
	     * constructeur User
	     */
	    public User() {

	    }

	/**
	     * Constructeur User avec adresse Geocodée
	     *
	     * @param lastName
	     * @param firstName
	     * @param pseudo
	     * @param email
	     * @param password
	     * @param confirmPassword
	     * @param address
	     * @param telephone
	     * @param sexe
	     * @param smoker
	     */
	    public User(String lastName, String firstName, String pseudo, String email, String password, String confirmPassword,
	                LocoAddress address, String telephone, String sexe, String smoker) {
	        super();
	        this.lastName = lastName;
	        this.firstName = firstName;
	        this.pseudo = pseudo;
	        this.email = email;
	        this.password = password;
	        this.confirmPassword = confirmPassword;
	        this.address = address;
	        this.telephone = telephone;
	        this.sex = sexe;
	        this.smoker = smoker;
	    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAdress1() {
		return this.address.getAddress1();
	}

	public void setAdress1(String adresse1) {
		this.address.setAddress1(adresse1);
	}

	public String getAdress2() {
		return this.address.getAddress2();
	}

	public void setAdress2(String adresse2) {
		this.address.setAddress2(adresse2);
	}

	public String getCodePostal() {
		return this.address.getCodePostal();
	}

	public void setCodePostal(String CodePostal) {
		this.address.setCodePostal(CodePostal);
	}

	public String getCity() {
		return this.address.getCity();
	}

	public void setCity(String ville) {
		this.address.setCity(ville);
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSmoker() {
		return smoker;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	public LocoAddress getAddress() {
		return address;
	}

	public void setAddress(LocoAddress address) {
		this.address = address;
	}

}


//public class User {
//
//	private int id;
//	private String nomUtil;
//	private String prenomUtil;
//	private String pseudo;
//	private String email;
//	private String password;
//	private String confirmPassword;
//
//	/*
//	 * private String adresse1; private String adresse2; private String CP;
//	 * private String ville;
//	 */
//
//	private Adresse2D address;
//
//	private String telephone;
//	private String sexe;
//	private String fumeur;
//
//	/**
//	 * constructeur User
//	 */
//	public User() {
//
//	}
//
////	/**
////	 * Constructeur User avec adresse du profil
////	 * 
////	 * @param nomUtil
////	 * @param prenomUtil
////	 * @param pseudo
////	 * @param email
////	 * @param password
////	 * @param confirmPassword
////	 * @param adresse1
////	 * @param adresse2
////	 * @param CP
////	 * @param ville
////	 * @param telephone
////	 * @param sexe
////	 * @param fumeur
////	 */
////	public User(String nomUtil, String prenomUtil, String pseudo, String email, String password, String confirmPassword,
////			String adresse1, String adresse2, String CP, String ville, String telephone, String sexe, String fumeur) {
////		super();
////		this.nomUtil = nomUtil;
////		this.prenomUtil = prenomUtil;
////		this.pseudo = pseudo;
////		this.email = email;
////		this.password = password;
////		this.confirmPassword = confirmPassword;
////		/*this.adresse1 = adresse1;
////		this.adresse2 = adresse2;
////		this.CP = CP;
////		this.ville = ville;*/
////		Adresse2D address = new Adresse2D(adresse1, adresse2, CP, ville);
////		this.telephone = telephone;
////		this.sexe = sexe;
////		this.fumeur = fumeur;
////	}
//
//	/**
//	 * Constructeur User avec adresse Geocod�e
//	 * 
//	 * @param nomUtil
//	 * @param prenomUtil
//	 * @param pseudo
//	 * @param email
//	 * @param password
//	 * @param confirmPassword
//	 * @param address
//	 * @param telephone
//	 * @param sexe
//	 * @param fumeur
//	 */
//	public User(String nomUtil, String prenomUtil, String pseudo, String email, String password, String confirmPassword,
//			Adresse2D address, String telephone, String sexe, String fumeur) {
//		super();
//		this.nomUtil = nomUtil;
//		this.prenomUtil = prenomUtil;
//		this.pseudo = pseudo;
//		this.email = email;
//		this.password = password;
//		this.confirmPassword = confirmPassword;
//		this.address = address;
//		this.telephone = telephone;
//		this.sexe = sexe;
//		this.fumeur = fumeur;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNomUtil() {
//		return nomUtil;
//	}
//
//	public void setNomUtil(String nomUtil) {
//		this.nomUtil = nomUtil;
//	}
//
//	public String getPrenomUtil() {
//		return prenomUtil;
//	}
//
//	public void setPrenomUtil(String prenomUtil) {
//		this.prenomUtil = prenomUtil;
//	}
//
//	public String getPseudo() {
//		return pseudo;
//	}
//
//	public void setPseudo(String pseudo) {
//		this.pseudo = pseudo;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}
//
//	public String getAdresse1() {
//		return this.address.getAdresse1();
//	}
//
//	public void setAdresse1(String adresse1) {
//		this.address.setAdresse1(adresse1);
//	}
//
//	public String getAdresse2() {
//		return this.address.getAdresse2();
//	}
//
//	public void setAdresse2(String adresse2) {
//		this.address.setAdresse2(adresse2);
//	}
//
//	public String getCP() {
//		return this.address.getCP();
//	}
//
//	public void setCP(String CP) {
//		this.address.setCP(CP);
//	}
//
//	public String getVille() {
//		return this.address.getVille();
//	}
//
//	public void setVille(String ville) {
//		this.address.setVille(ville);
//	}
//
//	public String getTelephone() {
//		return telephone;
//	}
//
//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
//	}
//
//	public String getSexe() {
//		return sexe;
//	}
//
//	public void setSexe(String sexe) {
//		this.sexe = sexe;
//	}
//
//	public String getFumeur() {
//		return fumeur;
//	}
//
//	public void setFumeur(String fumeur) {
//		this.fumeur = fumeur;
//	}
//
//	public Adresse2D getAddress() {
//		return address;
//	}
//
//	public void setAddress(Adresse2D address) {
//		this.address = address;
//	}
//
//
//
//}

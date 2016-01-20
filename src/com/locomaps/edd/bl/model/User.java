package com.locomaps.edd.bl.model;

public class User {

	private String nomUtil;
	private String prenomUtil;
	private String pseudo;
	private String email;
	private String password;
	private String confirmPassword;
	
	private String adresse1;
	private String adresse2;
	private String CP;
	private String ville;
	
	private Adresse2D address;
	
	private String telephone;
	private String sexe;
	private String fumeur;

	/**
	 * constructeur User
	 */
	public User()
	{
		
	}
	
	/**
	 * Constructeur User avec adresse du profil
	 * @param nomUtil
	 * @param prenomUtil
	 * @param pseudo
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @param adresse1
	 * @param adresse2
	 * @param CP
	 * @param ville
	 * @param telephone
	 * @param sexe
	 * @param fumeur
	 */
	public User(String nomUtil, String prenomUtil, String pseudo, String email, String password, String confirmPassword,
			String adresse1, String adresse2, String CP, String ville, String telephone, String sexe, String fumeur) {
		super();
		this.nomUtil = nomUtil;
		this.prenomUtil = prenomUtil;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.CP = CP;
		this.ville = ville;
		this.telephone = telephone;
		this.sexe = sexe;
		this.fumeur = fumeur;
	}
	
	
	/**
	 * Constructeur User avec adresse Geocodée
	 * @param nomUtil
	 * @param prenomUtil
	 * @param pseudo
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @param address
	 * @param telephone
	 * @param sexe
	 * @param fumeur
	 */
	public User(String nomUtil, String prenomUtil, String pseudo, String email, String password, String confirmPassword,
			Adresse2D address, String telephone, String sexe, String fumeur) {
		super();
		this.nomUtil = nomUtil;
		this.prenomUtil = prenomUtil;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.telephone = telephone;
		this.sexe = sexe;
		this.fumeur = fumeur;
	}

	public String getNomUtil() {
		return nomUtil;
	}
	
	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}
	
	public String getPrenomUtil() {
		return prenomUtil;
	}
	
	public void setPrenomUtil(String prenomUtil) {
		this.prenomUtil = prenomUtil;
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
	
	public String getAdresse1() {
		return adresse1;
	}
	
	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}
	
	public String getAdresse2() {
		return adresse2;
	}
	
	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}
	
	public String getCP() {
		return CP;
	}
	
	public void setCP(String CP) {
		this.CP = CP;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getSexe() {
		return sexe;
	}
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public String getFumeur() {
		return fumeur;
	}
	
	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}

	
	public Adresse2D getAddress() {
		return address;
	}

	public void setAddress(Adresse2D address) {
		this.address = address;
	}
	
}

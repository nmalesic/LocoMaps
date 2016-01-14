package com.locomaps.edd.bl.model;

public class User {

	public User(String nomUtil, String prenomUtil, String email, String password, String confirmPassword,
			String adresse1, String adresse2, String CP, String ville) {
		super();
		this.nomUtil = nomUtil;
		this.prenomUtil = prenomUtil;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.CP = CP;
		this.ville = ville;
	}
	private String nomUtil;
	private String prenomUtil;
	private String email;
	private String password;
	private String confirmPassword;
	private String adresse1;
	private String adresse2;
	private String CP;
	private String ville;
	
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
		CP = CP;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}


	
}

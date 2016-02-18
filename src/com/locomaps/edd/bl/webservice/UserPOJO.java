package com.locomaps.edd.bl.webservice;

import java.io.Serializable;

public class UserPOJO implements Serializable{

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
	    public UserPOJO() {

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
	    public UserPOJO(String lastName, String firstName, String pseudo, String email, String password, String confirmPassword,
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

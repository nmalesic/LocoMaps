package com.locomaps.edd.bl.model;

/**
 * coordonnée latitude et longitude au format google maps
 * correspondant
 * à une adresse saisie en zone de recherche 
 * ou au format adresse saisie dans le profil utilisateur
 * @author nmalesic
 *
 */
public class Adresse2D {

	private TypeAddress typeAddress2D;
	private boolean geocode = false;
	
	// adresse saisie dans le profil
	private String adresse1;
	private String adresse2;
	private String CP;
	private String ville;
	
	// adresse saisie en zone de recherche
	private String addressSaisie;

	// addresse google maps
	private GoogleGeoCodeResponse gcoord;
	
	public Adresse2D(String adresse1, String adresse2, String CP, String ville, GoogleGeoCodeResponse gcoord) {
		super();
		setTypeAddress2D(TypeAddress.PROFIL);
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.CP = CP;
		this.ville = ville;
		this.gcoord = gcoord;
		setGeocode(gcoord != null); 
		
	}
	
	public Adresse2D(String addressSaisie, GoogleGeoCodeResponse gcoord) {
		super();
		setTypeAddress2D(TypeAddress.RECHERCHE);
		this.addressSaisie = addressSaisie;
		this.gcoord = gcoord;
		setGeocode(gcoord != null); 
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

	public GoogleGeoCodeResponse getGcoord() {
		return gcoord;
	}

	public void setGcoord(GoogleGeoCodeResponse gcoord) {
		this.gcoord = gcoord;
		setGeocode(gcoord != null);
	}
	
	public String getAddressSaisie() {
		return addressSaisie;
	}

	public void setAddressSaisie(String addressSaisie) {
		this.addressSaisie = addressSaisie;
	}
	

	public TypeAddress getTypeAddress2D() {
		return typeAddress2D;
	}

	public void setTypeAddress2D(TypeAddress typeAddress2D) {
		this.typeAddress2D = typeAddress2D;
	}
	
	/**
	 * l'adresse est-elle géocodée ?
	 * @return
	 */
	public boolean isGeocode() {
		return geocode;
	}

	private void setGeocode(boolean geocode) {
		this.geocode = geocode;
	}
}

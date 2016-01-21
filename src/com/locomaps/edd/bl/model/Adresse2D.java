package com.locomaps.edd.bl.model;

/**
 * coordonn�e latitude et longitude au format google maps
 * correspondant
 * � une adresse saisie en zone de recherche 
 * ou au format adresse saisie dans le profil utilisateur
 * @author nmalesic
 *
 */
public class Adresse2D {

	private TypeAddress typeAddress2D;
	private boolean geocode = false;
	
	// adresse saisie dans le profil
	private int id;
	private String adresse1;
	private String adresse2;
	private String CP;
	private String ville;
	private String result;
	
	// adresse saisie en zone de recherche
	private String addressSaisie;

	private Location location;
	
	// addresse google maps
	private GoogleGeoCodeResponse gcoord;
	
	public Adresse2D(String adresse1, String adresse2, String CP, String ville, GoogleGeoCodeResponse gcoord,String result) {
		super();
		setTypeAddress2D(TypeAddress.PROFIL);
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.CP = CP;
		this.ville = ville;
		this.gcoord = gcoord;
		setGeocode(gcoord != null);
		this.result = result;
		
	}
	
	public Adresse2D(String addressSaisie, GoogleGeoCodeResponse gcoord) {
		super();
		setTypeAddress2D(TypeAddress.RECHERCHE);
		this.addressSaisie = addressSaisie;
		this.gcoord = gcoord;
		setGeocode(gcoord != null); 
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * l'adresse est-elle g�ocod�e ?
	 * @return
	 */
	public boolean isGeocode() {
		return geocode;
	}

	private void setGeocode(boolean geocode) {
		this.geocode = geocode;
	}
}

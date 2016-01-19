package com.locomaps.edd.bl.model;

/**
 * coordonnée latitude et longitude correspondant
 * à une adresse au format google maps
 * et à une adresse saisie en zone de recherche 
 * ou au format adresse saisie dans le profil utilisateur
 * 
 * format utile pour stockage en base de données
 * 
 * @author nmalesic
 *
 */
public class Address1D {
	
	// coordonnées google maps
	private String lat;
	private String lng;
    
	// addresse google maps
	private String formatted_address ;
	private String place_id;
	
	/*location_type = {  "ROOFTOP": "The returned result reflects a precise geocode.",
			  "RANGE_INTERPOLATED": "The returned result reflects an approximation (usually on a road) interpolated between two precise points (such as intersections). Interpolated results are generally returned when rooftop geocodes are unavilable for a street address.",
			  "GEOMETRIC_CENTER": "The returned result is the geometric center of a result such a line (e.g. street) or polygon (region).",
			  "APPROXIMATE": "The returned result is approximate."
			}    */
	private String location_type;
	
	private String bounds_lat;
	private String bounds_lng;
	
	private String viewport_northeast_lat;
	private String viewport_northeast_lng;
	private String viewport_southwest_lat;
	private String viewport_southwest_lng;
	
	
	// adresse saisie en zone de recherche
	private String addressSaisie;
	
	// adresse saisie dans le profil
	private String adresse1;
	private String adresse2;
	private String CP;
	private String ville;
	
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public String getBounds_lat() {
		return bounds_lat;
	}
	public void setBounds_lat(String bounds_lat) {
		this.bounds_lat = bounds_lat;
	}
	public String getBounds_lng() {
		return bounds_lng;
	}
	public void setBounds_lng(String bounds_lng) {
		this.bounds_lng = bounds_lng;
	}
	public String getViewport_northeast_lat() {
		return viewport_northeast_lat;
	}
	public void setViewport_northeast_lat(String viewport_northeast_lat) {
		this.viewport_northeast_lat = viewport_northeast_lat;
	}
	public String getViewport_northeast_lng() {
		return viewport_northeast_lng;
	}
	public void setViewport_northeast_lng(String viewport_northeast_lng) {
		this.viewport_northeast_lng = viewport_northeast_lng;
	}
	public String getViewport_southwest_lat() {
		return viewport_southwest_lat;
	}
	public void setViewport_southwest_lat(String viewport_southwest_lat) {
		this.viewport_southwest_lat = viewport_southwest_lat;
	}
	public String getViewport_southwest_lng() {
		return viewport_southwest_lng;
	}
	public void setViewport_southwest_lng(String viewport_southwest_lng) {
		this.viewport_southwest_lng = viewport_southwest_lng;
	}
	
	public String getAddressSaisie() {
		return addressSaisie;
	}
	public void setAddressSaisie(String addressSaisie) {
		this.addressSaisie = addressSaisie;
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
	public void setCP(String cP) {
		CP = cP;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

}

package edu.mum.cs544assignments.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {	
	private String country;
	private String state;
	private String city;
	private String zip;
	
	public Address (){
		
	}
	
	public Address(String country, String state, String city, String zip){
		this.country = country;
		this.state = state;
		this.city = city;
		this.zip = zip;
		
	}
	
	//Getters and setters
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	

}

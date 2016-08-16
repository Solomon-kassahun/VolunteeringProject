package edu.mum.cs544assignments.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Beneficiary {
	@Id
	@GeneratedValue
	private int id;	
	
	private String name;
	
	@Lob
	private byte[] benPicture;
	
	@Embedded
	private Address address;
	
	@ManyToOne
	@JoinColumn
	private Project project;
	

	public Beneficiary(){}
	
	public Beneficiary(String name){
		this.name = name;
	}
	//Getters and Setters

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the benPicture
	 */
	public byte[] getBenPicture() {
		return benPicture;
	}

	/**
	 * @param benPicture the benPicture to set
	 */
	public void setBenPicture(byte[] benPicture) {
		this.benPicture = benPicture;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	
	
}

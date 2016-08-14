package edu.mum.cs544assignments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Beneficiary {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Person person;
	private String benNum;
	@ManyToOne
	@JoinColumn
	private Project project;
	
	public Beneficiary(){
		
	}
	public Beneficiary(Person person){
		this.person = person;
	}
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
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		person.setId(id);
		this.person = person;
	}
	/**
	 * @return the benNum
	 */
	public String getBenNum() {
		return benNum;
	}
	/**
	 * @param benNum the benNum to set
	 */
	public void setBenNum(String benNum) {
		this.benNum = benNum;
	}
	
}

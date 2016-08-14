/**
 * 
 */
package edu.mum.cs544assignments.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
@DiscriminatorValue("HR")
public class HumanResource extends Resource{
	@OneToOne
	@JoinColumn
	private Person person;
	@OneToMany
	private List<Skill> skills;
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
		this.person = person;
	}
	/**
	 * @return the skill
	 */
	public List<Skill> getSkills() {
		return skills;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
}

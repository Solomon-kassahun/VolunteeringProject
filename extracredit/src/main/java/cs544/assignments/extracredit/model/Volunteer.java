/**
 * 
 */
package cs544.assignments.extracredit.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
@DiscriminatorValue("HR")
public class Volunteer extends Resource{
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Person person;
	
	@ElementCollection
	private Map<String, String> skills;
	
	public Volunteer(){
		type = ResourceType.VOLUNTEER;
		skills = new HashMap<>();
	}
	
	public Volunteer(Person person){
		this();
		this.person = person;
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
		this.person = person;
	}
	/**
	 * @return the skill
	 */
	public Map<String, String> getSkills() {
		return skills;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkills(Map<String, String> skills) {
		this.skills = skills;
	}
	
	
}

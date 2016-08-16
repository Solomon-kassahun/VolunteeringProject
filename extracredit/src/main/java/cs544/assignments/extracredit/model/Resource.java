/**
 * 
 */
package cs544.assignments.extracredit.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="resource_type", discriminatorType=DiscriminatorType.STRING)
@Table(name="Resources")
public class Resource {
	@Id
	@GeneratedValue
	private int id;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	protected ResourceType type;
	
	@ManyToOne
	@JoinColumn
	private Task task;
	
	//Getters and setters	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}
	/**
	 * @param task the task to set
	 */
	public void setTask(Task task) {
		this.task = task;
	}
	/**
	 * @return the type
	 */
	public ResourceType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ResourceType type) {
		this.type = type;
	}
	
	
	

}

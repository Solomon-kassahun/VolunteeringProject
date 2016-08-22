/**
 * 
 */
package cs544.assignments.extracredit.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
@Table(name="Tasks")
public class Task {
	@Id
	@GeneratedValue
	private int id;
	
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private String resourcesNeeded;
	
	@ManyToOne
	@JoinColumn
	private Project project;
	
	@Lob
	private byte[] taskPicture;
	
	public Task(){}
	
	public Task(String description){
		this.description = description;
	}
	
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
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
	
		
	/**
	 * @return the taskPicture
	 */
	public byte[] getTaskPicture() {
		return taskPicture;
	}
	/**
	 * @param taskPicture the taskPicture to set
	 */
	public void setTaskPicture(byte[] taskPicture) {
		this.taskPicture = taskPicture;
	}	
	//End of getters and setters
	
	
	@Override
	public String toString(){
		return String.format("Task description: %s\nProject: %s\nTask start date: %s\nTask end date: %s\n", description, project.getName(), startDate, endDate);
	}

	/**
	 * @return the resourcesNeeded
	 */
	public String getResourcesNeeded() {
		return resourcesNeeded;
	}

	/**
	 * @param resourcesNeeded the resourcesNeeded to set
	 */
	public void setResourcesNeeded(String resourcesNeeded) {
		this.resourcesNeeded = resourcesNeeded;
	}

		
	
}

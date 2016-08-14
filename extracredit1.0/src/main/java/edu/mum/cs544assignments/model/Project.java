/**
 * 
 */
package edu.mum.cs544assignments.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
public class Project {
	@Id
	@GeneratedValue
	private int id;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Enumerated
	private Status status;
	@OneToOne
	@JoinColumn(name="project_admin")
	private User projectAdmin;
	@OneToMany(mappedBy="project")
	private List<User> volunteers;
	@OneToMany(mappedBy="project")
	private List<Beneficiary> beneficiaries;
	@OneToMany(mappedBy="project")
	private List<Task> tasks;
	
	public Project(){
		
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
	 * @return the projectAdmin
	 */
	public User getProjectAdmin() {
		return projectAdmin;
	}

	/**
	 * @param projectAdmin the projectAdmin to set
	 */
	public void setProjectAdmin(User projectAdmin) {
		this.projectAdmin = projectAdmin;
	}

	/**
	 * @return the tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void addTask(Task task){
		if(tasks == null){
			tasks = new ArrayList<Task>();
		}
		tasks.add(task);
	}
	
	public void addBeneficiary(Beneficiary beneficiary){
		if(beneficiaries == null){
			beneficiaries = new ArrayList<Beneficiary>();
		}
		beneficiaries.add(beneficiary);
	}
	
	public void addVolunteer(User volunteer){
		if(volunteers == null){
			volunteers = new ArrayList<User>();
		}
		volunteer.setRole(UserRole.VOLUNTEER);
		volunteers.add(volunteer);
	}
	
	
}

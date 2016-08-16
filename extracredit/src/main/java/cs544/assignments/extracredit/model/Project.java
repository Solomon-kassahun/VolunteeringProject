/**
 * 
 */
package cs544.assignments.extracredit.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
@Table(name="Projects")
public class Project {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String description;
	
	@Lob
	private byte[] projPicture;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private String location;
	
	@ElementCollection	
	private List<String> keywords;
	
	@ElementCollection
	private List<String> resourceTypesNeeded;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<User> projectAdmins;
	
	@OneToMany(mappedBy="project", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<User> volunteers;
	
	@OneToMany(mappedBy="project", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Beneficiary> beneficiaries;
	
	@OneToMany(mappedBy="project", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Task> tasks;
	
	public Project(){
		projectAdmins = new ArrayList<>();
		volunteers = new ArrayList<>();
		tasks = new ArrayList<>();
		beneficiaries = new ArrayList<>();
		keywords = new ArrayList<>();
		resourceTypesNeeded = new ArrayList<>();
	}
	
	public Project(String name){
		this();
		this.name = name;
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * @return the keywords
	 */
	public List<String> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the resourceTypesNeeded
	 */
	public List<String> getResourceTypesNeeded() {
		return resourceTypesNeeded;
	}

	/**
	 * @param resourceTypesNeeded the resourceTypesNeeded to set
	 */
	public void setResourceTypesNeeded(List<String> resourceTypesNeeded) {
		this.resourceTypesNeeded = resourceTypesNeeded;
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
	 * @return the projPicture
	 */
	public byte[] getProjPicture() {
		return projPicture;
	}

	/**
	 * @param projPicture the projPicture to set
	 */
	public void setProjPicture(byte[] projPicture) {
		this.projPicture = projPicture;
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
	 * @return the projectAdmins
	 */
	public List<User> getProjectAdmins() {
		return projectAdmins;
	}

	/**
	 * @param projectAdmins the projectAdmins to set
	 */
	public void setProjectAdmins(List<User> projectAdmins) {
		this.projectAdmins = projectAdmins;
	}

	/**
	 * @return the volunteers
	 */
	public List<User> getVolunteers() {
		return volunteers;
	}

	/**
	 * @param volunteers the volunteers to set
	 */
	public void setVolunteers(List<User> volunteers) {
		this.volunteers = volunteers;
	}

	/**
	 * @return the beneficiaries
	 */
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	/**
	 * @param beneficiaries the beneficiaries to set
	 */
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
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
	//End of getters and setters
	
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
	
	public void addProjAdmin(User admin){
		if(projectAdmins == null){
			projectAdmins = new ArrayList<User>();
		}
		admin.setRole(UserRole.ADMINISTRATOR);
		projectAdmins.add(admin);
	}
	
	@Override
	public String toString(){
		return String.format("Project name: %s\nProject location: %s\nStart date: %s\nEnd date: %s\n", 
				name, location, startDate, endDate);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;		
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}	
	
}

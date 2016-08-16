/**
 * 
 */
package cs544.assignments.extracredit.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
@DiscriminatorValue("User")
public class User extends Person{
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;
	
	public User(){
		
	}
	
	public User(String fName, String lName, UserRole role){
		super(fName, lName);
		this.role = role;		
	}
	
	/**
	 * @return the role
	 */
	public UserRole getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(UserRole role) {
		this.role = role;
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

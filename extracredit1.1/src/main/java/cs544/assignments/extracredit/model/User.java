/**
 * 
 */
package cs544.assignments.extracredit.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Solomon Kassahun
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;
	
	public User(){
		
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

package cs544.assignments.extracredit.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import cs544.assignments.extracredit.model.Address;
import cs544.assignments.extracredit.model.Beneficiary;
import cs544.assignments.extracredit.model.Project;
import cs544.assignments.extracredit.model.ResourceType;
import cs544.assignments.extracredit.model.Status;
import cs544.assignments.extracredit.model.Task;
import cs544.assignments.extracredit.model.User;
import cs544.assignments.extracredit.model.UserRole;
import cs544.assignments.extracredit.model.Volunteer;

public class ProjectDAO {
	public void persist(Project project) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(project);
			System.out.println("Persisted project: "+project);
			tx.commit();

		} catch (PersistenceException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
	
	public Project findProjectById(int projId){
		EntityManager em = JpaUtil.getEntityManager();		
		Query query = em.createQuery("SELECT p FROM Project p WHERE p.id = :projId");
		query.setParameter("projId", projId);
		List<Project> results = findProjectByQuery(em, query);
		if(results != null && results.size() > 0)
			return results.get(0);
		else return null;
	}
	
	public void listProjects(){
		EntityManager em = JpaUtil.getEntityManager();
		List<Project> projects = null;
		Query query = em.createQuery("FROM Project");
		projects = findProjectByQuery(em, query);
		for(Project proj : projects){
			String projDescr = String.format("Project name: %s \nProject location: %s \nProject description: %s\n"
					+ "Project beneficiaries: %s\n", proj.getName(), proj.getLocation(), proj.getDescription(), proj.getBeneficiaries());
			System.out.println(projDescr);
		}
	}

	public List<Project> findProjectByStatus(Status status) {
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Project p WHERE p.status = :status");
		query.setParameter("status", status);
		return findProjectByQuery(em, query);

	}
	public List<Project> findProjectByLocation(String city) {
		city = city.toUpperCase();
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Project p WHERE p.location = :city");
		query.setParameter("city", city);
		return findProjectByQuery(em, query);

	}
	
	public List<Project> findProjectByKeyword(String keyword) {
		EntityManager em = JpaUtil.getEntityManager();
		keyword.toUpperCase();
		Query query = em.createQuery("SELECT p FROM Project p WHERE :keyword MEMBER OF p.keywords");
		query.setParameter("keyword", keyword);
		return findProjectByQuery(em, query);

	}
	
	public List<Project> findProjectByResourceType(String resourceType) {
		resourceType = resourceType.toUpperCase();
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Project p WHERE :resourceType MEMBER OF p.keywords");
		query.setParameter("resourceType", resourceType);
		return findProjectByQuery(em, query);

	}
	
	
	
	public List<Project> findProjectByQuery(EntityManager em, Query query){		
		EntityTransaction tx = null;
		List<Project> projects = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			projects = query.getResultList();
			tx.commit();

		} catch (PersistenceException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}

		} finally {
			em.close();
		}
		return projects;		
	}
	
	public List<Task> getProjectTasks(Project project){
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("SELECT t FROM Task t WHERE t.project = :project");
		query.setParameter("project", project);		
		return findTaskByQuery(em, query);		
	}
	
	public List<Task> getTasksHavingVolunteers(){
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("SELECT t FROM Task t JOIN t.resources r WHERE r.type  = :resType ORDER BY t.startDate");
		query.setParameter("resType", ResourceType.VOLUNTEER);		
		return findTaskByQuery(em, query);		
	}
	
	public List<Task> findTaskByQuery(EntityManager em, Query query){		
		EntityTransaction tx = null;
		List<Task> tasks = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			tasks = query.getResultList();
			tx.commit();

		} catch (PersistenceException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}

		} finally {
			em.close();
		}
		return tasks;		
	}
	
	//Populate database
	public Project createSampleProject() throws ParseException{
		User admin = new User("admin", "admin", UserRole.ADMINISTRATOR);
		User user1 = new User("vol1FName", "vol1LName", UserRole.VOLUNTEER);
		Volunteer vol1 = new Volunteer(user1);
		User user2 = new User("vol2FName", "vol2LName", UserRole.VOLUNTEER);
		Volunteer vol2 = new Volunteer(user2);
		Beneficiary ben1 = new Beneficiary("Fairfield city municipality");
		ben1.setAddress(new Address("USA", "IA", "Fairfield", "52556"));
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Project project1 = new Project("Beautify Fairfield");
		project1.setStartDate(df.parse("01/09/2016"));
		project1.setEndDate(df.parse("30/12/2016"));
		project1.addProjAdmin(admin);
		project1.setLocation("FAIRFIELD");
		project1.setDescription("The aim is to create sustainable and neat living environment");
		ArrayList<String> projKeywords = new ArrayList<>();
		Arrays.asList(new String[]{"PLANTING", "TREE", "CLEANING", "SUSTAINABLE"}, projKeywords);
		project1.setKeywords(projKeywords);
		ArrayList<String> resourcesNeeded = new ArrayList<>();
		Arrays.asList(new String[]{"VOLUNTEER", "DIGGING TOOL", "TRUCK"}, resourcesNeeded);
		project1.setResourceTypesNeeded(resourcesNeeded);
		project1.addBeneficiary(ben1);
		Task task1 = new Task("Plant trees around the city");		
		task1.setStartDate(df.parse("01/09/2016"));
		task1.setStartDate(df.parse("30/09/2016"));
		task1.setStatus(Status.NOT_STARTED);
		task1.addResource(vol1);
		Task task2 = new Task("Collect littered plastic bottles and cans in city parks");		
		task2.setStartDate(df.parse("01/10/2016"));
		task2.setStartDate(df.parse("30/10/2016"));
		task2.setStatus(Status.NOT_STARTED);
		task2.addResource(vol2);
		project1.addTask(task1);
		project1.addTask(task2);
		project1.setStatus(Status.NOT_STARTED);	
		return project1;
	}

}

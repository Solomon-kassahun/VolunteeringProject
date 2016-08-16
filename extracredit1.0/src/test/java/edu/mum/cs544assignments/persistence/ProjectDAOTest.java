package edu.mum.cs544assignments.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.mum.cs544assignments.model.Project;
import edu.mum.cs544assignments.model.Status;
import edu.mum.cs544assignments.model.Task;
import junit.framework.Assert;

public class ProjectDAOTest {
	
	private static ProjectDAO projDAO;
	private static Project sampleProject;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		projDAO = new ProjectDAO();
		sampleProject = projDAO.createSampleProject();
	}	

	@Test
	public void testPersist() {
		projDAO.persist(sampleProject);
		Project result = projDAO.findProjectById(sampleProject.getId());
		assertEquals(result, sampleProject);
	}

	@Test
	public void testListProjects() {
		//Print out list of projects. Nothing special to test
		projDAO.listProjects();
		assertTrue(true);
	}

	@Test
	public void testFindProjectByStatus() {
		//Make sure we have project with status NOT_STARTED, but not with status COMPLETED
		List<Project> results = projDAO.findProjectByStatus(Status.COMPLETED);
		assertTrue(results.isEmpty());
		results = projDAO.findProjectByStatus(Status.NOT_STARTED);
		assertFalse(results.isEmpty());
	}

	@Test
	public void testFindProjectByLocation() {
		//Make sure we have project in Fairfield, but not in Ottumwa
		List<Project> results = projDAO.findProjectByLocation("Ottumwa");
		assertTrue(results.isEmpty());
		results = projDAO.findProjectByLocation("Fairfield");
		assertFalse(results.isEmpty());
	}

	@Test
	public void testFindProjectByKeyword() {
		//Make sure we have project with keyword SUSTAINABLE, but not with POLLUTION
		List<Project> results = projDAO.findProjectByKeyword("POLLUTION");
		assertTrue(results.isEmpty());
		results = projDAO.findProjectByKeyword("SUSTAINABLE");
		assertFalse(results.isEmpty());
	}

	@Test
	public void testFindProjectByResourceType() {
		//Make sure we have project with resource type VOLUNTEER, but not with EMPLOYEE
		List<Project> results = projDAO.findProjectByResourceType("EMPLOYEE");
		assertTrue(results.isEmpty());
		results = projDAO.findProjectByResourceType("VOLUNTEER");
		assertFalse(results.isEmpty());
	}	

	@Test
	public void testGetProjectTasks() {
		List<Task> result = projDAO.getProjectTasks(sampleProject);
		assertTrue(result.size() == sampleProject.getTasks().size());
		for(Task task : result){
			assertTrue(sampleProject.getTasks().contains(task));
		}
	}

	@Test
	public void testGetTasksHavingVolunteers() {
		List<Task> result = projDAO.getTasksHavingVolunteers();
		assertTrue(result.size() == 2);
	}

}

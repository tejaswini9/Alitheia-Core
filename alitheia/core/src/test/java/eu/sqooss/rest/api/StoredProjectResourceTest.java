package eu.sqooss.rest.api;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import eu.sqooss.service.db.ProjectFile;
import eu.sqooss.service.db.ProjectVersion;
import eu.sqooss.service.db.StoredProject;

public class StoredProjectResourceTest {
	
	private DummyStoredProjectResource dummyStoredProjectResource;
	
	@Before
	public void setUp() {
		dummyStoredProjectResource = new DummyStoredProjectResource();
	}
	
	@Test
	public void testStoredProjectResource() {
		assertThat(null, not(dummyStoredProjectResource));
	}
	
	@Test
	public void testGetProjects() {
		StoredProject storedProject = dummyStoredProjectResource.getProjects().get(0);
		assertEquals(1, storedProject.getId());
	}
	
	@Test
	public void testGetProject() {
		StoredProject storedProject = dummyStoredProjectResource.getProject("");
		assertEquals(1, storedProject.getId());
	}
	
	@Test
	public void testGetAllVersions() {
		ProjectVersion projectVersion = dummyStoredProjectResource.getAllVersions((long) 1).get(0);
		assertEquals(1, projectVersion.getId());
	}
	
	@Test
	public void testGetVersions() {
		ProjectVersion projectVersion = dummyStoredProjectResource.getVersions((long) 1, "").get(0);
		assertEquals(1, projectVersion.getId());
	}
	
	@Test
	public void testGetVersion() {
		ProjectVersion projectVersion = dummyStoredProjectResource.getVersion("", "");
		assertEquals(1, projectVersion.getId());
	}
	
	@Test
	public void testGetAllFiles() {
		ProjectFile projectFile = dummyStoredProjectResource.getAllFiles("", "").get(0);
		assertEquals(1, projectFile.getId());
	}
	
	@Test
	public void testGetFilesInDir() {
		ProjectFile projectFile = dummyStoredProjectResource.getFilesInDir("", "", "").get(0);
		assertEquals(1, projectFile.getId());
	}
	
	@Test
	public void testGetChangedFiles() {
		Set<ProjectFile> set = dummyStoredProjectResource.getChangedFiles("", "");
		assertEquals(1, set.size());
	}
	
	@Test
	public void testGetDirs2Param() {
		ProjectFile projectFile = dummyStoredProjectResource.getDirs("", "").get(0);
		assertEquals(1, projectFile.getId());
	}
	
	@Test
	public void testGetDirs3Param() {
		ProjectFile projectFile = dummyStoredProjectResource.getDirs("", "", "").get(0);
		assertEquals(1, projectFile.getId());
	}
	
}

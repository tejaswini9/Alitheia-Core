package eu.sqooss.service.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import eu.sqooss.impl.service.db.DummyLogger;
import eu.sqooss.service.cluster.ClusterNodeActionException;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClusterNodeTest {
	
	private DummyClusterNode testClusterNode;
	
	private DummyLogger testLogger;	
	
	private StoredProject testStoredProject;
	
	@Before
	public void setUp() {
		testClusterNode = new DummyClusterNode();
		testLogger = new DummyLogger();
		testStoredProject = mock(StoredProject.class);
	}
	
	@Test
	public void testAssignProjectNullClusterNode() {
		try {
			testClusterNode.assignProject(testLogger, null, testStoredProject);
		} catch (ClusterNodeActionException e) {
			assertEquals("[ClusterNode] Request to assign a project to a null clusternode", e.getMessage());
		}		
	}
	
	@Test
	public void testAssignProjectNullStoredProject() {
		try {
			testClusterNode.assignProject(testLogger, testClusterNode, null);
		} catch (ClusterNodeActionException e) {
			assertEquals("[ClusterNode] Request to assign a null project to a clusternode", e.getMessage());
		}		
	}
	
	@Test
	public void testAssignProjectClusterNodeInProjectNull() {
		try {
			boolean assignProject = testClusterNode.assignProject(testLogger, testClusterNode, testStoredProject);
			
			assertEquals("Assigning project null to null", testLogger.getMessage());
			assertTrue(assignProject);
		} catch (ClusterNodeActionException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testAssignProjectClusterNodeInProject() {
		when(testStoredProject.getClusternode()).thenReturn(testClusterNode);
		
		try {
			boolean assignProject = testClusterNode.assignProject(testLogger, testClusterNode, testStoredProject);
			
			assertEquals("No need to move null - Already assigned!", testLogger.getMessage());
			assertTrue(assignProject);
		} catch (ClusterNodeActionException e) {
			e.printStackTrace();
		}		
	}
	
}
package eu.sqooss.service.db;

import java.util.HashSet;
import java.util.Set;

public class DummyClusterNode extends ClusterNode {
	
	private StoredProject storedProject;
	
	public DummyClusterNode() {}
	
	@Override
	public Set<StoredProject> getProjects() {
		HashSet<StoredProject> set = new HashSet<StoredProject>();
		storedProject = new StoredProject();
		set.add(storedProject);
		
		return set;
	}
	
}
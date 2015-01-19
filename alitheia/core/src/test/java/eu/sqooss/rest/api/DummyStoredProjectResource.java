package eu.sqooss.rest.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.PathParam;

import eu.sqooss.service.db.ProjectFile;
import eu.sqooss.service.db.ProjectVersion;
import eu.sqooss.service.db.StoredProject;

public class DummyStoredProjectResource extends StoredProjectResource {
	
	public DummyStoredProjectResource() {}
	
	@Override
	public List<StoredProject> getProjects() {
		ArrayList<StoredProject> list = new ArrayList<StoredProject>();
		StoredProject storedProject = new StoredProject();
		storedProject.setId(1);
		list.add(storedProject);
		
		return list;
	}
	
	@Override
	public StoredProject getProject(@PathParam("id") String id) {
		StoredProject storedProject = new StoredProject();
		storedProject.setId(1);
		
		return storedProject;
	}
	
	@Override
	public List<ProjectVersion> getAllVersions(@PathParam("id") Long id) {
		ArrayList<ProjectVersion> list = new ArrayList<ProjectVersion>();
		ProjectVersion projectVersion = new ProjectVersion();
		projectVersion.setId(1);
		list.add(projectVersion);
		
		return list;
	}
	
	@Override
	public List<ProjectVersion> getVersions(@PathParam("id") Long id,
			@PathParam("vid") String vid) {
		ArrayList<ProjectVersion> list = new ArrayList<ProjectVersion>();
		ProjectVersion projectVersion = new ProjectVersion();
		projectVersion.setId(1);
		list.add(projectVersion);
		
		return list;
	}
	
	@Override
	public ProjectVersion getVersion(@PathParam("id") String prid,
			@PathParam("vid") String verid) {
		ProjectVersion projectVersion = new ProjectVersion();
		projectVersion.setId(1);
		
		return projectVersion;
	}
	
	@Override
	public List<ProjectFile> getAllFiles(@PathParam("id") String prid,
            @PathParam("vid") String verid) {
		ArrayList<ProjectFile> list = new ArrayList<ProjectFile>();
		ProjectFile projectFile = new ProjectFile();
		projectFile.setId(1);
		list.add(projectFile);
		
		return list;
	}
	
	@Override
	public List<ProjectFile> getFilesInDir(@PathParam("id") String prid,
            @PathParam("vid") String verid,
            @PathParam("dir") String path) {
		ArrayList<ProjectFile> list = new ArrayList<ProjectFile>();
		ProjectFile projectFile = new ProjectFile();
		projectFile.setId(1);
		list.add(projectFile);
		
		return list;
	}
	
	@Override
	public Set<ProjectFile> getChangedFiles(@PathParam("id") String prid,
            @PathParam("vid") String verid) {
		Set<ProjectFile> set = new HashSet<ProjectFile>();
		ProjectFile projectFile = new ProjectFile();
		projectFile.setName("");
		set.add(projectFile);
		
		return set;
	}
	
	@Override
	public List<ProjectFile> getDirs(@PathParam("id") String prid,
            @PathParam("vid") String verid) {
		ArrayList<ProjectFile> list = new ArrayList<ProjectFile>();
		ProjectFile projectFile = new ProjectFile();
		projectFile.setId(1);
		list.add(projectFile);
		
		return list;
	}
	
	@Override
	public List<ProjectFile> getDirs(@PathParam("id") String prid,
	           @PathParam("vid") String verid,
	           @PathParam("dir") String path) {
		ArrayList<ProjectFile> list = new ArrayList<ProjectFile>();
		ProjectFile projectFile = new ProjectFile();
		projectFile.setId(1);
		list.add(projectFile);
		
		return list;
	}
	
}
package eu.sqooss.impl.service.updater;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import eu.sqooss.impl.service.cluster.ClusterNodeServiceImpl;
import eu.sqooss.service.cluster.ClusterNodeService;
import eu.sqooss.service.db.StoredProject;
import eu.sqooss.service.logging.Logger;
import eu.sqooss.service.scheduler.Job;
import eu.sqooss.service.scheduler.SchedulerException;
import eu.sqooss.service.updater.MetadataUpdater;
import eu.sqooss.service.updater.Updater;
import eu.sqooss.service.util.BidiMap;

public class DummyUpdaterServiceImpl extends UpdaterServiceImpl {
	
	public DummyUpdaterServiceImpl() {}

	@Override
	public Set<Updater> getUpdaters(StoredProject sp, UpdaterStage st) { 
		HashSet<Updater> set = new HashSet<Updater>();
		return set;
	}
	
	@Override
	public synchronized boolean isUpdateRunning(StoredProject p, Updater u) {
		return false;
	}
	
	@Override
	protected ClusterNodeService getClusterNodeService() {
		ClusterNodeService clusterNodeService = new ClusterNodeServiceImpl();		
		return clusterNodeService;
	}
	
	@Override
	protected void enqueueBlockOfScheduler(List<Job> toQueue) throws SchedulerException {}
	
	@Override
	protected MetadataUpdater getMetadataUpdater(Updater u) throws InstantiationException, IllegalAccessException {
		return null;
	}
	
	@Override
	protected void setUpdateParams(MetadataUpdater upd, StoredProject project, Logger logger) {}
	

    public void setLogger(Logger logger) {
    	this.logger = logger;
    }
    
    public ConcurrentMap<Long,Map<Updater, UpdaterJob>> getScheduledUpdates() {
    	return scheduledUpdates;
    }
    
    public void setScheduledUpdates(ConcurrentMap<Long,Map<Updater, UpdaterJob>> scheduledUpdates) {
    	this.scheduledUpdates = scheduledUpdates;
    }
    
    public List<Job> getJobs() {
    	return jobs;
    }
    
    public void setJobs(List<Job> jobs) {
    	this.jobs = jobs;
    }
    
    public BidiMap<Updater, Job> getToSchedule() {
    	return toSchedule;
    }
    
    public void setToSchedule(BidiMap<Updater, Job> toSchedule) {
    	this.toSchedule = toSchedule;
    }
    
    public DependencyJob getOldDepJob() {
    	return oldDepJob;
    }
    
    public List<Updater> getUpdForStage() {
    	return updForStage;
    }
    
    public void setUpdForStage(List<Updater> updForStage) {
    	this.updForStage = updForStage;
    }
    
    public void setUpdaters(BidiMap<Updater, Class<? extends MetadataUpdater>> updaters) {
    	this.updaters = updaters;
    }
	
}
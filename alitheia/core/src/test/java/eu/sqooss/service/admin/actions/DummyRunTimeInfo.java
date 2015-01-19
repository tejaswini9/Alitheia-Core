package eu.sqooss.service.admin.actions;

import java.util.HashMap;
import java.util.Map;

import eu.sqooss.service.scheduler.SchedulerStats;


public class DummyRunTimeInfo extends RunTimeInfo {
	
	private Map<String, Object> results;
	
	public DummyRunTimeInfo() {
		results = new HashMap<String, Object>();
	}
	
	@Override
	public Map<String, Object> results() {
		return results;
	}
	
	@Override
	public SchedulerStats getSchedulerStats() {
		SchedulerStats  schedulerStats = new SchedulerStats();		
		return schedulerStats;
	}
	
}
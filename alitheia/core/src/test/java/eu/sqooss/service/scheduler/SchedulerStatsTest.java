package eu.sqooss.service.scheduler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import eu.sqooss.service.admin.actions.DummyRunTimeInfo;

public class SchedulerStatsTest {
	
	private SchedulerStats testSchedulerStats;
	
	private DummyRunTimeInfo testRunTimeInfo;
	
	@Before
	public void setUp() {
		testSchedulerStats = new SchedulerStats();
		testRunTimeInfo = new DummyRunTimeInfo();
	}
	
	@Test
	public void testStatsForExecute() throws Exception {
		testSchedulerStats.statsForExecute(testRunTimeInfo);
		
		assertEquals((long) 0, testRunTimeInfo.results().get("sched.jobs.failed"));
		assertEquals((long) 0, testRunTimeInfo.results().get("sched.jobs.wait"));
		assertEquals((long) 0, testRunTimeInfo.results().get("sched.jobs.finished"));
		assertEquals((long) 0, testRunTimeInfo.results().get("sched.threads.idle"));
		assertEquals((long) 0, testRunTimeInfo.results().get("sched.threads.total"));
	}
	
}
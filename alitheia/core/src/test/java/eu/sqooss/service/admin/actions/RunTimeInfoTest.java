package eu.sqooss.service.admin.actions;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import eu.sqooss.service.admin.AdminAction.AdminActionStatus;
import eu.sqooss.service.scheduler.SchedulerStats;

public class RunTimeInfoTest {
	
	private DummyRunTimeInfo testRunTimeInfo;
	
	@Before
	public void setUp() {
		testRunTimeInfo = new DummyRunTimeInfo();
	}
	
	@Test
	public void testGetSchedulerStats() {
		SchedulerStats testSchedulerStats = testRunTimeInfo.getSchedulerStats();
		assertThat(null, not(testSchedulerStats));
	}
	
	@Test
	public void testExecute() {
		try {
			testRunTimeInfo.execute();
			AdminActionStatus expectedStatus = AdminActionStatus.FINISHED;
						
			assertEquals(expectedStatus, testRunTimeInfo.status());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
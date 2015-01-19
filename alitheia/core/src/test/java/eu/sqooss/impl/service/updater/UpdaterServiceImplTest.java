package eu.sqooss.impl.service.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.Before;
import org.junit.Test;

import eu.sqooss.impl.service.db.DummyLogger;
import eu.sqooss.impl.service.updater.UpdaterServiceImpl.DependencyJob;
import eu.sqooss.service.db.DummyStoredProject;
import eu.sqooss.service.scheduler.Job;
import eu.sqooss.service.scheduler.SchedulerException;
import eu.sqooss.service.updater.MetadataUpdater;
import eu.sqooss.service.updater.Updater;
import eu.sqooss.service.updater.UpdaterService.UpdaterStage;
import eu.sqooss.service.util.BidiMap;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UpdaterServiceImplTest {

	private DummyUpdaterServiceImpl testUpdaterServiceImpl;
	
	private DummyStoredProject testStoredProject;
	
	private Updater testUpdater;
	
	private DependencyJob testDependencyJob;
	
	private BidiMap<Updater, Class<? extends MetadataUpdater>> updaters;
	
	private BidiMap<Updater, Job> toSchedule;
	
	private ArrayList<Job> jobs;
	
	@Before
	public void setUp() throws InstantiationException, IllegalAccessException {
		testUpdaterServiceImpl = new DummyUpdaterServiceImpl();
		testStoredProject = new DummyStoredProject();
		testUpdater = mock(Updater.class);
		testDependencyJob = testUpdaterServiceImpl.new DependencyJob();
		toSchedule = new BidiMap<Updater, Job>();
		jobs = new ArrayList<Job>();
		
		when(testUpdater.dependencies()).thenReturn(new String[0]);
		
		ArrayList<Updater> updForStorage = new ArrayList<Updater>();
		updForStorage.add(testUpdater);
		testUpdaterServiceImpl.setUpdForStage(updForStorage);
		
		testUpdaterServiceImpl.setUpdaters(updaters);
		testUpdaterServiceImpl.setToSchedule(toSchedule);
		testUpdaterServiceImpl.setJobs(jobs);		
	}
	
	@Test
	public void testEnqueueJobs() throws SchedulerException {
		jobs.add(testDependencyJob);
		testUpdaterServiceImpl.setJobs(jobs);	
		
		ConcurrentMap<Long,Map<Updater, UpdaterJob>> scheduledUpdates = new ConcurrentHashMap<Long,Map<Updater, UpdaterJob>>();
		testUpdaterServiceImpl.setScheduledUpdates(scheduledUpdates);
		
		testUpdaterServiceImpl.enqueueJobs(testStoredProject);
		
		boolean scheduledUpdatedEmpy = testUpdaterServiceImpl.getScheduledUpdates().isEmpty();
		assertFalse(scheduledUpdatedEmpy);
	}
	
	@Test
	public void testScheduleUpdaters() throws InstantiationException, IllegalAccessException, SchedulerException {
		testUpdaterServiceImpl.scheduleUpdaters(testStoredProject, testUpdater, testDependencyJob);
		
		assertFalse(testUpdaterServiceImpl.getToSchedule().isEmpty());
		assertFalse(testUpdaterServiceImpl.getJobs().isEmpty());
	}
	
	@Test
	public void testSetListOfJobs() {
		List<UpdaterStage> stages = new ArrayList<UpdaterStage>();
		UpdaterStage updaterStage = UpdaterStage.DEFAULT;
		stages.add(updaterStage);
		
		ConcurrentMap<Long,Map<Updater, UpdaterJob>> scheduledUpdates = new ConcurrentHashMap<Long,Map<Updater, UpdaterJob>>();
		testUpdaterServiceImpl.setScheduledUpdates(scheduledUpdates);
		
		testUpdaterServiceImpl.setListOfJobs(stages, testStoredProject, testUpdater);
		
		assertThat(null, not(testUpdaterServiceImpl.getOldDepJob()));
		assertThat(null, not(testUpdaterServiceImpl.getUpdForStage()));
	}
	
	@Test
	public void testUpdate() {
		DummyLogger testLogger = new DummyLogger();
		testUpdaterServiceImpl.setLogger(testLogger);
		
		ConcurrentMap<Long,Map<Updater, UpdaterJob>> scheduledUpdates = new ConcurrentHashMap<Long,Map<Updater, UpdaterJob>>();
		testUpdaterServiceImpl.setScheduledUpdates(scheduledUpdates);
		
		testUpdaterServiceImpl.update(testStoredProject, null, null);
		
		assertEquals("Request to update project:null stage:null updater:null", testLogger.getMessage());
	}
	
}

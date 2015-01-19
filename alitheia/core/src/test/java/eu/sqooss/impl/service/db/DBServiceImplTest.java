package eu.sqooss.impl.service.db;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.QueryException;
import org.junit.Before;
import org.junit.Test;

import eu.sqooss.service.db.DAObject;

public class DBServiceImplTest {
	
	private DummyDBServiceImpl testDBServiceImpl;
	
	private DummyLogger testLogger;	
	
	@Before
	public void setUp() {
		testLogger = new DummyLogger(); 
		testDBServiceImpl = new DummyDBServiceImpl(null, null, testLogger);
	}
	
	@Test
	public void testSubDBServiceImplNoArgs() {
		testDBServiceImpl = new DummyDBServiceImpl();
		assertThat(null, not(testDBServiceImpl));
	}
	
	@Test
	public void testSubDBServiceImpl(){
		assertThat(null, not(testDBServiceImpl));
		assertEquals(testLogger, testDBServiceImpl.logger());
	}
	
	@Test
	public void testGetJDBCConnection() {
		boolean connection = testDBServiceImpl.getJDBCConnection();
		assertFalse(connection);
	}
	
	@Test
	public void testInitHibernate() {
		boolean hibernate = testDBServiceImpl.initHibernate(null);
		assertFalse(hibernate);
	}
	
	@Test
	public void testFindObjectById() {
		DAObject testDAObject = testDBServiceImpl.findObjectById(null, 0);
		assertEquals(1, testDAObject.getId());
	}
	
	@Test
	public void testFindObjectByIdForUpdate() {
		DAObject testDAObject = testDBServiceImpl.findObjectByIdForUpdate(null, 0);
		assertEquals(1, testDAObject.getId());
	}	
	
	@Test
	public void testFindObjectsByProperties() {
		DAObject testDAObject = testDBServiceImpl.findObjectsByProperties(null, null).get(0);
		assertEquals(1, testDAObject.getId());
	}
	
	@Test
	public void testFindObjectsByPropertiesForUpdate() {
		DAObject testDAObject = testDBServiceImpl.findObjectsByPropertiesForUpdate(null, null).get(0);
		assertEquals(1, testDAObject.getId());
	}
	
	@Test
	public void testDoFindObjectsByProperties() {
		DAObject testDAObject = testDBServiceImpl.doFindObjectsByProperties(null, null, false).get(0);
		assertEquals(1, testDAObject.getId());
	}
	
	@Test
	public void testDoSQL() throws SQLException {
		List<?> testList = testDBServiceImpl.doSQL("");
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testDoSQLTwoArgs() throws SQLException {
		List<?> testList = testDBServiceImpl.doSQL("", null);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testCallProcedure() throws QueryException, SQLException {
		assertEquals(1, testDBServiceImpl.callProcedure("", null, null));
	}
	
	@Test
	public void testDoHQL() {
		List<?> testList = testDBServiceImpl.doHQL("");
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testDoHQLTwoArgs() {
		List<?> testList = testDBServiceImpl.doHQL("", null);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testDoHQLThreeArgsInt() {
		List<?> testList = testDBServiceImpl.doHQL("", null, 0);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testDoHQLThreeArgsBool() {
		List<?> testList = testDBServiceImpl.doHQL("", null, false);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testDoHQLThreeArgsObj() {
		List<?> testList = testDBServiceImpl.doHQL("", null, null);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testDoHQLSixArgs() {
		List<?> testList = testDBServiceImpl.doHQL("", null, null, false, 0, 0);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testAddRecord() {
		boolean added = testDBServiceImpl.addRecord(null);
		assertFalse(added);
	}
	
	@Test
	public void testDeleteRecord() {
		boolean deleted = testDBServiceImpl.deleteRecord(null);
		assertFalse(deleted);
	}
	
	@Test
	public void testAddRecords() {
		boolean added = testDBServiceImpl.addRecords(null);
		assertFalse(added);
	}
	
	@Test
	public void testDeleteRecords() {
		boolean deleted = testDBServiceImpl.deleteRecords(null);
		assertFalse(deleted);
	}
	
	@Test
	public void testStartDBSession() {
		boolean started = testDBServiceImpl.startDBSession();
		assertFalse(started);
	}
	
	@Test
	public void testCommitDBSession() {
		boolean commited = testDBServiceImpl.commitDBSession();
		assertFalse(commited);
	}
	
	@Test
	public void testRollbackDBSession() {
		boolean back = testDBServiceImpl.rollbackDBSession();
		assertFalse(back);
	}
	
	@Test
	public void testFlushDBSession() {
		boolean flushed = testDBServiceImpl.flushDBSession();
		assertFalse(flushed);
	}
	
	@Test
	public void testIsDBSessionActive() {
		boolean active = testDBServiceImpl.isDBSessionActive();
		assertFalse(active);
	}
	
	@Test
	public void testAttachObjectToDBService() {
		DAObject testDAObject = testDBServiceImpl.attachObjectToDBSession(null);
		assertEquals(1, testDAObject.getId());
	}
	
	@Test
	public void testExecuteUpdate() {
		int update = testDBServiceImpl.executeUpdate("", null);
		assertEquals(1, update);
	}
	
	@Test
	public void testStartUp() {
		boolean started = testDBServiceImpl.startUp();
		assertFalse(started);
	}
	
	@Test
	public void testShutDown() {
		testDBServiceImpl.shutDown();
		assertFalse(testDBServiceImpl.shutDown);
	}
	
	@Test
	public void testSetInitParams() {
		DummyLogger testLogger = new DummyLogger();
		testDBServiceImpl.setInitParams(null, testLogger);
		
		assertEquals(testLogger, testDBServiceImpl.logger());
	}
	
	@Test
	public void testLogSQLException() {
		testDBServiceImpl.logSQLException(null);
		assertEquals("sqle", testLogger.getMessage());
	}
	
	@Test
	public void testLogExceptionAndTerminateSession() {
		testDBServiceImpl.logExceptionAndTerminateSession(null);
		assertEquals("e", testLogger.getMessage());
	}
	
	@Test
	public void testCheckSession() {
		boolean session = testDBServiceImpl.checkSession();
		assertFalse(session);
	}
	
	@Test
	public void testDoFindObjectById() {
		DAObject testDAObject = testDBServiceImpl.doFindObjectById(null, 0, false);
		assertEquals(1, testDAObject.getId());
	}

}

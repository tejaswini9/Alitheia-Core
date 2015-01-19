package eu.sqooss.service.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class PluginConfigurationTest {
	
	private DummyPluginConfiguration testPluginConfiguration;
	
	private DummyPluginInfo testPluginInfo;
	
	@Before
	public void setUp() {
		testPluginConfiguration = new DummyPluginConfiguration();
		testPluginInfo = new DummyPluginInfo();
	}
	
	@Test
	public void testAddConfigEntryInvalidName() {
		try {
			testPluginConfiguration.addConfigEntry(testPluginInfo, null, "", "", "");
		} catch (Exception e) {
			assertEquals("Invalid name!", e.getMessage());
		}
	}
	
	@Test
	public void testAddConfigEntryInvalidType() {
		try {
			testPluginConfiguration.addConfigEntry(testPluginInfo, "", "", null, "");
		} catch (Exception e) {
			assertEquals("Invalid type!", e.getMessage());
		}
	}
	
	@Test
	public void testAddConfigEntryInvalidConfigType() {
		try {
			testPluginConfiguration.addConfigEntry(testPluginInfo, "", "", "", "");
		} catch (Exception e) {
			assertEquals("Invalid type!", e.getMessage());
		}
	}
	
	@Test
	public void testAddConfigEntryInvalidValue() {
		try {
			testPluginConfiguration.addConfigEntry(testPluginInfo, "", "", "BOOLEAN", null);
		} catch (Exception e) {
			assertEquals("Invalid value!", e.getMessage());
		}
	}
	
	@Test
	public void testAddConfigEntryInvalidBooleanValue() {
		try {
			testPluginConfiguration.addConfigEntry(testPluginInfo, "", "", "BOOLEAN", "");
		} catch (Exception e) {
			assertEquals("Not a valid boolean value!", e.getMessage());
		}
	}
	
	@Test
	public void testAddConfigEntryInvalidIntegerValue() {
		try {
			testPluginConfiguration.addConfigEntry(testPluginInfo, "", "", "INTEGER", "");
		} catch (Exception e) {
			assertEquals("Not a valid integer value!", e.getMessage());
		}
	}
	
	@Test
	public void testAddConfigEntryInvalidDoubleValue() {
		try {
			testPluginConfiguration.addConfigEntry(testPluginInfo, "", "", "DOUBLE", "");
		} catch (Exception e) {
			assertEquals("Not a valid double value!", e.getMessage());
		}
	}
	
	@Test
	public void testAddConfiguration() {
		boolean addConfiguration = testPluginConfiguration.addConfiguration(testPluginInfo, "", "", "", "");
		
		assertFalse(addConfiguration);
	}
	
	@Test
	public void testAddConfigEntry() {
		try {
			boolean addConfigEntry = testPluginConfiguration.addConfigEntry(testPluginInfo, "", "", "BOOLEAN", "false");
			
			assertFalse(addConfigEntry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
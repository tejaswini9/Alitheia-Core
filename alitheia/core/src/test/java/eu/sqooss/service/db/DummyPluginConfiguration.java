package eu.sqooss.service.db;

import eu.sqooss.service.pa.PluginInfo;

public class DummyPluginConfiguration extends PluginConfiguration {
	
	public DummyPluginConfiguration() {}
	
	@Override
	protected boolean addConfiguration(PluginInfo pluginInfo, String name, String description, String type, String value) {
		return false;
	}
	
}
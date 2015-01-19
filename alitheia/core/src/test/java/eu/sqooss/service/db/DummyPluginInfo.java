package eu.sqooss.service.db;

import java.util.HashSet;
import java.util.Set;

import eu.sqooss.service.pa.PluginInfo;

public class DummyPluginInfo extends PluginInfo {
	
	public DummyPluginInfo() {}
	
	@Override
	public Set<PluginConfiguration> getConfiguration() {
		HashSet<PluginConfiguration> set = new HashSet<PluginConfiguration>();
		PluginConfiguration pluginConfiguration = new PluginConfiguration();
		set.add(pluginConfiguration);
		
		return set;
	}
	
	@Override
	public Set<Class<? extends DAObject>> getActivationTypes() {
		HashSet<Class<? extends DAObject>> set = new HashSet<Class<? extends DAObject>>();			
		return set;
	}
	
}
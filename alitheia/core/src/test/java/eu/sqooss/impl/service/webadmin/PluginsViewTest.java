package eu.sqooss.impl.service.webadmin;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import eu.sqooss.service.db.DummyPluginInfo;

public class PluginsViewTest {
	
	private DummyPluginInfo testPluginInfo;
	
	@Before
	public void setUp() {
		testPluginInfo = new DummyPluginInfo();
	}
	
	@Test
	public void testRenderPluginAttributesEmptyBuilder() {
		String render = PluginsView.renderPluginAttributes(testPluginInfo, false, false, 0);
		assertEquals("", render);
	}
	
	@Test
	public void testRenderPluginAttributesShowProperties() {
		String render = PluginsView.renderPluginAttributes(testPluginInfo, true, false, 0);
		String expected = "<tr>  <td>&nbsp;</td>\n  <td colspan=\"3\" class=\"attr\"><b>Property:</b> " 
							+ "null&nbsp;<b>Type:</b> null&nbsp;<b>Value:</b> null</td>\n</tr>\n";

		assertEquals(expected, render);
	}
	
	@Test
	public void testRenderPluginAttributesShowActivators() {
		String render = PluginsView.renderPluginAttributes(testPluginInfo, false, true, 0);
		assertEquals("", render);
	}
	
}
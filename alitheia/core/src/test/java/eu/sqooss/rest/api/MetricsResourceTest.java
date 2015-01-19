package eu.sqooss.rest.api;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import eu.sqooss.service.abstractmetric.Result;
import eu.sqooss.service.db.Metric;
import eu.sqooss.service.db.MetricType;

public class MetricsResourceTest {
	
	private DummyMetricsResource dummyMetricsResource;
	
	@Before
	public void setUp() {
		dummyMetricsResource = new DummyMetricsResource();
	}
	
	@Test
	public void testMetricsResource() {
		assertThat(null, not(dummyMetricsResource));
	}
	
	@Test
	public void testGetMetrics() {	
		Metric metric = dummyMetricsResource.getMetrics().get(0);
		assertEquals(1, metric.getId());
	}
	
	@Test
	public void testGetMetricTypes() {		
		MetricType metricType = dummyMetricsResource.getMetricTypes().get(0);
		assertEquals(1, metricType.getId());
	}
	
	@Test
	public void testGetMetricById() {		
		Metric metric = dummyMetricsResource.getMetricById((long) 1);
		assertEquals("Metric", metric.getDescription());
	}
	
	@Test
	public void testGetMetricResult() {	
		Result result = dummyMetricsResource.getMetricResult((long) 1, "").get(0);
		assertEquals(1, result.getMetricId().intValue());
	}
	
	@Test
	public void testGetResult() {	
		Result result = dummyMetricsResource.getResult(new Metric(), "").get(0);
		assertEquals(1, result.getMetricId().intValue());
	}
	
	@Test
	public void testGetMetricByMnem() {	
		Metric metric = dummyMetricsResource.getMetricByMnem("");
		assertEquals(1, metric.getId());
	}
	
	@Test
	public void testGetMetricResultByMnem() {	
		Result result = dummyMetricsResource.getMetricResultByMnem("", "").get(0);
		assertEquals(1, result.getMetricId().intValue());
	}
	
	@Test
	public void testGetMetricByType() {	
		Set<Metric> set = dummyMetricsResource.getMetricByType("");
		assertEquals(1, set.size());
	}
	
}

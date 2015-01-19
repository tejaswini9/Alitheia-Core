package eu.sqooss.rest.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.PathParam;

import eu.sqooss.service.abstractmetric.Result;
import eu.sqooss.service.db.Metric;
import eu.sqooss.service.db.MetricType;

class DummyMetricsResource extends MetricsResource {
	
	public DummyMetricsResource()  {}
	
	@Override
	public List<Metric> getMetrics() {
		ArrayList<Metric> list = new ArrayList<Metric>();
		Metric metric = new Metric();
		metric.setId(1);
		list.add(metric);
		
		return list;
	}
	
	@Override
	public List<MetricType> getMetricTypes() {
		ArrayList<MetricType> list = new ArrayList<MetricType>();
		MetricType metricType = new MetricType();
		metricType.setId(1);
		list.add(metricType);
		
		return list;
	}
	
	@Override
	public Metric getMetricById(@PathParam("id") Long id) {
		Metric metric = new Metric();
		metric.setDescription("Metric");
		
		return metric;
	}
	
	@Override
	public List<Result> getMetricResult(@PathParam("id") Long id,
            @PathParam("rid") String resourceIds) {
		ArrayList<Result> list = new ArrayList<Result>();
		Result result = new Result();
		result.setMetricId((long) 1);
		list.add(result);
		
		return list;
	}
	
	@Override
	public List<Result> getResult(Metric m, String resourceIds) {
		ArrayList<Result> list = new ArrayList<Result>();
		Result result = new Result();
		result.setMetricId((long) 1);
		list.add(result);
		
		return list;
	}
	
	@Override
	public Metric getMetricByMnem(@PathParam("mnem") String name) {
		Metric metric = new Metric();
		metric.setId((long) 1);
		
		return metric;
	}
	
	@Override
	public List<Result> getMetricResultByMnem(@PathParam("mnem") String name,
            @PathParam("rid") String resourceIds) {
		ArrayList<Result> list = new ArrayList<Result>();
		Result result = new Result();
		result.setMetricId((long) 1);
		list.add(result);
		
		return list;
	}
	
	@Override
	public Set<Metric> getMetricByType(@PathParam("type") String type) {
		HashSet<Metric> set = new HashSet<Metric>();
		Metric metric = new Metric();
		set.add(metric);
		
		return set;
	}
	
}
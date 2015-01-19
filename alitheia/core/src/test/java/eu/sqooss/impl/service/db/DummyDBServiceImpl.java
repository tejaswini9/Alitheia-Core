package eu.sqooss.impl.service.db;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hibernate.QueryException;
import org.hibernate.SessionFactory;
import org.osgi.framework.BundleContext;

import eu.sqooss.service.db.Bug;
import eu.sqooss.service.db.DAObject;
import eu.sqooss.service.logging.Logger;


public class DummyDBServiceImpl extends DBServiceImpl {
	
	private Logger logger; 
	
	protected boolean shutDown; 
	
	@Override
	protected boolean getJDBCConnection() {
		return false;
	}
	
	@Override
	protected boolean initHibernate(URL configFileURL) {
		return false;
	}
	
	public DummyDBServiceImpl() {}
	
	public DummyDBServiceImpl(Properties p, URL configFileURL, Logger l) { 
		this.logger = l;
	}
	
	@Override
	public <T extends DAObject> T findObjectById(Class<T> daoClass, long id) {
		@SuppressWarnings("unchecked")
		T t = (T) new Bug();
		t.setId(1);
		
		return t;
	}
	
	@Override
	public <T extends DAObject> T findObjectByIdForUpdate(Class<T> daoClass, long id) {
		@SuppressWarnings("unchecked")
		T t = (T) new Bug();
		t.setId(1);
		
		return t;
	}
	
	@Override
	public <T extends DAObject> List<T> findObjectsByProperties(Class<T> daoClass, Map<String,Object> properties) {
		ArrayList<T> list = new ArrayList<T>();
		@SuppressWarnings("unchecked")
		T t = (T) new Bug();
		t.setId(1);
		list.add(t);
		
		return list;		
	}
	
	@Override
	public <T extends DAObject> List<T> findObjectsByPropertiesForUpdate(Class<T> daoClass, Map<String,Object> properties) {
		ArrayList<T> list = new ArrayList<T>();
		@SuppressWarnings("unchecked")
		T t = (T) new Bug();
		t.setId(1);
		list.add(t);
		
		return list;
	}
	
	@Override
	 public <T extends DAObject> List<T> doFindObjectsByProperties(Class<T> daoClass, Map<String,Object> properties, boolean useLock) {
		ArrayList<T> list = new ArrayList<T>();
		@SuppressWarnings("unchecked")
		T t = (T) new Bug();
		t.setId(1);
		list.add(t);
		
		return list;
	}
	
	@Override
	public List<?> doSQL(String sql)
	        throws SQLException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	public List<?> doSQL(String sql, Map<String, Object> params)
	        throws SQLException, QueryException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	public int callProcedure(String procName, List<String> args, Map<String, Object> params)
			throws SQLException, QueryException {
		return 1;
	}
	
	@Override
	public List<?> doHQL(String hql)
	        throws QueryException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	public List<?> doHQL(String hql, Map<String, Object> params) 
	        throws QueryException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	 public List<?> doHQL(String hql, Map<String, Object> params, int limit) 
		        throws QueryException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	public List<?> doHQL(String hql, Map<String, Object> params, boolean lockForUpdate) 
	        throws QueryException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	 public List<?> doHQL(String hql, Map<String, Object> params,
	            @SuppressWarnings("rawtypes") Map<String, Collection> collectionParams) 
	        throws QueryException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	public List<?> doHQL(String hql, Map<String, Object> params,
            @SuppressWarnings("rawtypes") Map<String, Collection> collectionParams, boolean lockForUpdate, int start, int limit) 
        throws QueryException {
		ArrayList<?> list = new ArrayList<Integer>();		
		return list;
	}
	
	@Override
	 public boolean addRecord(DAObject record) {
		return false;
	}
	
	@Override
	 public boolean deleteRecord(DAObject record) {
		return false;
	}
	
	@Override
	public <T extends DAObject> boolean addRecords(List<T> records) {
		return false;
	}
	
	@Override
	public <T extends DAObject> boolean deleteRecords(List<T> records) {
		return false;
	}
	
	@Override
	public Logger logger() {
		return logger;
	}
	
	@Override
	 public boolean startDBSession() {
		return false;
	}
	
	@Override
	public boolean commitDBSession() {
		return false;
	}
	
	@Override
	public boolean rollbackDBSession() {
		return false;
	}
	
	@Override
	 public boolean flushDBSession() {
		return false;
	}
	
	@Override
	public boolean isDBSessionActive() {
		return false;
	}
	
	@Override
	public <T extends DAObject> T attachObjectToDBSession(T obj) {
		@SuppressWarnings("unchecked")
		T t = (T) new Bug();
		t.setId(1);
		
		return t;
	}
	
	@Override
	public int executeUpdate(String hql, Map<String, Object> params) 
		    throws QueryException {
		return 1;
	}
	
	@Override
	public boolean startUp() {
		return false;
	}
	
	@Override
	public void shutDown() {
		shutDown = false;
	}
	
	@Override
	public void setInitParams(BundleContext bc, Logger l) {
		logger = l;
	}
	
	@Override
	public void logSQLException(SQLException e) {
		String message = "sqle";
		logger.warn(message);
	}
	
	@Override
	public void logExceptionAndTerminateSession(Exception e) {
		String message = "e";
		logger.warn(message);
	}
	
	@Override
	protected boolean checkSession() {
		return false;
	}
	
	@Override
	public <T extends DAObject> T doFindObjectById(Class<T> daoClass, long id, boolean useLock) {
		@SuppressWarnings("unchecked")
		T t = (T) new Bug();
		t.setId(1);
		
		return t;
	}
	
}

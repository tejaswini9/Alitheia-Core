package eu.sqooss.impl.service.db;

import eu.sqooss.service.logging.Logger;


public class DummyLogger implements Logger {
	
	private String message;
	
	public DummyLogger() {}
	
	public String getMessage() {
		return message;
	}

	@Override
	public void debug(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String message) {
		this.message = message;		
	}

	@Override
	public void warn(String message) {
		this.message = message;
	}

	@Override
	public void warn(String message, Exception e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String message, Exception e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

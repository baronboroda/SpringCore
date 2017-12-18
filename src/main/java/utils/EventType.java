package utils;

public enum EventType {
	
	INFO, ERROR;
	
	@Override
	public String toString() {
		
		switch (this) {
			case INFO:
				return "INFO";
			case ERROR:
				return "ERROR";
			default:
				return "NO TYPE";
		}
	}
}

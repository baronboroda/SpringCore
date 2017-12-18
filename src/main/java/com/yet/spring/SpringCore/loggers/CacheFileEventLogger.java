package com.yet.spring.SpringCore.loggers;

import java.util.ArrayList;
import java.util.List;

import com.yet.spring.SpringCore.beans.Event;

public class CacheFileEventLogger extends FileEventLogger {

	private Integer cacheSize;
	private List<Event> cache;
	
	public CacheFileEventLogger(String fileName, Integer cacheSize) {
		super(fileName);
		this.cacheSize = cacheSize;
		this.cache = new ArrayList<Event>(cacheSize);
	}
	
	@Override
	public void logEvent(Event event) {
		cache.add(event);
		
		if (cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}
	
	public void writeEventsFromCache() {
		for (Event event : cache) {
			super.logEvent(event);
		}
	}
	
	public void destroy() {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}
}

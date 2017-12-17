package com.yet.spring.SpringCore.loggers;

import com.yet.spring.SpringCore.beans.Event;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(Event event) {
		System.out.println(event.toString());
	}
}

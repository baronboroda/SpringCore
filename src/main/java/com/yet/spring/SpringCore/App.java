package com.yet.spring.SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.SpringCore.beans.Client;
import com.yet.spring.SpringCore.beans.Event;
import com.yet.spring.SpringCore.loggers.ConsoleEventLogger;
import com.yet.spring.SpringCore.loggers.EventLogger;

public class App {

	private Client client;
	private EventLogger eventLogger;
	
	public App(Client client, EventLogger eventLogger) {
		this.client = client;
		this.eventLogger = eventLogger;
	}
	
	public void logEvent(Event event, String msg) {
		String message = msg.replaceAll(
				client.getId().toString(), client.getFullName());
		event.setMsg(message);
		eventLogger.logEvent(event);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext(
						"spring.xml");
		
		App app = (App) ctx.getBean("app");
		
		Event event = ctx.getBean(Event.class);
		app.logEvent(event, "Some event for user 1");
		event = ctx.getBean(Event.class);
		app.logEvent(event, "Some event fot user 2");
	}
}

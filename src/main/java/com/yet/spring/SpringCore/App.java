package com.yet.spring.SpringCore;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.SpringCore.beans.Client;
import com.yet.spring.SpringCore.beans.Event;
import com.yet.spring.SpringCore.loggers.EventLogger;

import utils.EventType;

public class App {

	private Client client;
	private EventLogger defaultLogger;
	private Map<EventType, EventLogger> loggers;
	
	public App(Client client, EventLogger eventLogger,
				Map<EventType, EventLogger> loggers ) {

		this.client = client;
		this.defaultLogger = eventLogger;
		this.loggers = loggers;
	}
	
	public void logEvent(EventType type, Event event, String msg) {
		
		String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
		
		EventLogger logger = loggers.get(type);
		
		 if (logger == null) {
			 logger = defaultLogger;
		 }
		 
		 logger.logEvent(event);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext(
						"spring.xml");
		
		App app = (App) ctx.getBean("app");
		
		Event event = ctx.getBean(Event.class);
		app.logEvent(EventType.INFO, event, "Some event for user 1");
		
		event = ctx.getBean(Event.class);
		app.logEvent(EventType.ERROR, event, "Some event fot user 2");
		
		event = ctx.getBean(Event.class);
		app.logEvent(null, event, "Some event fot user 3");
		
		ctx.close();
	}
}

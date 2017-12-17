package com.yet.spring.SpringCore.beans;

import java.text.DateFormat;
import java.util.Date;

public class Event {

	private static Integer counter = 0;
	private final Integer id = counter++;
	private String msg;
	private Date date;
	private DateFormat df;
	
	public Event() {
		
	}
	
	public Event(Date date, DateFormat df) {
		this.date = date;
		this.df = df;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString( ) {
		return new String("id = " + id + " ;msg = " + msg
				+ " ;date = " + df.format(date));
	}
}

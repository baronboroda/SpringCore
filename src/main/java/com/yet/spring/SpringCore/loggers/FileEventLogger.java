package com.yet.spring.SpringCore.loggers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.yet.spring.SpringCore.beans.Event;

public class FileEventLogger implements EventLogger {

	private final String newLine = System.getProperty("line.separator");
	private String fileName;
	private File file;
	
	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}
	
	public void init() throws IOException {
		this.file = new File(fileName);
		if (!file.canWrite()) {
			throw new IOException();
		}
	}
	
	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file, event.toString() + newLine, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

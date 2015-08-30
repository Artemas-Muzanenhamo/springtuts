package com.artemas.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {
	
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;
	
	@Autowired
	@Qualifier("toConsole")
	public void setConsoleWriter(ConsoleWriter writer){
		this.consoleWriter = writer;
	}
	
	@Autowired
	@Qualifier("fileWriter")
	public void setFileWriter(LogWriter fileWriter){
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text){
		fileWriter.write(text);
	}
	
	public void writeConsole(String text){
		if(consoleWriter != null){
			consoleWriter.write(text);
		}
	}

}

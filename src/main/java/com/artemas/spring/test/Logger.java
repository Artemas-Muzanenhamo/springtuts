package com.artemas.spring.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;

public class Logger {
	
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;
	
	@Resource
	public void setConsoleWriter(ConsoleWriter writer){
		this.consoleWriter = writer;
	}
	
	@Resource(name="squirrel")
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
	
	@PostConstruct //run at the beginning of the context.
	public void init(){
		System.out.println("init");
	}
	
	@PreDestroy //Run before the closing of the context.
	public void destory(){
		System.out.println("destroy");
	}

}

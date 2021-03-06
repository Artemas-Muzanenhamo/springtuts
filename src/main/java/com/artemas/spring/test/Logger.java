package com.artemas.spring.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

public class Logger {
	
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;
	
	public void setConsoleWriter(ConsoleWriter writer){
		this.consoleWriter = writer;
	}
	
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
	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("destroy");
	}

}

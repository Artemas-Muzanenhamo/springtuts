package com.artemas.spring.test;

public class FileWriter  implements LogWriter {
		
	public void write(String text){
		//Write to a file here.
		//Dummy implementation
		System.out.println("Write to a file: " + text);
	}
}

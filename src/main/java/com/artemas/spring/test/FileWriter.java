package com.artemas.spring.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class FileWriter  implements LogWriter {

	public void write(String text){
		//Write to a file here.
		//Dummy implementation
		System.out.println("Write to a file: " + text);
	}
}

package com.artemas.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("com/artemas/spring/test/beans/beans.xml");
		
		Robot robot = (Robot)context.getBean("robot");
		robot.speak();
		
		
		//close application context...
		((ClassPathXmlApplicationContext)context).close();

	}

}

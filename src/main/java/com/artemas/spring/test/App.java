package com.artemas.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		/**
		 * We use the ClassPathXmlApplicationContext because that will look for
		 * the file relative to the application's packages rather than the 
		 * directory paths. To get the file from the directories we would use
		 * the FilePathXmlApplicationContext.
		 */
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("com/artemas/spring/test/beans/beans.xml");
		
		Person person = (Person)context.getBean("person");
		person.speak();
		
		//to get the Address bean...
		Address address = (Address)context.getBean("address");
		
		System.out.println(person);
		System.out.println(address);
		
		//close application context...
		((ClassPathXmlApplicationContext)context).close();

	}

}

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
		
		
		person.setTaxId(111);
		
		//to get the Address bean...
		//Address address = (Address)context.getBean("address");
		
		/**
		 * By default a bean's scope = singleton
		 * 
		 * If scope is set to prototype, the Spring IoC container creates
		 * new bean instance of the object every time a 
		 * request for that specific bean is made.
		 * 
		 * IoC - By Implementing IoC, Software/Projects
		 * consumer get more options/control over the software/objects 
		 * instead of being controlled or having less options.
		 */
		System.out.println(person);
		
		//close application context...
		((ClassPathXmlApplicationContext)context).close();

	}

}

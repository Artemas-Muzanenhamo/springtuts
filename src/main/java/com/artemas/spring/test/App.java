package com.artemas.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.artemas.spring.DAO.OffersDAO;
import com.artemas.spring.model.Offer;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("com/artemas/spring/test/beans/beans.xml");
		
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		//get a list of type Offer
		List<Offer> offers = offersDao.getOffers();
		
		for(Offer offer:offers){
			System.out.println(offer);
		}
		
		
		//close application context...
		((ClassPathXmlApplicationContext)context).close();

	}

}

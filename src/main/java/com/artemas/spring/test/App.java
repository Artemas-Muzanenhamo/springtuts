package com.artemas.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.artemas.spring.DAO.OffersDAO;
import com.artemas.spring.model.Offer;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("com/artemas/spring/test/beans/beans.xml");
		
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		
		try {
			//get a list of type Offer
			List<Offer> offers = offersDao.getOffers();
			
			//for each offer in offers.... print out an offer on the console.
			for(Offer offer:offers){
				System.out.println(offer);
			}
			
			//overrides the Offer object and it's assigned to a single offer of id = 2.
			Offer offer = offersDao.getOffer(2);
			
			System.out.print("Should be Mike..." + offer);
		}catch (CannotGetJdbcConnectionException ex){
			//to handle errors when you can't connect to the db.
			System.out.println("Cannot get database connection.");
		}
		catch (DataAccessException e) {
			//to handle data access within the database after the connection is established.
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}
		
		//close application context...
		((ClassPathXmlApplicationContext)context).close();

	}

}

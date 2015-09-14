package com.artemas.spring.DAO;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.artemas.spring.model.Offer;

@Component
public class OffersDAO {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers(){
		return null;
	}
}

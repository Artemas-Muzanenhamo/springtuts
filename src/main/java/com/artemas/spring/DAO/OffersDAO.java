package com.artemas.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.artemas.spring.model.Offer;

@Component("offersDao")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	/**
	 * Queries the database and returns
	 * a list object of type Offer given
	 * the name.
	 * 
	 * @return a List of type <Offer>
	 */
	public List<Offer> getOffers(){
		
		//MapSqlParameterSource params = new MapSqlParameterSource("name","Sue");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name","Sue");
		
		return jdbc.query("select * from offers where name = :name", params, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				//instatiate a new Offer object.
				Offer offer = new Offer();
				
				//get Offer attributes from the db.
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				//return offer
				return offer;
			}
		});
	}
	
	/**
	 * Queries the database by id given that the id is valid and passed in as 
	 * a parameter in the method.
	 * 
	 * @param id - passed in from the main App.java class as type integer.
	 * 
	 * @return - an offer given the id passed.
	 */
	public Offer getOffer(int id){
		
		//MapSqlParameterSource params = new MapSqlParameterSource("name","Sue");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id",id);
		
		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				//instatiate a new Offer object.
				Offer offer = new Offer();
				
				//get Offer attributes from the db.
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				//return offer
				return offer;
			}
		});
	}
	
}

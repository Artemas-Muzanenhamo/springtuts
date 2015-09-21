package com.artemas.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
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
		
		return jdbc.query("select * from offers", new RowMapper<Offer>(){

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
	 * This Query will update a single row in the database given the id passed in.
	 * 
	 * @param offer - Object passed in of type Offer.
	 * @return - an update query where the id is the value passed in the method.
	 */
	public boolean update(Offer offer){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		//only 1 row should be affected. If more that one or less than one... something is wrong somewhere.
		return jdbc.update("update offers set name=:name, email=:email, text=:text where id=:id", params) ==1;
		
	}
	
	/**
	 * This Query inserts data into the database given the Offer object
	 * passed in which contains all the information i.e. name, email and text.
	 * 
	 * @param offer - Object of type Offer.
	 * @return - a jdbc query update which creates a new row in the database 
	 * with the object information passed in the method.
	 */
	public boolean create(Offer offers){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offers);
		
		//only 1 row should be affected. If more that one or less than one... something is wrong somewhere.
		return jdbc.update("insert into offers(name, email, text) values (:name, :email, :text)", params) == 1;
	}
	
	/**
	 * 
	 * @param offers
	 * @return
	 */
	public int[] create (List<Offer> offers){
		
		//expects an array of params
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		//Executes a batch using the supplied SQL statement with the batch of supplied arguments. Returns an array of integers.
		return jdbc.batchUpdate("insert into offers(name, email, text) values (:name, :email, :text)", params);
		
	}
	
	/**
	 * This query deletes an entry/row in the database depending on 
	 * the id passed in the method.
	 * 
	 * @param id - id passed of type int.
	 * @return - a true of false on the delete query with the passed id.
	 */
	public boolean delete(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from offers where id= :id", params) == 1;
		
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

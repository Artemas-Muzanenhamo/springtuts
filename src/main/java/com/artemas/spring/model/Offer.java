package com.artemas.spring.model;

public class Offer {
	
	private int id;
	private String name;
	private String email;
	private String text;
	
	//default constuctor.
	public Offer(){
		
	}
	
	//constructor to take in the name, email and text since the db auto increments the id, we wont need it here.
	public Offer(String name, String email, String text){
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	//constructor to take in the id, name, email and text since we will be updating a row, we need the id.
	public Offer(int id, String name, String email, String text){
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}
}

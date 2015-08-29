package com.artemas.spring.test;

public class Address {
	
	private String street;
	private String postCode;
	
	public Address(){
		
	}
	
	public String getStreet(){
		return street;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	public String getPostCode(){
		return postCode;
	}
	
	public void setPostCode(String postCode){
		this.postCode = postCode;
	}
	
	
	public Address(String street, String postCode){
		this.street = street;
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postCode=" + postCode + "]";
	}
	
	/**
	 * These are declared as the Bean init and destroy method. 
	 * However, if these methods are set in the beans.xml,
	 * they will be run first before the bean properties' init
	 * and destroy methods.
	 */
	public void init(){
		//System.out.println("Bean Created: " +this);
	}
	
	public void destroy(){
		//System.out.println("Bean Destroyed");
	}

}

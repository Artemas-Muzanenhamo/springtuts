package com.artemas.spring.test;

public class Person {
	
	//instantiate via setters and getters...
	private int taxId;
	
	private int id;
	private String name;
	
	//we want Person to have an address...
	private Address address;
	
	/**
	 * Constructor which takes two arguments.
	 * Purpose of a constructor is to allow
	 * generation of Objects within a class.
	 */
	public Person(){
		
	} 
	
	/**
	 * @param id
	 * @param name
	 */
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public void speak(){
		System.out.println("Hello I can speak !!");
	}
	
	//we could instantiate taxID via the constructor or do it this way...
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [taxId=" + taxId + ", id=" + id + ", name=" + name
				+ ", address=" + address + "]";
	}

}

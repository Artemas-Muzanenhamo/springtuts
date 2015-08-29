package com.artemas.spring.test;

import java.util.List;

public class FruitBasket {
	
	private String name;
	private List<String> fruits;
	
	//constructor of the class with params
	public FruitBasket(String name, List<String> fruits){
		this.name = name;
		this.fruits = fruits;
	}
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		//append name
		sb.append(name);
		//name + contains and create a new line...
		sb.append(" contains:\n");
		
		//for each fruit in fruits, run instructions...
		for(String fruit: fruits){
			sb.append(fruit);
			sb.append("\n");
		}
		
		return sb.toString();
		
	}
	
}

package com.artemas.spring.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Jungle {
	
	//Instantiate Map foods as a HashMap Object.
	private Map<String, String> foods = new HashMap<String, String>();
	
	public void setFoods(Map<String, String> foods){
		this.foods = foods;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		//for each entry in foods, get the key and get the value...
		for(Map.Entry<String, String> entry: foods.entrySet()){
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		
		return sb.toString();
	}
	
}

package com.artemas.spring.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Jungle {
	
	//Instantiate Map foods as a HashMap Object.
	private Map<String, String> foods = new HashMap<String, String>();
	private Map<String, Animal> animals = new HashMap<String, Animal>();
	
	public void setFoods(Map<String, String> foods){
		this.foods = foods;
	}
	
	public void setAnimals(Map<String, Animal> animals){
		this.animals = animals;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		//for each entry in foods, get the key and get the value...
		for(Map.Entry<String, String> entry: foods.entrySet()){
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		
		//for each entry in animals, get the key and get the Animal...
		for(Map.Entry<String, Animal> entry: animals.entrySet()){
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		
		return sb.toString();
	}
	
}

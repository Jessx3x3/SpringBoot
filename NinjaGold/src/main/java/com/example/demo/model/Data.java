package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Data {
	
	ArrayList<String> activities = new ArrayList<String>();
	
	Random random = new Random();
	Date date = new Date();
	
	public ArrayList<String> getActivities() {
		return activities;
	}
	public void setActivities(ArrayList<String> activities) {
		this.activities = activities;
	}
	public String farmActivity(Ninja ninja){
		int earns = random.nextInt(20 + 1 - 10 ) + 10;
		ninja.setGold(ninja.getGold()+earns);
		
		String aux = "You entered a farm and earned "+earns+ " gold. ("+date+")";
		activities.add(aux);	
		
		return aux;
	}
	public String caveActivity(Ninja ninja){
		int earns = random.nextInt(10 + 1 - 5) + 5;	
		ninja.setGold(ninja.getGold()+earns);
		
		String aux = "You entered a cave and earned "+earns+ " gold. ("+date+")";
		activities.add(aux);
		
		return aux;
	}
	public String houseActivity(Ninja ninja){
		int earns = random.nextInt(5 + 1 - 2) + 2;
		ninja.setGold(ninja.getGold()+earns);
		
		String aux = "You entered a house and earned "+earns+ " gold. ("+date+")";
		activities.add(aux);
		
		return aux;
	}
	public String casinoActivity(Ninja ninja){
		
		int value = random.nextInt(2 + 1 - 1) + 1;
		int earns = random.nextInt(50 + 1 - 0) + 0;
		
		if(value == 1) {
			ninja.setGold(ninja.getGold()+earns);
			
			String aux = "You entered a casino and earned "+earns+ " gold. ("+date+")";
			activities.add(aux);
			
			return aux;
		}else{
			ninja.setGold(ninja.getGold()-earns);
			
			String aux = "You entered a casino and lost "+earns+ " gold. ("+date+")";
			activities.add(aux);
			
			return aux;
		}
		
		
	}
}

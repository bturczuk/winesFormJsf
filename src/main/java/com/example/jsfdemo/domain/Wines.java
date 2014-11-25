package com.example.jsfdemo.domain;

import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Wines 	{
		private String type = "";
		private String origin = ""; 
		private String[] strain;
		private String name = "";
		private int year = 2000;
		private String sweetness = "";
		private String alcohol = "";
		private float price;
		private Long uuid = UUID.randomUUID().getLeastSignificantBits();
	
	public Wines()
	{
		
		super();
		System.out.println(uuid);
	}

	public Wines(String type, String origin, String[] strain,
			String name, int year, String sweetness,
			String alcohol, float price)
	{
		super();
		this.type = type;
		this.origin = origin;
		this.strain = strain;
		this.name = name;
		this.year = year;
		this.sweetness = sweetness;
		this.alcohol = alcohol;
		this.price = price;
	}
	

	public void setType(String type) {
		this.type = type;
	}
	@Size(min=2, max=40)
	public String getType() {
		return type;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getOrigin() {
		return origin;
	}
	
	public void setStrain(String[] strain){
		this.strain = strain;
	}
	public String[] getStrain(){
		return strain;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	
	public void setYear(int year){
		this.year = year;
	}
	@Past
	public int getYear(){
		return year;
	}
	
	public void setSweetness(String sweetness){
		this.sweetness = sweetness;
	}
	public String getSweetness(){
		return sweetness;
	}
	
	public void setAlcohol(String alcohol){
		this.alcohol = alcohol;
	}
	
	public String getAlcohol(){
		return alcohol;
	}
	
	
	public void setPrice(float price){
		this.price = price;
	}
	@Min(10)
	public float getPrice(){
		return price;
	}
	
	public long getId(){
		return uuid;
	}
	public void setId(Long uuid) {
		this.uuid = uuid;
	}
	
	public String getStringFromTable() {
		String out = "";
		if(strain != null){	
		for(int i=0; i<strain.length; i++){
				out += strain[i] + ", ";		
		}
		}
		else if (strain == null){
			out = "none selected";
		}
		return out;
	}
	
}
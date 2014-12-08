package com.example.jsfdemo.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Wines 	{
		private String type = "";
		private String origin = ""; 
		private ArrayList<String> strain;
		private String name = "";
		private String alcohol = "";
		private Date domm = new Date();
		private boolean canEdit = false;
		private Long uuid = UUID.randomUUID().getLeastSignificantBits();
	
	public Wines()
	{
		
		super();
		System.out.println(uuid);
	}


	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getOrigin() {
		return origin;
	}
	
	public ArrayList<String> getStrain() {
		return strain;
	}
	public void setStrain(ArrayList<String> strain) {
		this.strain = strain;
	}

	public void setName(String name){
		this.name = name;
	}
	@Size(min=2, max=40) @NotNull
	public String getName(){
		return name;
	}
	
	public void setAlcohol(String alcohol){
		this.alcohol = alcohol;
	}
	
	public String getAlcohol(){
		return alcohol;
	}

	@Past
	public Date getDOM() {
	return domm;
	}
	
	public void setDOM(Date domm) {
	this.domm = domm;
	}
	
	public long getId(){
		return uuid;
	}
	public void setId(Long uuid) {
		this.uuid = uuid;
	}
	
	public boolean getCanEdit() {
		return canEdit;
	}
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	
	
	/* public String getStringFromTable() {
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
	*/
	
}
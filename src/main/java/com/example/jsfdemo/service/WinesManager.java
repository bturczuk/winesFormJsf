package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.jsfdemo.domain.Wines;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WinesManager {
   
private List<Wines> db = new ArrayList<Wines>();
	
	public void add(Wines wine){
		Wines newWine = new Wines(wine.getType(), wine.getOrigin(),
				wine.getStrain(), wine.getName(), wine.getYear(), wine.getSweetness(),
				wine.getAlcohol(), wine.getPrice());
		
		db.add(newWine);
	}
	
	public List<Wines> getAllWines(){
		return db;
	}
	
/*	public void delete(long uuid){
		int i=0;
		while(db.get(i).getId() != uuid)
			i++;
		if(db.get(i).getId() == uuid)
			db.remove(i);
	}
*/
	
	public void deleteWine(Wines perswineon) {
		Wines wineToRemove = null;

		if (wineToRemove != null)
			db.remove(wineToRemove);
	}
	
	public void update(long uuid){
		int i=0;
		while(db.get(i).getId() != uuid)
			i++;
		if(db.get(i).getId() == uuid)
			db.get(i);
	}
	
	public void setUpdate(Wines wine, long uuid){
		int i=0;
		while(db.get(i).getId() != uuid)
			i++;
		if(db.get(i).getId() == uuid){
			db.set(i, wine);
		}
	}
	
	
}

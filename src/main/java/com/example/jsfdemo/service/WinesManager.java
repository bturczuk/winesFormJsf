package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.jsfdemo.domain.Wines;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WinesManager {
   
private List<Wines> db = new ArrayList<Wines>();
	
			public void add(Wines wine) {
			Wines newWine = new Wines();
			newWine.setType(wine.getType());
			newWine.setStrain(wine.getStrain());
			newWine.setName(wine.getName());
			newWine.setOrigin(wine.getOrigin());
			
		
		db.add(newWine);
	}
	
	public List<Wines> getAllWines(){
		return db;
	}

	public void deleteWine(Wines wine) {
		Wines wineToRemove = null;
		for (Wines w : db){
			if(wine.getId() == w.getId()){
				wineToRemove = w;
				break;
			}
		}
		if (wineToRemove != null)
			db.remove(wineToRemove);
	}
	
	
	
	
	public void updateWine(Wines wine) {
		Wines wineToUpdate = null;
		for (Wines w : db) {
			if (wine.getId() == w.getId()) {
				wineToUpdate = w;
				break;
			}
		}
		if (wineToUpdate != null){
		Wines newWine = new Wines();
		newWine.setType(wine.getType());
		newWine.setOrigin(wine.getOrigin());
		newWine.setStrain(wine.getStrain());
		newWine.setName(wine.getName());
		newWine.setId(wine.getId());
		newWine.setDateOfManufacture(wine.getDateOfManufacture());
		}
	}

	
	
	public void updateWineFinish(Wines wine) {
		Wines newWine = new Wines();
		newWine.setType(wine.getType());
		newWine.setOrigin(wine.getOrigin());
		newWine.setStrain(wine.getStrain());
		newWine.setName(wine.getName());
		newWine.setId(wine.getId());
		newWine.setDateOfManufacture(wine.getDateOfManufacture());
		
		Wines wineToUpdate = null;
		int i=0;
			for (Wines w : db) {
					i++;
					if (wine.getId() == w.getId()) {
						wineToUpdate = w;
						break;
					}
			}
		if (wineToUpdate != null){
				db.set(i-1,newWine);
		}
	}
	
		public String editWine(Wines wine){
		wine.setCanEdit(true);
		return null;
	}
	
	
	
}

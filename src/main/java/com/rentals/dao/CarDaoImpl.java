package com.rentals.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.rentals.core.RentalCar;

public class CarDaoImpl implements CarDao  {
	
	private Inventory inventory;
    @Inject
	public CarDaoImpl(Inventory inventory) {
 		this.inventory = inventory;
	}

	@Override
	public Collection<RentalCar> getCarsPerLocationAndPrice(String location, double price) {
		Collection<RentalCar> selectedCars = new ArrayList<RentalCar>();
		Collection<RentalCar> inventoryCars = inventory.getInventory().values();
		for (RentalCar rentalCar : inventoryCars) {
			if(rentalCar.getLocation().equals(location) && rentalCar.getDailyRate() <= price){
				selectedCars.add(rentalCar);
			}
		}
		return selectedCars;
	}

	@Override
	public Collection<RentalCar> getAll() {
	 	return inventory.getInventory().values();
	}

	@Override
	public RentalCar getRentalCar(long id) {
		// TODO Auto-generated method stub
		return inventory.getInventory().get(id);
	}

	@Override
	public void add(RentalCar car) {
		inventory.addCar(car);
		
	}

	 
	

}

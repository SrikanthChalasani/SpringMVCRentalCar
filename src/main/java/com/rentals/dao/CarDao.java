package com.rentals.dao;

import java.util.Collection;

import com.rentals.core.RentalCar;

public interface CarDao {
	
	 Collection<RentalCar> getCarsPerLocationAndPrice(String locaiton, double price);
	 Collection<RentalCar> getAll();
	RentalCar getRentalCar(long id);
	void add(RentalCar car);

}

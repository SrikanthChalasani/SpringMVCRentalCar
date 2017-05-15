package com.rentals.service;

import java.util.Collection;

import com.rentals.core.RentalCar;
import com.rentals.dao.CarDao;

public interface CarService {
	
	 CarDao getDao();
	 Collection<RentalCar> getCarsPerLocationAndPrice(String locaiton, double price);
	 Collection<RentalCar> getAll();
	 RentalCar getRentalCar(long id);
	void add(RentalCar car);	

}

package com.rentals.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Value;

import com.rentals.core.RentalCar;
import com.rentals.dao.CarDao;
 
 
public class CarServiceImpl implements CarService{
    private CarDao dao;
    
    @Inject
	public CarServiceImpl(CarDao dao) {
		super();
		this.dao = dao;
 	}
    
	@Override
	public CarDao getDao() {
 		return dao;
	}

	 
	@Override
	public Collection<RentalCar> getCarsPerLocationAndPrice(String location, double price) {
		Collection<RentalCar> cars = dao.getCarsPerLocationAndPrice(location, price);
	 	return limitNumberOfRentalCars(cars);
	}
	

	@Override
	public Collection<RentalCar> getAll() {
	 	Collection<RentalCar> cars = dao.getAll();
	 	return limitNumberOfRentalCars(cars);
	}

	private Collection<RentalCar> limitNumberOfRentalCars(Collection<RentalCar> cars) {
		List<RentalCar> selectedCars = new ArrayList<RentalCar>();
	 	for (RentalCar rentalCar : cars) {
			 selectedCars.add(rentalCar);     
		}
		return selectedCars;
	}

	@Override
	public RentalCar getRentalCar(long id) {
		// TODO Auto-generated method stub
		return dao.getRentalCar(id);
	}

	@Override
	public void add(RentalCar car) {
		dao.add(car);
		
	}

	 
	
	 

}

package com.rentals.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;

import com.rentals.core.RentalCar;

public class Inventory {
	
	private static Map<Long, RentalCar> inventory;
	 
	private static long counter = 11L;
	static {
		 	
		inventory = new ConcurrentHashMap<Long, RentalCar>();
		inventory.put(1L, new RentalCar(1L, "BMI", "Economy", 23.00, "Kia", "Rio" ));
		inventory.put(2L, new RentalCar(2L, "BMI", "Compact", 26.00, "Nissan", "Versa" ));
		inventory.put(3L, new RentalCar(3L,"BMI", "MidSize", 31.00, "Toyota", "Corolla" ));
		inventory.put(4L, new RentalCar(4L,"BMI", "FullSize", 36.00, "Toyota", "Camry" ));
		inventory.put(5L, new RentalCar(5L,"BMI", "Standard", 40.00, "Ford", "Fusion" ));
		
		inventory.put(6L, new RentalCar(6L,"PEA", "Economy", 24.00, "Ford", "Fiesta" ));
		inventory.put(7L, new RentalCar(7L,"PEA", "Compact", 25.00, "Ford", "Focus" ));
		inventory.put(8L, new RentalCar(8L,"PEA", "MidSize", 32.00, "Honda", "Civic" ));
		inventory.put(9L, new RentalCar(9L,"PEA", "FullSize", 34.00, "Honda", "Accord" ));
		inventory.put(10L, new RentalCar(10L,"PEA", "Standard", 37.00, "Chrysler", "300" ));
		
		inventory.put(11L, new RentalCar(11L,"ORD", "Economy", 28.00, "Tata", "Nano" ));
		inventory.put(12L, new RentalCar(12L,"ORD", "Compact", 32.00, "Nissan", "Versa" ));
		inventory.put(13L, new RentalCar(13L,"ORD", "MidSize", 37.00, "Nissan", "Altima" ));
		inventory.put(14L, new RentalCar(14L,"ORD", "FullSize", 39.00, "Toyota", "Camry" ));
		inventory.put(15L, new RentalCar(15L,"ORD", "Standard", 55.00, "Infinity", "Q50" ));
	 
	
	}
	public Map<Long, RentalCar> getInventory() {
		return inventory;
	}
	public void setCar(RentalCar car) {
	 	inventory.put(car.getId(), car);
	}
	//-----------------------------
	@Value("#{inventory.inventory.values().?[category.startsWith('Com')]}") 
	private List<RentalCar> exclusive; 
	@Value("#{inventory.inventory.values().?[dailyRate > 39.00]}") 
	private List<RentalCar> compact;
	public List<RentalCar> getExclusive() {
		return exclusive;
	}
	public List<RentalCar> getCompact() {
		return compact;
	} 
	
	public void addCar(RentalCar car){
	//	RentalCar newCar = new RentalCar(16L,"BMI","Economy",33.00,"Nissan","Versa");
		this.inventory.put(car.getId(), car);		
	}
	
	
}

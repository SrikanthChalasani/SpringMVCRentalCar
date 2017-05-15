package com.web.rentals.controller;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

import com.anno.CarAnno;
import com.anno.LocationAnno;

//@LocationAnno(price=45.0) // custom annotation
@LocationAnno
@CarAnno
public class CarTO {
	@Pattern(regexp = "[a-z-A-Z]*", message = "Location no longer available")
	private String pickUp;
	@DecimalMin(value = "19.99", message = "Price cannot be less than 19.99")
	@DecimalMax(value = "90.99", message = "Price cannot be greather than 90.99")
	private double price;

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

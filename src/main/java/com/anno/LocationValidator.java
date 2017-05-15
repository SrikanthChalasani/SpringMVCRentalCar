package com.anno;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.web.rentals.controller.CarTO;

public class LocationValidator implements ConstraintValidator<LocationAnno, CarTO> {

	private LocationAnno location;
	@Override
	public void initialize(LocationAnno arg0) {
		this.location = arg0;
		
	}

	@Override
	public boolean isValid(CarTO arg0, ConstraintValidatorContext arg1) {
         if (arg0.getPickUp().equals("PEA") && arg0.getPrice() > 44.00)
         {
		return false;
         }
         return true;
	}

}

package com.anno;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.web.rentals.controller.CarTO;

public class CarValidator implements ConstraintValidator<CarAnno, CarTO> {

	private CarAnno car;

	@Override
	public void initialize(CarAnno arg0) {
		this.car = arg0;
	}

	@Override
	public boolean isValid(CarTO arg0, ConstraintValidatorContext arg1) {
		arg1.disableDefaultConstraintViolation();
		if (arg0.getPickUp().equals("PEA")
				&& arg0.getPrice() > 75) {
			arg1.buildConstraintViolationWithTemplate("we failed")
					.addConstraintViolation();
			return false;
		}
		return true;
	}

}

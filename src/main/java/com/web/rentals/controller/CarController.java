package com.web.rentals.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.core.Receipt;
import com.rentals.core.RentalCar;
import com.rentals.service.CarService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

@RestController
// this annotation converts to XML
public class CarController {

	@Autowired
	private CarService service;

	// localhost:8080/rentals/car/3

	// exposing this method as end point for REST service
	@RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
	public RentalCar getById(@PathVariable("id") long id) {
		return service.getRentalCar(id);
	}

	@RequestMapping(value = "/car/add", method = RequestMethod.POST, produces = "application/xml")
	public Receipt add(@RequestBody RentalCar car) {
		service.add(car);
		Receipt receipt = new Receipt();
		receipt.setMessage("Car added : " + car.getMake() + " " + car.getModel() + "-id-" + car.getId());
		receipt.setDate(DateFormat.getDateInstance().format(new Date()));
		return receipt;
	}
}

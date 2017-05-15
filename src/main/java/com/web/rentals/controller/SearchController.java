package com.web.rentals.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentals.service.CarService;

//TODO
@Controller
@RequestMapping(value = "/rental")
public class SearchController {
	// TODO
	@Autowired
	private CarService carService;

	@ModelAttribute("offices")
	public List<String> getOffices() {
		List<String> offices = new ArrayList<String>();
		offices.add("BMI");
		offices.add("ORD");
		offices.add("PEA");
		offices.add("IN9");
		return offices;
	}

	// TODO
	@RequestMapping(method = RequestMethod.GET)
	public String search(@ModelAttribute("car") CarTO car) {
		car.setPickUp("ORD");
		car.setPrice(98.00);
		return "search";
	}

	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public ModelAndView getCars(@ModelAttribute("car") @Valid CarTO car,
			BindingResult result) {
		if (car.getPrice() == 0) throw new RuntimeException("Price cannot be 0.");// picks up GeneralControllerAdvice
		if (result.hasErrors()) {
			return new ModelAndView("search", "cars", null);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject(
				"cars",
				carService.getCarsPerLocationAndPrice(car.getPickUp(),
						car.getPrice()));
		mv.setViewName("search");
		return mv;
	}
}

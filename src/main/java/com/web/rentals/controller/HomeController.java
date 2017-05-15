package com.web.rentals.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HomeController {
 
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() throws IOException{
		return "home";

	}
}

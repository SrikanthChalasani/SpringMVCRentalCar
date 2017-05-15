package com.rentals.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Receipt {
	private String date;
	private String message;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

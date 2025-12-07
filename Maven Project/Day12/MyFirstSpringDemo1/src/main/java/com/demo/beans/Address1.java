package com.demo.beans;

public class Address1 {
	private String street;
	private String city;
	private String pincode;
	
	public Address1() {
		super();
	}

	public Address1(String street, String city, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address1 [street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	
	

}

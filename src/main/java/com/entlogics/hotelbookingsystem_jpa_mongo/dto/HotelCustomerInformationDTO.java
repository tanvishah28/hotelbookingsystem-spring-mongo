package com.entlogics.hotelbookingsystem_jpa_mongo.dto;

import java.util.List;

//this is Hotel Customer Information DTO Class with properties of Customer, list of integers for getting IDs of bookings,bills & getters and setters
public class HotelCustomerInformationDTO {

	// Defining the fields

	private int customer_id;

	private String customer_name;

	private String customer_address;

	private String customer_phone;

	private String customer_email;

	private String preferences;

	private String special_needs;

	private List<Integer> bookings;

	private List<Integer> bills;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public String getSpecial_needs() {
		return special_needs;
	}

	public void setSpecial_needs(String special_needs) {
		this.special_needs = special_needs;
	}

	public List<Integer> getBookings() {
		return bookings;
	}

	public void setBookings(List<Integer> bookings) {
		this.bookings = bookings;
	}

	public List<Integer> getBills() {
		return bills;
	}

	public void setBills(List<Integer> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "CustomerInformationDTO [customer_id=" + customer_id + ", customer_name=" + customer_name
				+ ", customer_address=" + customer_address + ", customer_phone=" + customer_phone + ", customer_email="
				+ customer_email + ", preferences=" + preferences + ", special_needs=" + special_needs + "]";
	}
}

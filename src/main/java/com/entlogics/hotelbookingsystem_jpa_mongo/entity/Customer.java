package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

import java.util.List;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This entity class maps to customer table in hoteldb using mongo 

@Document(collection = "customer")
public class Customer {

	// Defining the fields & annotate the fields

	@Id
	private ObjectId objectId;
	
	@Field(value = "customer_id")
	private int customer_id;

	@Field(value = "customer_name")
	private String customer_name;

	@Field(value = "customer_address")
	private String customer_address;

	@Field(value = "customer_phone")
	private String customer_phone;

	@Field(value = "customer_email")
	private String customer_email;

	@Field(value = "preferences")
	private String preferences;

	@Field(value = "special_needs")
	private String special_needs;

	@DBRef
	List<Booking> bookings;
	
	@DBRef
	List<Bill> bills;

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	@DBRef
	List<Hotel_Customer> hotels;

	// no-arg constructor

	public Customer() {
	}

	// Parameterized Constructor for Customer class

	public Customer(String customer_name, String customer_address) {
		this.customer_name = customer_name;
		this.customer_address = customer_address;
	}

	// Generated Setters and getters
	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Hotel_Customer> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel_Customer> hotels) {
		this.hotels = hotels;
	}

	// Generate toString()

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_phone=" + customer_phone + ", customer_email=" + customer_email
				+ ", preferences=" + preferences + ", special_needs=" + special_needs + "]";
	}
}

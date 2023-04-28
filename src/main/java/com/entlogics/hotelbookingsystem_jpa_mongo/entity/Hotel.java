package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

import java.util.List;

import javax.persistence.Id;
//import org.springframework.data.annotation.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This entity class maps to hotel table in hoteldb using mongo 

@Document(collection = "hotel")
public class Hotel {

	// Defining the fields & annotate the fields

	@Id
	private ObjectId objectId;

	@Field(value = "hotel_id")
	private int hotel_id;

	@Field(value = "hotel_name")
	private String hotel_name;

	@Field(value = "hotel_location")
	private String hotel_location;

	@Field(value = "hotel_phone")
	private String hotel_phone;

	@Field(value = "hotel_rating")
	private int hotel_rating;

	@Field(value = "hotel_email")
	private String hotel_email;

	@Field(value = "pet_friendly")
	private boolean pet_friendly;

	@DBRef
	List<Hotel_Customer> customers;

	@DBRef
	List<Room> rooms;

	@DBRef
	List<Employee> employees;

	@DBRef
	List<Booking> bookings;

	@DBRef
	List<Hotel_Service> services;

	// no-arg constructor
	public Hotel() {
	}

	// Constructor for Hotel class

	public Hotel(String hotel_name, String hotel_location) {
		this.hotel_name = hotel_name;
		this.hotel_location = hotel_location;
	}

	// Generated Setters and getters

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_location() {
		return hotel_location;
	}

	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}

	public String getHotel_phone() {
		return hotel_phone;
	}

	public void setHotel_phone(String hotel_phone) {
		this.hotel_phone = hotel_phone;
	}

	public int getHotel_rating() {
		return hotel_rating;
	}

	public void setHotel_rating(int hotel_rating) {
		this.hotel_rating = hotel_rating;
	}

	public String getHotel_email() {
		return hotel_email;
	}

	public void setHotel_email(String hotel_email) {
		this.hotel_email = hotel_email;
	}

	public boolean isPet_friendly() {
		return pet_friendly;
	}

	public void setPet_friendly(boolean pet_friendly) {
		this.pet_friendly = pet_friendly;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Hotel_Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Hotel_Customer> customers) {
		this.customers = customers;
	}

	public List<Hotel_Service> getServices() {
		return services;
	}

	public void setServices(List<Hotel_Service> services) {
		this.services = services;
	}

	// Generate toString()
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_location=" + hotel_location
				+ ", hotel_phone=" + hotel_phone + ", hotel_rating=" + hotel_rating + ", hotel_email=" + hotel_email
				+ ", pet_friendly=" + pet_friendly + "]";
	}
}

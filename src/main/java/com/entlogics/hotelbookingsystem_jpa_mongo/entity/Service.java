package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

import java.util.List;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This entity class maps to service table in hoteldb using mongo 

@Document(collection = "service")
public class Service {

	// Defining the fields & annotate the fields

	@Id
	private ObjectId objectId;

	@Field(value = "service_id")
	private int service_id;

	@Field(value = "service_name")
	private String service_name;

	@DBRef
	List<Hotel_Service> hotels;

	@DBRef
	List<Booking_Service> bookings;

	// no-arg constructor

	public Service() {
		super();
	}

	// Constructor for Customer class

	public Service(String service_name) {
		super();
		this.service_name = service_name;
	}

	// Generated Setters and getters

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public List<Hotel_Service> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel_Service> hotels) {
		this.hotels = hotels;
	}

	public List<Booking_Service> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking_Service> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", service_name=" + service_name + "]";
	}
}

package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This entity class maps to booking_service table in hoteldb using mongo 

@Document(collection = "booking_service")
public class Booking_Service {

	// Defining the fields & annotate the fields

	@Id
	private ObjectId objectId;

	@Field(value = "booking_service_id")
	private int booking_service_id;

	@Field(value = "booking_id")
	private int booking_id;

	@DBRef
	private Hotel_Service hotel_service;

	@Field(value = "rating")
	private float service_rating;

	// getters & setters

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public int getBooking_service_id() {
		return booking_service_id;
	}

	public void setBooking_service_id(int booking_service_id) {
		this.booking_service_id = booking_service_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public Hotel_Service getHotel_service() {
		return hotel_service;
	}

	public void setHotel_service(Hotel_Service hotel_service) {
		this.hotel_service = hotel_service;
	}

	public float getService_rating() {
		return service_rating;
	}

	public void setService_rating(float service_rating) {
		this.service_rating = service_rating;
	}

	@Override
	public String toString() {
		return "Booking_Service [booking_service_id=" + booking_service_id + ", service_rating=" + service_rating + "]";
	}
}

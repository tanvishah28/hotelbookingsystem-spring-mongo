package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

import java.math.BigDecimal;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This entity class maps to hotel_service table in hoteldb using mongo 

@Document(collection = "hotel_service")
public class Hotel_Service {

	// Defining the fields & annotate the fields

	@Id
	private ObjectId objectId;

	@Field(value = "hotel_service_id")
	private int hotel_service_id;

	@Field(value = "hotel_id")
	private int hotel_id;

	@Field(value = "service_id")
	private int service_id;

	@Field(value = "service_price")
	private BigDecimal service_price;

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public int getHotel_service_id() {
		return hotel_service_id;
	}

	public void setHotel_service_id(int hotel_service_id) {
		this.hotel_service_id = hotel_service_id;
	}

	public BigDecimal getService_price() {
		return service_price;
	}

	public void setService_price(BigDecimal service_price) {
		this.service_price = service_price;
	}

	@Override
	public String toString() {
		return "Hotel_Service [hotel_service_id=" + hotel_service_id + ", service_price=" + service_price + "]";
	}
}

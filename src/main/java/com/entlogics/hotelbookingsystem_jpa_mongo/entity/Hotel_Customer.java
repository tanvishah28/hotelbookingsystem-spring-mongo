	package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This entity class maps to hotel_customer table in hoteldb using mongo 

@Document(collection = "hotel_customer")
public class Hotel_Customer {

	// Defining the fields & annotate the fields

//	@Id
//	private ObjectId objectId;

	@Id
	@Field(value = "hotel_customer_id")
	private int hotel_customer_id;
	
//	@Field(value = "hotel_customer_id")
//	private int hotel_customer_id;

	@Field(value = "hotel_id")
	private int hotel_id;

	@Field(value = "customer_id")
	private int customer_id;

	@Field(value = "customer_type")
	private String customer_type;

	@Field(value = "customer_reward_points")
	private double customer_reward_points;

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public double getCustomer_reward_points() {
		return customer_reward_points;
	}

	public void setCustomer_reward_points(double customer_reward_points) {
		this.customer_reward_points = customer_reward_points;
	}

	@Override
	public String toString() {
		return "Hotel_Customer [hotel_customer_id=" + hotel_customer_id + ", customer_type=" + customer_type
				+ ", customer_reward_points=" + customer_reward_points + "]";
	}
}

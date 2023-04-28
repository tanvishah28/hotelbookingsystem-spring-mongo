package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.*;

//This entity class maps to bill table in hoteldb using mongo 

@Document(collection = "bill")
public class Bill {

	// Defining the fields & annotate the fields

	@Id
	private ObjectId objectId;

	@Field(value = "bill_id")
	private int bill_id;

	@Field(value = "bill_number")
	private int bill_number;

	@Field(value = "bill_amt")
	private float bill_amt;

	@Field(value = "bill_DateTime")
	private Date bill_dateTime;

	@Field(value = "discount")
	private String discount;

	@Field(value = "bill_reward_points")
	private int bill_reward_points;

	// enum bill_status { PAID, NOT_PAID, PARTIALLY_PAID; }

	@Field(value = "bill_status")
	@Enumerated(EnumType.STRING)
	private Bill_Status bill_status;

//	enum payment_method {	CASH, DEBIT, CREDIT; }

	@Field(value = "payment_method")
	@Enumerated(EnumType.STRING)
	private Payment_Method payment_method;

	@DBRef
	private Customer customer;
	
//	@Field(value = "customer_id")
//	private int customer_id;

	// no-arg constructor
	public Bill() {
		super();
	}

	// Constructor for Bill entity
	public Bill(int bill_number, float bill_amt) {
		super();
		this.bill_number = bill_number;
		this.bill_amt = bill_amt;
	}

	// Generated getters and setters

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getBill_number() {
		return bill_number;
	}

	public void setBill_number(int bill_number) {
		this.bill_number = bill_number;
	}

	public float getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(float bill_amt) {
		this.bill_amt = bill_amt;
	}

	public Date getBill_dateTime() {
		return bill_dateTime;
	}

	public void setBill_dateTime(Date bill_dateTime) {
		this.bill_dateTime = bill_dateTime;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getBill_reward_points() {
		return bill_reward_points;
	}

	public void setBill_reward_points(int bill_reward_points) {
		this.bill_reward_points = bill_reward_points;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bill_Status getBill_status() {
		return bill_status;
	}

	public void setBill_status(Bill_Status bill_status) {
		this.bill_status = bill_status;
	}

	public Payment_Method getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(Payment_Method payment_method) {
		this.payment_method = payment_method;
	}

//	public int getCustomer_id() {
//		return customer_id;
//	}
//
//	public void setCustomer_id(int customer_id) {
//		this.customer_id = customer_id;
//	}

	// Generate toString()
	
	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", bill_number=" + bill_number + ", bill_amt=" + bill_amt
				+ ", bill_dateTime=" + bill_dateTime + ", discount=" + discount + ", bill_reward_points="
				+ bill_reward_points + "]";
	}
}

package com.entlogics.hotelbookingsystem_jpa_mongo.entity;

//import java.sql.Date;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This entity class maps to employee table in hoteldb using mongo 

@Document(collection = "employee")
public class Employee {

	// Defining the fields & annotate the fields

	@Id
	private ObjectId objectId;
	
	@Field(value = "emp_id")
	private int emp_id;

	@Field(value = "emp_name")
	private String emp_name;

	@Field(value = "emp_salary")
	private String emp_salary;

	@Field(value = "emp_phone")
	private long emp_phone;

	@Field(value = "emp_address")
	private String emp_address;

	@Field(value = "emp_email")
	private String emp_email;

	@Field(value = "joining_date")
	private Date joining_date;

	@DBRef
	private Hotel hotel;

	@DBRef
	List<Booking> bookings;

	// no-arg constructor

	public Employee() {
		super();
	}

	// Constructor for Customer class

	public Employee(String emp_name, String emp_salary) {
		super();
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
	}

	// Generated Setters and getters

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(String emp_salary) {
		this.emp_salary = emp_salary;
	}

	public long getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(long emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	// Generate toString()

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", emp_phone="
				+ emp_phone + ", emp_address=" + emp_address + ", emp_email=" + emp_email + ", joining_date="
				+ joining_date + "]";
	}
}

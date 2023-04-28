package com.entlogics.hotelbookingsystem_jpa_mongo.dao;

import java.util.List;

import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Customer;

//interface for Customer DAO having method declaration for all customer api endpoints
public interface ICustomerDAO {

	public List<Customer> getAllCustomers();

	public boolean addNewCustomer(Customer c);
	
	public boolean editACustomer(int customerId, Customer c);
	
	public Customer getCustomerInformation(int customerId);
}

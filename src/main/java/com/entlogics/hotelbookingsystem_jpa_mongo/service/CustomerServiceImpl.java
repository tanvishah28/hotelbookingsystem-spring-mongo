package com.entlogics.hotelbookingsystem_jpa_mongo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entlogics.hotelbookingsystem_jpa_mongo.dao.ICustomerDAO;
import com.entlogics.hotelbookingsystem_jpa_mongo.dto.CustomerDTO;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Bill;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Booking;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Customer;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Hotel_Customer;

//this class implements Customer Service Interface & has implementation for all Customer api endpoints

@Service
public class CustomerServiceImpl implements ICustomerService {

	// create logger object
	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

	// injecting Customer DAO using field injection
	@Autowired
	private ICustomerDAO customerDAO;

	@Override
	public List<CustomerDTO> getAllCustomers() {

		logger.info("Inside Customer Service getAllCustomers()");

		// creating list of type Customer and calling DAO method to getAllCustomers
		List<Customer> customerList = customerDAO.getAllCustomers();

		// Creating a list of CustomerDTO type and using stream to map customer objects
		// to customerDTO objects
		List<CustomerDTO> customerDtoList = customerList.stream().map(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomer_id(customer.getCustomer_id());
			customerDTO.setCustomer_name(customer.getCustomer_name());
			customerDTO.setCustomer_phone(customer.getCustomer_phone());
			customerDTO.setCustomer_email(customer.getCustomer_email());
			customerDTO.setPreferences(customer.getPreferences());
			customerDTO.setSpecial_needs(customer.getSpecial_needs());

			// Fetching booking, bill & hotel ids from respective list's and setting them in
			// customerDTO
			List<Integer> bookingIds = customer.getBookings().stream().map(Booking::getBooking_id)
					.collect(Collectors.toList());
			List<Integer> billIds = customer.getBills().stream().map(Bill::getBill_id).collect(Collectors.toList());
			List<Integer> hotelIds = customer.getHotels().stream().map(Hotel_Customer::getHotel_id)
					.collect(Collectors.toList());

			customerDTO.setHotels(hotelIds);
			customerDTO.setBills(billIds);
			customerDTO.setBookings(bookingIds);
			return customerDTO;
		}).collect(Collectors.toList());

		return customerDtoList;
	}

	// this method will create a transaction & return add customer method to DAO
	@Override
	public boolean addNewCustomer(Customer c) {

		logger.info("Inside Customer Service addNewCustomer() " + c);

		return customerDAO.addNewCustomer(c);
	}

	// this method will create a transaction & return edit customer method to DAO
	@Override
	public boolean editACustomer(int customerId, Customer c) {

		logger.info("Inside Customer Service editACustomer() " + customerId + " " + c);

		return customerDAO.editACustomer(customerId, c);
	}

	@Override
	public CustomerDTO getCustomerInformation(int customerId) {

		logger.info("Inside Customer Service getCustomerInformation() " + customerId);

		// create a customer object & get one customer
		Customer customer = customerDAO.getCustomerInformation(customerId);

		// create obj of CustomerDTO
		CustomerDTO customerDTO = new CustomerDTO();

		// set the customer obj properties
		customerDTO.setCustomer_id(customer.getCustomer_id());
		customerDTO.setCustomer_name(customer.getCustomer_name());
		customerDTO.setCustomer_address(customer.getCustomer_address());
		customerDTO.setCustomer_phone(customer.getCustomer_phone());
		customerDTO.setCustomer_email(customer.getCustomer_email());
		customerDTO.setPreferences(customer.getPreferences());
		customerDTO.setSpecial_needs(customer.getSpecial_needs());

		// creating list of Integer for booking ids & iterating through getBookings to
		// add Id to the list
		List<Integer> bookingIdsList = new ArrayList<>();

		for (Booking b : customer.getBookings()) {
			bookingIdsList.add(b.getBooking_id());
		}

		// creating list of Integer for bill ids & iterating through getBookings to add
		// Id to the list
		List<Integer> billIdsList = new ArrayList<>();

		for (Bill b : customer.getBills()) {
			billIdsList.add(b.getBill_id());
		}

		// creating list of Integer for hotel ids & iterating through getHotels to add
		// Id to the list
		List<Integer> hotelIdsList = new ArrayList<>();

		for (Hotel_Customer h : customer.getHotels()) {
			hotelIdsList.add(h.getHotel_id());
		}

		// set list of Integer (IDs) for booking,bill & hotel
		customerDTO.setBookings(bookingIdsList);
		customerDTO.setBills(billIdsList);
		customerDTO.setHotels(hotelIdsList);

		logger.info("Inside Customer Service getCustomerInformation() " + customerDTO);

		return customerDTO;
	}

}

package com.entlogics.hotelbookingsystem_jpa_mongo.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Bill;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Booking;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Customer;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Hotel_Customer;

//this class implements the CustomerDAO interface & has the implementation methods of all customer api endpoints - JPA

@Repository
public class CustomerDAOImpl implements ICustomerDAO {

	// inject mongoTemplate
	@Autowired
	private MongoTemplate mongoTemplate;

	// create logger object
	private static final Logger logger = LogManager.getLogger(CustomerDAOImpl.class);

	// gets list of all customers
	@Override
	public List<Customer> getAllCustomers() {

		logger.info("Inside getAllCustomers() in CustomerDAO");

		// creating list of arrays of Object and getting the result of query as a list
		List<Customer> listCustomer = mongoTemplate.findAll(Customer.class);
		
		// iterating through customer objects
		for(Customer c : listCustomer) {
			
			// creating criteria for customer_id and adding it to Query obj
			Criteria criteria = Criteria.where("customer_id").is(c.getCustomer_id());
			Query query = new Query(criteria);
			
			// Using query find bookings, bills and hotels of all customers
			List<Booking> bookings = mongoTemplate.find(query, Booking.class);
			List<Bill> bills = mongoTemplate.find(query, Bill.class);
			List<Hotel_Customer> hotels = mongoTemplate.find(query, Hotel_Customer.class);
			
			// Set list of bookings, bills & Hotels object to Customer
			c.setBookings(bookings);
			c.setBills(bills);
			c.setHotels(hotels);
			
			logger.info("Inside getAllCustomers() in CustomerDAO customer: "+ c);
			
//			listCustomer.add(c);
		}

		// returning list of customer - listCustomer
		return listCustomer;
	}

	// adds a new customer object
	@Override
	public boolean addNewCustomer(Customer c) {

		logger.info("Inside addNewCustomer in CustomerDAO " + c);

		// a boolean obj indicating success or failure of adding a customer
		boolean isSuccess = false;

		// using persist method to save new customer obj to DB
		mongoTemplate.insert(c, "customer");

		// set isSuccess to true after successfully saving customer
		isSuccess = true;

		// send success msg back to controller
		return isSuccess;
	}

	// edits a customer object in DB
	@Override
	public boolean editACustomer(int customerId, Customer c) {

		logger.info("Inside editACustomer in CustomerDAO " + customerId + " Customer: " + c);

		// creating boolean variable & setting it to false
		boolean isSuccess = false;

		Query query = new Query(Criteria.where("customer_id").is(customerId));
		Update update = new Update().set("customer_name", c.getCustomer_name())
				.set("customer_address", c.getCustomer_address()).set("customer_phone", c.getCustomer_phone())
				.set("customer_email", c.getCustomer_email()).set("preferences", c.getPreferences())
				.set("special_needs", c.getSpecial_needs());

//		FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true);

		mongoTemplate.findAndModify(query, update, Customer.class, "customer");

		// setting isSuccess to true after successfully editing customer object
		isSuccess = true;

		logger.info("Inside CustomerDAO editACustomer customer: " + c + " Success: " + isSuccess);

		return isSuccess;
	}

	// this method will return information of a single customer with its booking,
	// bill & hotel details
	@Override
	public Customer getCustomerInformation(int customerId) {

		logger.info("Inside getCustomerInformation in CustomerDAO " + customerId);

		Criteria criteria1 = Criteria.where("customer_id").is(customerId);

		Query query = new Query(criteria1);
		Customer customer = mongoTemplate.findOne(query, Customer.class);

		logger.info("Inside getCustomerInformation in CustomerDAO " + customer);

		// create a list of bookings and get list of bookings of a customer using
		// getBookings
		List<Booking> listBooking = mongoTemplate.find(query, Booking.class);
		List<Bill> listBill = mongoTemplate.find(query, Bill.class);
		List<Hotel_Customer> listHotel = mongoTemplate.find(query, Hotel_Customer.class);

		// iterate over the list of bookings to lazy load the booking object
		for (Booking b : listBooking) {
			// print booking id using booking object
			logger.info("Inside CustomerDAO getCustomerInformation() Booking id: " + b.getBooking_id());
		}

		for (Bill b : listBill) {
			// print bill id
			logger.info("Inside CustomerDAO getCustomerInformation() Bill id: " + b.getBill_id());
		}

		for (Hotel_Customer hc : listHotel) {
			// print hotel id
			logger.info("Inside CustomerDAO getCustomerInformation() Hotel id: " + hc.getHotel_id());
		}

		customer.setBookings(listBooking);
		customer.setBills(listBill);
		customer.setHotels(listHotel);

		return customer;
	}

}

package com.entlogics.hotelbookingsystem_jpa_mongo.dao;

import java.util.ArrayList;
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
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Hotel;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Hotel_Customer;

// this class implements the HotelDAO interface & has the implementation methods of all hotel api endpoints - MongoDB

@Repository
public class HotelDAOImpl implements IHotelDAO {

	// inject mongoTemplate
	@Autowired
	private MongoTemplate mongoTemplate;

//	@Autowired
//	private MongoOperations mongoOperations;

	// create logger object
	private static final Logger logger = LogManager.getLogger(HotelDAOImpl.class);

	// returns a list of Hotel objects based on search parameter passed
	@Override
	public List<Hotel> getAllHotels(String... args) {

		String hotel_name = "";

		for (String hotelName : args) {
			hotel_name = hotelName;
		}

		logger.info("Inside getAllHotels() in DAO with arguments HOTEL_NAME : " + hotel_name);

		// creating list of arrays of Hotel Object and using findAll() of mongoTemplate,
		// find all documents from Hotel
		List<Hotel> listHotel = mongoTemplate.findAll(Hotel.class);

		logger.info("Inside getAllHotels() in DAO :" + listHotel);

		// return the hotelList
		return listHotel;
	}

	// adds a new hotel object to the db
	@Override
	public boolean addNewHotel(Hotel h) {

		logger.info("Inside HotelDAO addNewHotel()");

		// a boolean object indicating the success/failure of adding new hotel
		boolean isSuccess = false;

		logger.info("Printing hotel object in the HotelDAO addNewHotel()" + h + " " + isSuccess);

		// insert the hotel using mongoTemplate insert into "hotel" collection
		mongoTemplate.insert(h, "hotel");

		// set isSuccess to true after successfully saving hotel
		isSuccess = true;

		logger.info("Printing hotel object in the HotelDAO addNewHotel() After Persisting" + h + " " + isSuccess);

		// Send a success message back to Controller
		return isSuccess;
	}

	// edits a hotel object in the db
	@Override
	public boolean editAHotel(int hotelId, Hotel h) {

		logger.info("Inside HotelDAO editAHotel()");

		// declaring boolean variable to track the status of method execution
		boolean isSuccess = false;

		// Using query to create a criteria for hotelId
		Query query = new Query(Criteria.where("hotel_id").is(hotelId));

		// creating update clause to set updated hotel object
		Update update = new Update().set("hotel_name", h.getHotel_name()).set("hotel_location", h.getHotel_location())
				.set("hotel_phone", h.getHotel_phone()).set("hotel_email", h.getHotel_email())
				.set("hotel_rating", h.getHotel_rating()).set("pet_friendly", h.isPet_friendly());

		// using mongoTemplate's updateFirst() to update a hotel using the created query
		mongoTemplate.updateFirst(query, update, Hotel.class);

		isSuccess = true;
		logger.info("Hotel in editAHotel() DAO: " + h + " " + " Success: " + isSuccess);

		// Send a success message back to Controller
		return isSuccess;
	}

	// deletes a hotel from the db
	@Override
	public boolean deleteAHotel(int hotelId) {

		logger.info("Inside HotelDAO deleteAHotel()" + hotelId);

		// declaring boolean variable to track the status of method execution
		boolean isSuccess = false;

		// Using query to create a criteria for hotelId
		Query query = new Query(Criteria.where("hotel_id").is(hotelId));

		// when hotel id is incorrect (not exist) isSuccess will be false
		logger.info("Inside HotelDAO deleteAHotel() before deleting " + isSuccess);

		// delete the hotel using mongoTemplate's remove()
		mongoTemplate.remove(query, "hotel");

		// after successfully deleting hotel, making isSuccess boolean variable true
		isSuccess = true;

		logger.info("Inside HotelDAO deleteAHotel() after deleting " + isSuccess);

		return isSuccess;
	}

	// gets one hotel object (single row of a table) from db
	@Override
	public Hotel getHotelInformation(int hotelId) {

		logger.info("Inside HotelDAO getHotelInformation(): " + hotelId);

		// creating hotel object (variable)
		Hotel hotel;

		Query query = new Query(Criteria.where("hotel_id").is(hotelId));
		hotel = mongoTemplate.findOne(query, Hotel.class);

		logger.info("Inside getHotelInformation DAO, hotel object (before): " + hotel);

		// returning hotel object with bookings, services, customers, employees
		return hotel;
	}

	// this methods gets single customer of a hotel from db
	@Override
	public Customer getCustomerInformation(int hotelId, int customerId) {

		logger.info("Inside HotelDAO getCustomerInformation(), hotel id: " + hotelId + " customer id: " + customerId);

		Criteria criteria1 = Criteria.where("customer_id").is(customerId);

		Query query = new Query(criteria1);
		Customer customer = mongoTemplate.findOne(query, Customer.class);

		logger.info("Inside getCustomerInformation DAO, customer object: " + customer + " CustomerID: " + query);

		// create a list of bookings and get list of bookings of a customer using
		// getBookings
		List<Booking> listBooking = mongoTemplate.find(query, Booking.class);

		logger.info("Inside DAO getCustomerInformation() Booking of customer: " + listBooking);

		// iterate over the list of bookings to lazy load the booking object
		for (Booking b : listBooking) {

			// print booking id using booking object
			logger.info("Inside DAO getCustomerInformation() Booking id: " + b.getBooking_id());
		}

		List<Bill> listBill = mongoTemplate.find(query, Bill.class);

		// iterate over the list of bills to lazy load the bill object
		for (Bill b : listBill) {

			// print bill id using bill object
			logger.info("Inside DAO getCustomerInformation() Bill id: " + b.getBill_id());
		}

		customer.setBookings(listBooking);
		customer.setBills(listBill);

		// returning customer object
		return customer;
	}

	// this method gets all customers of a hotel
	@Override
	public List<Customer> getCustomersOfAHotel(int hotelId) {

		logger.info("Inside HotelDAO getCustomersOfAHotel(), hotel id: " + hotelId);

		// Define a query object with the criteria
		Query query = new Query(Criteria.where("hotel_id").is(hotelId));

		logger.info("Inside HotelDAO getCustomersOfAHotel(), query : " + query);

		// Find list of hotels from Hotel_Customer using the hotel id
		List<Hotel_Customer> hotelList = mongoTemplate.find(query, Hotel_Customer.class);

		logger.info("Inside HotelDAO getCustomersOfAHotel(), HotelCustomer List : " + hotelList);

		// Create an empty list of integers to store customer ids
		List<Integer> customerIdList = new ArrayList<>();

		// iterate the hotel_customer list and fetch customer ids of the particular hotel
		for (Hotel_Customer hc : hotelList) {
			customerIdList.add(hc.getCustomer_id());
		}

		logger.info("Inside HotelDAO getCustomersOfAHotel(), CustomerIDList : " + customerIdList);
		
		// Define Criteria to match customer id in the customerIdList and create a Query obj with the same
		Criteria criteria1 = Criteria.where("customer_id").in(customerIdList);
		Query query1 = new Query(criteria1);
		List<Customer> customerList = mongoTemplate.find(query1, Customer.class);

		logger.info("Inside HotelDAO getCustomersOfAHotel() CustomerList: " + customerList);

		return customerList;
	}
}

package com.entlogics.hotelbookingsystem_jpa_mongo.service;

import java.util.List;

import com.entlogics.hotelbookingsystem_jpa_mongo.dto.HotelCustomerDTO;
import com.entlogics.hotelbookingsystem_jpa_mongo.dto.HotelCustomerInformationDTO;
import com.entlogics.hotelbookingsystem_jpa_mongo.dto.HotelDTO;
import com.entlogics.hotelbookingsystem_jpa_mongo.dto.HotelInformationDTO;
import com.entlogics.hotelbookingsystem_jpa_mongo.entity.Hotel;

//interface for Hotel Service layer having method declaration for all hotel api endpoints

public interface IHotelService {

//	public List<HotelDTO> getAllHotels(Boolean isSearch, String hotel_name);
//	public List<HotelDTO> getAllHotels(String hotel_name);
	
	public List<HotelDTO> getAllHotels(String... args);

	public boolean addNewHotel(Hotel h);

	public HotelInformationDTO getHotelInformation(int hotelId);

	public boolean deleteAHotel(int hotelId);

	public boolean editAHotel(int hotelId, Hotel h);
	
	public HotelCustomerInformationDTO getCustomerInformation(int hotelId, int customerId);

	public List<HotelCustomerDTO> getCustomersOfAHotel(int hotelId);
}

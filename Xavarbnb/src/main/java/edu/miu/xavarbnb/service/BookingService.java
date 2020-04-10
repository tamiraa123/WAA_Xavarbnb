package edu.miu.xavarbnb.service;

import java.time.LocalDate;
import java.util.List;

import edu.miu.xavarbnb.domain.Booking;
import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.domain.User;

public interface BookingService {
	public List<Booking> getBookingsBytProperty(Long propertyId);
//	
	public List<Booking> getBookingsByUser(Long userId);
	
	public Booking bookProperty(Booking booking);
	
	public Booking getOverlappingBooking(LocalDate checkIn, LocalDate checkOut, Long propertyId);
}

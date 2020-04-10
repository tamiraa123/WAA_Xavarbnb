package edu.miu.xavarbnb.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.miu.xavarbnb.domain.Booking;
import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.repository.BookingRepository;
import edu.miu.xavarbnb.service.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<Booking> getBookingsBytProperty(Long propertyId) {
		return bookingRepository.findBookingsByProperty(propertyId);
//		return null;
	}
	
	@Override
	public List<Booking> getBookingsByUser(Long userId) {
		return bookingRepository.findBookingsByUser(userId);
//		return null;
	}
	
	@Override
	public Booking bookProperty(Booking booking) {
		return bookingRepository.save(booking);
//		return null;
	}
	
	@Override
	public Booking getOverlappingBooking(LocalDate checkIn, LocalDate checkOut, Long propertyId) {
		return bookingRepository.getOverlappingBooking(checkIn, checkOut, propertyId);
	}

}

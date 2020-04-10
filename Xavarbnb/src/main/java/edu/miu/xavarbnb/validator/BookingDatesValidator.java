package edu.miu.xavarbnb.validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.miu.xavarbnb.domain.Booking;
import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.service.BookingService;

@Component
public class BookingDatesValidator implements ConstraintValidator<BookingDates, Booking>{
	
	@Autowired
	private BookingService bookingService;
	
	private String checkInFieldName;

	@Override
	public void initialize(final BookingDates constraintAnnotation) {
	}

	@Override
	public boolean isValid(Booking booking, ConstraintValidatorContext context) {
		LocalDate checkIn = booking.getCheckIn();
		LocalDate checkOut = booking.getCheckOut();
		Property property = booking.getProperty();
		
		System.out.println("Validating");
		
		if (checkIn.isBefore(java.time.LocalDate.now()) || (checkOut.isBefore(checkIn.plusDays(1)))) {
			return false;
		}

		return true;
	}
	
}

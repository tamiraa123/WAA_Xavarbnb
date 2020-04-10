package edu.miu.xavarbnb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.miu.xavarbnb.domain.Booking;
import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/propertyBookings", method = RequestMethod.GET)
	public String listBookingsBytProperty(Model model, @RequestParam("propertyId") Long propertyId) {
		model.addAttribute("propertyBookings", bookingService.getBookingsBytProperty(propertyId));
		return "propertyBookings";
	}
	
	@RequestMapping(value = "/userBookings", method = RequestMethod.GET)
	public String listBookingsByUser(Model model, @RequestParam("userId") Long userId) {
		model.addAttribute("userBookings", bookingService.getBookingsByUser(userId));
		return "userBookings";
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.GET)
	public String addBooking(@ModelAttribute("newBooking") Booking newbooking) {
		return "addBooking";
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public String saveBooking(@Valid @ModelAttribute("newBooking") Booking booking,
							  BindingResult bindingResult,
							  RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			return "addBooking";
		}
		
//		// Validate that the selected dates are available for booking (select from DB)
//		Booking book = bookingService.getOverlappingBooking(booking.getCheckIn(), booking.getCheckOut()
//				, (booking.getProperty()).getId());
		
//		System.out.println("check");
//		System.out.println(book.getId());
		
		Booking newBooking = bookingService.bookProperty(booking);
		redirectAttributes.addFlashAttribute( "newBooking", newBooking);
		
		
		return "redirect:/booking/propertyBooked";
	}
	
	@RequestMapping(value = "/propertyBooked", method = RequestMethod.GET)
	public String bookingDetails(Model model) {
		Booking booking = (Booking)(((ModelMap) model).get("newBooking"));
		System.out.println(booking.getId());
		return "bookingDetails";
	}

}

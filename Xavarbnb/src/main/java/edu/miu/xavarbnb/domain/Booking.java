package edu.miu.xavarbnb.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.miu.xavarbnb.validator.*;

@Entity
@BookingDates
public class Booking implements Serializable{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER) //, cascade=CascadeType.ALL)
	@JoinColumn(name = "id")
	private User renter;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="property_id")
	private Property property;
	
	@NotNull
	@Min(1)
	private Integer numberOfGuests;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate checkIn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate checkOut;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Review review;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getRenter() {
		return renter;
	}

	public void setRenter(User renter) {
		this.renter = renter;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	
	
	
}

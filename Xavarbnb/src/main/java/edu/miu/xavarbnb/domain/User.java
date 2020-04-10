package edu.miu.xavarbnb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Email(message="{Email}")
  	private String email;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="person_id")
 	private Person person;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Property> properties;
	
	@OneToOne(fetch=FetchType.EAGER) 
 	@JoinColumn(name="cred_id") 
	@Valid
 	UserCredentials userCredentials;
	
	@OneToMany(mappedBy="renter",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Booking> bookings;
	
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
//	public List<Booking> getBookings() {
//		return bookings;
//	}
	public Long getId() {
		return id;
	}
//
	public Person getPerson() {
		return person;
	}
	public String getEmail() {
		return email;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

 	public UserCredentials getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}
 	

  }

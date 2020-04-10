package edu.miu.xavarbnb.domain;

import java.io.Serializable;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Property implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="property_id")
	private Long id;
	@NotNull(message="NotNull")
	private Integer bedroom;
	@NotNull(message="NotNull")
	private Integer restroom;
	@NotNull(message="NotNull")
	private Integer garage;
	@NotNull(message="NotNull")
	private Integer capacity;
	@NotEmpty(message="NotEmpty")
	private String description;
	private Double rating;
	private Integer bookedNumber;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="address_id")
	private Address address;

	private Double price;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User owner;
	@Enumerated(EnumType.STRING)
	private PropertyStatus status;
	@Enumerated(EnumType.STRING)
	private PropertyType type;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Amenity> amenities;
	
	private String imagePath;
	//@Transient
	@Lob
	private MultipartFile propertyImage;
	
	public Long getId() {
		return id;
	}
	public Integer getBedroom() {
		return bedroom;
	}
	public Integer getRestroom() {
		return restroom;
	}
	public Integer getGarage() {
		return garage;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public Address getAddress() {
		return address;
	}
	public Double getPrice() {
		return price;
	}
	public User getOwner() {
		return owner;
	}
	public PropertyStatus getStatus() {
		return status;
	}
	public PropertyType getType() {
		return type;
	}
	public List<Amenity> getAmenities() {
		return amenities;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBedroom(Integer bedroom) {
		this.bedroom = bedroom;
	}
	public void setRestroom(Integer restroom) {
		this.restroom = restroom;
	}
	public void setGarage(Integer garage) {
		this.garage = garage;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public void setStatus(PropertyStatus status) {
		this.status = status;
	}
	public void setType(PropertyType type) {
		this.type = type;
	}
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}
	public void addAmenity(Amenity amenity) {
		amenities.add(amenity);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Integer getBookedNumber() {
		return bookedNumber;
	}
	public void setBookedNumber(Integer bookedNumber) {
		this.bookedNumber = bookedNumber;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public MultipartFile getPropertyImage() {
		return propertyImage;
	}
	public void setPropertyImage(MultipartFile propertyImage) {
		this.propertyImage = propertyImage;
	}
}

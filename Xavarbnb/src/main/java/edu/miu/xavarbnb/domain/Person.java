package edu.miu.xavarbnb.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Person implements Serializable{
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message = "{NotNull}")
	@Size(min = 4, max = 25, message = "{Size}")
	private String firstName;
	
	private String lastName;
	
	private LocalDate dob;
	@Lob
	@Basic(fetch = FetchType.LAZY)
    private byte[] personImage;
	
	public byte[] getPersonImage() {
		return personImage;
	}

	public void setPersonImage(byte[] personImage) {
		this.personImage = personImage;
	}

	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getDob() {
		return dob;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	
}

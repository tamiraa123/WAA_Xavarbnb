package edu.miu.xavarbnb.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long userId;
	private Long propertyId;
	private int rate;
	private String comment;
	public Long getId() {
		return id;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public int getRate() {
		return rate;
	}
	public String getComment() {
		return comment;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

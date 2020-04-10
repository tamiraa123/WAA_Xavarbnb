package edu.miu.xavarbnb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotEmpty(message = "{NotEmpty}")
	private String userName;
  	@Column(nullable = false)
 	private String authority = "USER_ROLE" ;
 	
	 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
 
 	
}

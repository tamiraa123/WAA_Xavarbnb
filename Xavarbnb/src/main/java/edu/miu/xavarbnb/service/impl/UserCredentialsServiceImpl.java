package edu.miu.xavarbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.xavarbnb.domain.UserCredentials;
import edu.miu.xavarbnb.repository.UserCredentialsRepository;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements edu.miu.xavarbnb.service.UserCredentialsService {
	
 	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

 	@Autowired
 	BCryptPasswordEncoder passwordEncoder;
 	
  	//@PreAuthorize("hasRole('ROLE_ADMIN')")
  	public void save(UserCredentials credentials) {
	
   		String encodedPassword = passwordEncoder.encode(credentials.getPassword());
  		System.out.println(""+credentials.getPassword());
   		credentials.setPassword(encodedPassword);
  		
  		
  		userCredentialsRepository.save(credentials);
  		   	
	}
  
     public void update( UserCredentials userCredentials) {  		
  		userCredentialsRepository.save(userCredentials);
	}
 	
  	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsRepository.findAll();
	}
	
	public UserCredentials findOne(String id){
		return userCredentialsRepository.findOne(id);
	}


	public UserCredentials findByUsername(String userName) {
		return userCredentialsRepository.findByUsername(userName);
	}

 
}

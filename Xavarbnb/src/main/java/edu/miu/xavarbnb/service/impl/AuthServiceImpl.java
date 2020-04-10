package edu.miu.xavarbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.xavarbnb.domain.Authority;
import edu.miu.xavarbnb.domain.UserCredentials;
import edu.miu.xavarbnb.repository.AuthRepository;
import edu.miu.xavarbnb.repository.UserCredentialsRepository;

@Service
@Transactional 
public class AuthServiceImpl implements edu.miu.xavarbnb.service.AuthService {
	
 	@Autowired
	private AuthRepository authRepository;

 	
	@Override
	public void save(Authority authority) {
		authRepository.save(authority);
	}

 
}

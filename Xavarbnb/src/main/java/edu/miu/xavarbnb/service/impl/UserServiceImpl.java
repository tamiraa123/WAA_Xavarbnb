package edu.miu.xavarbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.xavarbnb.domain.Authority;
import edu.miu.xavarbnb.domain.User;
import edu.miu.xavarbnb.repository.AuthRepository;
import edu.miu.xavarbnb.repository.UserCredentialsRepository;
import edu.miu.xavarbnb.repository.UserRepository;
import edu.miu.xavarbnb.service.AuthService;
import edu.miu.xavarbnb.service.UserCredentialsService;

@Service
@Transactional 
public class UserServiceImpl implements edu.miu.xavarbnb.service.UserService {
	
 	@Autowired
	private UserRepository userRepository;

 	@Autowired
 	UserCredentialsService credentialsService;
 	
 	@Autowired
 	AuthRepository authRepository;
	
    @Override
 	//@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void saveFull( User user) {
    	Authority auth = new Authority();
    	auth.setUserName(user.getUserCredentials().getUsername());
    	
    	authRepository.save(auth);
    	credentialsService.save(user.getUserCredentials());
  		userRepository.save(user);	
	}
    @Override
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}
	@Override
	public User findByUserId(Long id) {
		return (User) userRepository.findOne(id);
	}
	@Override
	public void deleteById(Long id) {
		userRepository.delete(id);
	}
	@Override
	public void updateById(User user, Long id) {
		userRepository.save(user);
	}
	
//	@Override
//	public List<User> getAllUsers() {
//		return userRepository.getAllUser();
//	}
//	@Override
//	public List<User> getAllAdmin() {
//		return userRepository.getAllAdmin();
//	}
//	@Override
//	public List<User> getMostPropertyOwningUser() {
//		
//		return userRepository.getMostPropertyOwningUser();
//	}
	
}

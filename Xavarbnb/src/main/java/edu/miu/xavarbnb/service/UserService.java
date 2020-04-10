package edu.miu.xavarbnb.service;

import java.util.List;
import java.util.Set;

import edu.miu.xavarbnb.domain.User;
 
public interface UserService {

    public void saveFull( User user);  		
	public List<User> findAll();
	public User findByUserId(Long id);
	public void deleteById(Long id);
	public void updateById(User user,Long id);
	//List<User> getAllUsers();
	//List<User> getAllAdmin();
	//List<User> getMostPropertyOwningUser();
}

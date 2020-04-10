package edu.miu.xavarbnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.xavarbnb.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	  //public User findByUserId(Long id);
//	@Query("SELECT u FROM User u JOIN u.Authority a WHERE a.authority = 'USER_ROLE'")
//	public List<User> getAllUser();
//	
//	@Query("SELECT u FROM User u JOIN u.Authority a WHERE a.authority = 'USER_ADMIN'")
//	public List<User> getAllAdmin();
	
//	@Query("SELECT p AS user, count(pv) AS properties FROM User p LEFT JOIN Properties pv ON p.p_id = pv.id GROUP BY p ORDER BY properties DESC")
//	public List<User> getMostPropertyOwningUser();
		
 	}

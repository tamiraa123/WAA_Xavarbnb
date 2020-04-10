package edu.miu.xavarbnb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.xavarbnb.domain.Authority;

@Repository
public interface AuthRepository extends CrudRepository<Authority,String> {

}

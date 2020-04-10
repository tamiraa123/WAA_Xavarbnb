package edu.miu.xavarbnb.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.miu.xavarbnb.domain.Amenity;


	@Repository
	public interface AmenityRepository extends  CrudRepository<Amenity, Long> {
		public static final String FIND_BY_ID_QUERY = "select a from Amenity a where id = :id";
		public static final String FIND_BY_PROPERTY_QUERY = "select a from Amenity a where a.propertyId = :propertyId";
		public static final String DELETE_BY_ID_QUERY = "delete from Amenity a where id = :id";
		
		@Query(FIND_BY_ID_QUERY)
		Amenity findAmenityById(@Param("id") Long id);
		
		@Query(FIND_BY_PROPERTY_QUERY)
		List<Amenity> getAmenitiesByProperty(@Param("propertyId") Long propertyId);

		@Modifying
		@Transactional
		@Query(DELETE_BY_ID_QUERY)
		void delete(@Param("id") Long id);
  	}


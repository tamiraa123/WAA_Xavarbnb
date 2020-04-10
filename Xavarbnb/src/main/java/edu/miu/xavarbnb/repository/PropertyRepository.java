package edu.miu.xavarbnb.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.domain.PropertyStatus;

	@Repository
	public interface PropertyRepository extends  CrudRepository<Property, Long> {
		public static final String FIND_BY_STATUS_QUERY = "select p from Property p where status = :status";
		public static final String FIND_BY_ID_QUERY = "select p from Property p where property_id = :property_id";
		public static final String FIND_BY_FILTER_QUERY = "select distinct(p) from Property p where p.address.city = :city and p.price between :minPrice and :maxPrice and p.capacity=:capacity";
		public static final String FIND_BY_OWNER_QUERY = "select p from Property p where p.owner = :owner_id";
		public static final String DELETE_BY_ID_QUERY = "delete from Property p where property_id = :property_id";
		
		@Query(FIND_BY_STATUS_QUERY)
		List<Property> getPropertiesByStatus(@Param("status") PropertyStatus status);
		
		@Query(FIND_BY_ID_QUERY)
		Property findPropertyById(@Param("property_id") Long property_id);
		
		@Query(FIND_BY_FILTER_QUERY)
		List<Property> getPropertiesByFilter(@Param("city") String city, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, @Param("capacity") Integer capacity);
		
		@Query(FIND_BY_OWNER_QUERY)
		List<Property> getPropertiesByOwner(@Param("owner_id") Long owner_id);

		@Modifying
		@Transactional
		@Query(DELETE_BY_ID_QUERY)
		void delete(@Param("property_id") Long property_id);
  	}


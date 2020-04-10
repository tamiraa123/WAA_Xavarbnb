package edu.miu.xavarbnb.service;

import java.util.List;

import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.domain.PropertyStatus;

public interface PropertyService {
	public List<Property> getAll();
	public Property save(Property product);	
	public List<Property> getPropertiesByStatus(PropertyStatus status);
	public Property findPropertyById(Long id);
	public List<Property> getPropertiesByFilter(String city, Double minPrice, Double maxPrice, Integer capacity);
	public List<Property> getPropertiesByOwner(Long id);
	public void delete(Long id);
}

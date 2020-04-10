package edu.miu.xavarbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.domain.PropertyStatus;
import edu.miu.xavarbnb.repository.PropertyRepository;
import edu.miu.xavarbnb.service.PropertyService;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService{
	@Autowired
	PropertyRepository propertyRepository;
	
	@Override
  	public List<Property> getAll() {
		return  (List<Property>) propertyRepository.findAll();
	}
	
  	@Override
	public Property save(Property property) {
		return propertyRepository.save(property);
	}

	@Override
	public List<Property> getPropertiesByStatus(PropertyStatus status) {
		return propertyRepository.getPropertiesByStatus(status);
	}

	@Override
	public Property findPropertyById(Long id) {
		return propertyRepository.findPropertyById(id);
	}

	@Override
	public List<Property> getPropertiesByFilter(String city, Double minPrice, Double maxPrice, Integer capacity) {
		return propertyRepository.getPropertiesByFilter(city, minPrice, maxPrice, capacity);
	}

	@Override
	public List<Property> getPropertiesByOwner(Long id) {
		return propertyRepository.getPropertiesByOwner(id);
	}

	@Override
	public void delete(Long id) {
		propertyRepository.delete(id);
	}
}

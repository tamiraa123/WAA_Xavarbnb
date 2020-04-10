package edu.miu.xavarbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.xavarbnb.domain.Amenity;
import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.domain.PropertyStatus;
import edu.miu.xavarbnb.repository.AmenityRepository;
import edu.miu.xavarbnb.repository.PropertyRepository;
import edu.miu.xavarbnb.service.AmenityService;
import edu.miu.xavarbnb.service.PropertyService;

@Service
@Transactional
public class AmenityServiceImpl implements AmenityService{
	@Autowired
	AmenityRepository amenityRepository;
	
	@Override
  	public List<Amenity> getAll() {
		return  (List<Amenity>) amenityRepository.findAll();
	}
	
  	@Override
	public Amenity save(Amenity amenity) {
		return amenityRepository.save(amenity);
	}

	@Override
	public Amenity findAmenityById(Long id) {
		return amenityRepository.findAmenityById(id);
	}

	@Override
	public List<Amenity> getAmenitiesByProperty(Long id) {
		return amenityRepository.getAmenitiesByProperty(id);
	}

	@Override
	public void delete(Long id) {
		amenityRepository.delete(id);
	}
}

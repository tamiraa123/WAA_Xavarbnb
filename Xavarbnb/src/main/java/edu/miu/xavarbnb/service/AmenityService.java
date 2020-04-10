package edu.miu.xavarbnb.service;

import java.util.List;

import edu.miu.xavarbnb.domain.Amenity;

public interface AmenityService {
	public List<Amenity> getAll();
	public Amenity save(Amenity amenity);	
	public Amenity findAmenityById(Long id);
	public List<Amenity> getAmenitiesByProperty(Long id);
	public void delete(Long id);
}

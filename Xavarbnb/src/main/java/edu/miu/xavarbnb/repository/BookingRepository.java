package edu.miu.xavarbnb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.xavarbnb.domain.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

	@Query("select b from Booking b left join fetch b.property p where p.id = :id")
	public List<Booking> findBookingsByProperty(@Param("id") Long propertyId);

	@Query("select b from Booking b left join fetch b.renter r where r.id = :id")
	public List<Booking> findBookingsByUser(@Param("id") Long renterId);

	@Query("select b from Booking b left join fetch b.property p where p.id = :id and b.checkIn <= :checkOut and b.checkOut > :checkIn")
	public Booking getOverlappingBooking(@Param("checkIn") LocalDate checkIn, 
											   @Param("checkOut") LocalDate checkOut, 
											   @Param("id") Long propertyId);	

//	@Override
//	public Booking save(Booking booking);

	

}

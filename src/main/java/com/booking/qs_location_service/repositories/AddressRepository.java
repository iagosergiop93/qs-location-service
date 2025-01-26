package com.booking.qs_location_service.repositories;

import com.booking.qs_location_service.domain.location.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {
}

package com.booking.qs_location_service.repositories;

import com.booking.qs_location_service.domain.location.Location;
import com.booking.qs_location_service.domain.location.LocationId;
import com.booking.qs_location_service.dtos.location.LocationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, LocationId> {

    @Query(value = "SELECT l.locationId, l.orgId, l.name, l.description, l.phone FROM locations l WHERE orgId = ?1", nativeQuery = true)
    List<LocationDto> findByOrgId(String orgId);
}

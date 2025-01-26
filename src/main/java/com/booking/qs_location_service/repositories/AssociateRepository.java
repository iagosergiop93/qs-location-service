package com.booking.qs_location_service.repositories;

import com.booking.qs_location_service.domain.associate.Associate;
import com.booking.qs_location_service.domain.associate.AssociateId;
import com.booking.qs_location_service.dtos.associate.AssociateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, AssociateId> {
    @Query(
            nativeQuery = true,
            value = "SELECT associateId,locationId,orgId,firstName,lastName,email,phone FROM associates a WHERE orgId = ?1 AND locationId = ?2"
    )
    List<AssociateDto> findByLocation(String orgId, String locationId);
}

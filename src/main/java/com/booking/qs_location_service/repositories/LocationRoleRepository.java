package com.booking.qs_location_service.repositories;

import com.booking.qs_location_service.domain.associate.AssociateRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRoleRepository extends JpaRepository<AssociateRole,String> {
}

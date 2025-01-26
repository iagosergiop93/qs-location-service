package com.booking.qs_location_service.domain.location;

import com.booking.qs_location_service.domain.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "location_types")
public class LocationType extends AbstractEntity<String> {
    @Id
    private String id;
    private String name;
}

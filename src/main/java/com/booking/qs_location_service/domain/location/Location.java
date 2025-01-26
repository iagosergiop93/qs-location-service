package com.booking.qs_location_service.domain.location;

import com.booking.qs_location_service.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "locations")
public class Location extends AbstractEntity<LocationId> {
    @EmbeddedId
    private LocationId id;
    private String name;
    private String description;
    private String phone;

    @OneToOne(optional = true)
    @JoinColumn(name = "location_type", referencedColumnName = "id", nullable = true)
    private LocationType locationType;

    @OneToOne(optional = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = true)
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}

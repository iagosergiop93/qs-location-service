package com.booking.qs_location_service.domain.location;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Objects;

@Data
@Embeddable
public class LocationId {
    private String locationId;
    private String orgId;

    LocationId(){}

    public LocationId(String locationId, String orgId) {
        this.locationId = locationId;
        this.orgId = orgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationId that = (LocationId) o;
        return Objects.equals(locationId, that.locationId) && Objects.equals(orgId, that.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, orgId);
    }
}

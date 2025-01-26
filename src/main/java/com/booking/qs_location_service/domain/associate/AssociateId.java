package com.booking.qs_location_service.domain.associate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AssociateId {
    private String associateId;
    private String locationId;
    private String orgId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssociateId that = (AssociateId) o;
        return Objects.equals(associateId, that.associateId) && Objects.equals(locationId, that.locationId) && Objects.equals(orgId, that.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(associateId, locationId, orgId);
    }
}

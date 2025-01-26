package com.booking.qs_location_service.domain.workinghours;

import com.booking.qs_location_service.domain.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "staff_availability")
public class WorkingHours extends AbstractEntity<String> {
    @Id
    private String id;
    private String orgId;
    private String locationId;
    private Instant date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer availableStaffCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingHours that = (WorkingHours) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

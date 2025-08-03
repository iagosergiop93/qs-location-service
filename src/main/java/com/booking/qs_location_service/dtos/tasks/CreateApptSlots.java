package com.booking.qs_location_service.dtos.tasks;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateApptSlots {
    private String orgId;
    private String locationId;
    private Integer slotDurationMinutes;
    private LocalDate startDate;
    private LocalDate endDate;
}

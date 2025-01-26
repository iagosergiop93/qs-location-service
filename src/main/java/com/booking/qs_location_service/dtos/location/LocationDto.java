package com.booking.qs_location_service.dtos.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private String locationId;
    private String orgId;
    private String name;
    private String description;
    private String phone;
}

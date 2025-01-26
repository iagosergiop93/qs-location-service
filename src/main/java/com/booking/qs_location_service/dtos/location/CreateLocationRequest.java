package com.booking.qs_location_service.dtos.location;

import lombok.Data;

@Data
public class CreateLocationRequest {
    private String locationId;
    private String orgId;
    private String name;
    private String description;
    private String phone;
    private AddressDto address;
}

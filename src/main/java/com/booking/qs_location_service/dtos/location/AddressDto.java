package com.booking.qs_location_service.dtos.location;

import lombok.Data;

@Data
public class AddressDto {
    private String id;
    private String street1;
    private String street2;
    private String zipCode;
    private String city;
    private String state;
    private String country;
}

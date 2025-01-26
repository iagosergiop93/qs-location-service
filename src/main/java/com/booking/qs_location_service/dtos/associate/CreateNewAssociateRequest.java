package com.booking.qs_location_service.dtos.associate;

import lombok.Data;

@Data
public class CreateNewAssociateRequest {
    private String associateId;
    private String locationId;
    private String orgId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

package com.booking.qs_location_service.dtos.associate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssociateDto {
    private String associateId;
    private String locationId;
    private String orgId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public AssociateDto(String associateId, String locationId, String orgId, String firstName, String lastName, String email, String phone) {
        this.associateId = associateId;
        this.locationId = locationId;
        this.orgId = orgId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}

package com.booking.qs_location_service.dtos.associate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAssociateByIdRequest {
    private String associateId;
    private String locationId;
    private String orgId;
}

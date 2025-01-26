package com.booking.qs_location_service.dtos.location;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetLocationByIdRequest {
    private String id;
    private String orgId;

    public GetLocationByIdRequest(String id, String orgId) {
        this.id = id;
        this.orgId = orgId;
    }
}

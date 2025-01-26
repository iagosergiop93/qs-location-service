package com.booking.qs_location_service.dtos.associate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetAssociatesByLocation {
    private String orgId;
    private String locId;

    public GetAssociatesByLocation(String orgId, String locId) {
        this.orgId = orgId;
        this.locId = locId;
    }
}

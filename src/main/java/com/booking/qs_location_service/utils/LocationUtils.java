package com.booking.qs_location_service.utils;

import com.booking.qs_location_service.domain.location.Location;
import com.booking.qs_location_service.domain.location.LocationId;
import com.booking.qs_location_service.dtos.location.CreateLocationRequest;

public class LocationUtils {

    public static Location createLocation(CreateLocationRequest request) {
        var location = new Location();
        var locationId = new LocationId(request.getLocationId(), request.getOrgId());
        location.setId(locationId);
        location.setName(request.getName());
        location.setDescription(request.getDescription());
        location.setPhone(request.getPhone());

        return location;
    }
}

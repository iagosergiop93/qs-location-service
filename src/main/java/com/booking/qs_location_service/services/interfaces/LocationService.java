package com.booking.qs_location_service.services.interfaces;

import com.booking.qs_location_service.domain.location.Location;
import com.booking.qs_location_service.dtos.Response;
import com.booking.qs_location_service.dtos.location.CreateLocationRequest;
import com.booking.qs_location_service.dtos.location.GetLocationByIdRequest;
import com.booking.qs_location_service.dtos.location.LocationDto;

import java.util.List;

public interface LocationService {
    Response<Location> createNewLocation(CreateLocationRequest request);
    Response<Location> getLocationById(GetLocationByIdRequest id);
    Response<List<LocationDto>> listLocationsByOrg(String orgId);
}

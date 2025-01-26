package com.booking.qs_location_service.controllers;

import com.booking.qs_location_service.domain.location.Location;
import com.booking.qs_location_service.dtos.Response;
import com.booking.qs_location_service.dtos.location.CreateLocationRequest;
import com.booking.qs_location_service.dtos.location.GetLocationByIdRequest;
import com.booking.qs_location_service.dtos.location.LocationDto;
import com.booking.qs_location_service.services.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService service;

    @GetMapping("api/location/{id}/org/{orgId}")
    public Response<Location> getLocationById(@PathVariable String id, @PathVariable String orgId) {
        var request = new GetLocationByIdRequest(id,orgId);
        return service.getLocationById(request);
    }

    @PostMapping("api/location")
    public Response<Location> createNewLocation(@RequestBody CreateLocationRequest request) {
        return service.createNewLocation(request);
    }

    @GetMapping("api/location/org/{orgId}")
    public Response<List<LocationDto>> listLocationsByOrg(@PathVariable String orgId) {
        return service.listLocationsByOrg(orgId);
    }
}

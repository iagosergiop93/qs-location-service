package com.booking.qs_location_service.controllers;

import com.booking.qs_location_service.domain.workinghours.WorkingHours;
import com.booking.qs_location_service.dtos.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkingHoursController {

    @PostMapping("/location/staffAvailability")
    public Response<WorkingHours> addStaffAvailability() {
        return null;
    }
}

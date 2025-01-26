package com.booking.qs_location_service.controllers;

import com.booking.qs_location_service.dtos.Response;
import com.booking.qs_location_service.dtos.associate.AssociateDto;
import com.booking.qs_location_service.dtos.associate.CreateNewAssociateRequest;
import com.booking.qs_location_service.dtos.associate.GetAssociateByIdRequest;
import com.booking.qs_location_service.dtos.associate.GetAssociatesByLocation;
import com.booking.qs_location_service.services.interfaces.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssociateController {

    @Autowired
    private AssociateService service;

    @GetMapping("/api/associate/{id}/location/{locId}/org/{orgId}")
    public Response<AssociateDto> getAssociateById(
            @PathVariable String id,
            @PathVariable String locId,
            @PathVariable String orgId
    ) {
        var request = new GetAssociateByIdRequest(id, locId, orgId);
        return service.getAssociateById(request);
    }

    @GetMapping("/api/associate/location/{locId}/org/{orgId}")
    public Response<List<AssociateDto>> listAssociatesByLocation(
            @PathVariable String locId,
            @PathVariable String orgId
    ) {
        var request = new GetAssociatesByLocation(orgId,locId);
        return service.listAssociatesByLocation(request);
    }

    @PostMapping("/api/associate")
    public Response<AssociateDto> createNewAssociate(@RequestBody CreateNewAssociateRequest request) {
        return service.createNewAssociate(request);
    }

}

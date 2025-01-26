package com.booking.qs_location_service.utils;

import com.booking.qs_location_service.domain.associate.Associate;
import com.booking.qs_location_service.domain.associate.AssociateId;
import com.booking.qs_location_service.dtos.associate.AssociateDto;
import com.booking.qs_location_service.dtos.associate.CreateNewAssociateRequest;

import java.util.UUID;

public class AssociateUtils {

    public static Associate createNewAssociate(CreateNewAssociateRequest request) {
        var associate = new Associate();
        var associateId = request.getAssociateId();
        if(request.getAssociateId() == null || request.getAssociateId().trim().isEmpty()) {
            associateId = generateNewAssociateId();
        }
        associate.setId(new AssociateId(associateId, request.getLocationId(), request.getOrgId()));
        associate.setPhone(request.getPhone());
        associate.setEmail(request.getEmail());
        associate.setFirstName(request.getFirstName());
        associate.setLastName(request.getLastName());
        return associate;
    }

    public static String generateNewAssociateId() {
        var uuid = UUID.randomUUID();
        return "asc-" + uuid.toString().substring(0,7);
    }

    public static AssociateDto associateDto(Associate associate) {
        var dto = new AssociateDto();
        if(associate != null) {
            if(associate.getId() != null) {
                dto.setAssociateId(associate.getId().getAssociateId());
                dto.setLocationId(associate.getId().getLocationId());
                dto.setOrgId(associate.getId().getOrgId());
            }
            dto.setEmail(associate.getEmail());
            dto.setPhone(associate.getPhone());
            dto.setFirstName(associate.getFirstName());
            dto.setLastName(associate.getLastName());
        }

        return dto;
    }
}

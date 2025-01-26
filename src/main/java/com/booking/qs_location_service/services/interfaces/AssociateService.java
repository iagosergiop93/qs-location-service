package com.booking.qs_location_service.services.interfaces;

import com.booking.qs_location_service.dtos.Response;
import com.booking.qs_location_service.dtos.associate.AssociateDto;
import com.booking.qs_location_service.dtos.associate.CreateNewAssociateRequest;
import com.booking.qs_location_service.dtos.associate.GetAssociateByIdRequest;
import com.booking.qs_location_service.dtos.associate.GetAssociatesByLocation;

import java.util.List;

public interface AssociateService {
    Response<AssociateDto> getAssociateById(GetAssociateByIdRequest request);
    Response<AssociateDto> createNewAssociate(CreateNewAssociateRequest request);
    Response<List<AssociateDto>> listAssociatesByLocation(GetAssociatesByLocation request);
}

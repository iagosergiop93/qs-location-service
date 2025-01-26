package com.booking.qs_location_service.services;

import com.booking.qs_location_service.domain.associate.AssociateId;
import com.booking.qs_location_service.dtos.Message;
import com.booking.qs_location_service.dtos.MessageType;
import com.booking.qs_location_service.dtos.Response;
import com.booking.qs_location_service.dtos.associate.AssociateDto;
import com.booking.qs_location_service.dtos.associate.CreateNewAssociateRequest;
import com.booking.qs_location_service.dtos.associate.GetAssociateByIdRequest;
import com.booking.qs_location_service.dtos.associate.GetAssociatesByLocation;
import com.booking.qs_location_service.repositories.AssociateRepository;
import com.booking.qs_location_service.services.interfaces.AssociateService;
import com.booking.qs_location_service.utils.AssociateUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociateServiceImpl implements AssociateService {

    @Autowired
    private AssociateRepository repo;

    @Override
    public Response<AssociateDto> getAssociateById(GetAssociateByIdRequest request) {
        var response = new Response<AssociateDto>();
        try {
            var associateId = new AssociateId(request.getAssociateId(), request.getLocationId(), request.getOrgId());
            var associateOptional = repo.findById(associateId);
            associateOptional.ifPresentOrElse(
                    associate -> response.with(AssociateUtils.associateDto(associate)),
                    () -> response.addMessage(new Message("400", "No data found", MessageType.INFO))
            );
            response.withSuccess(true);
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addMessage(new Message("500", e.getMessage()));
        }
        return response;
    }

    @Override
    public Response<List<AssociateDto>> listAssociatesByLocation(GetAssociatesByLocation request) {
        var response = new Response<List<AssociateDto>>();
        try {
            var associateList = repo.findByLocation(request.getOrgId(), request.getLocId());
            if(associateList == null || associateList.isEmpty()) {
                response.addMessage(new Message("400", "No data found", MessageType.INFO));
            }
            else {
                response.with(associateList);
            }
            response.withSuccess(true);
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addMessage(new Message("500", e.getMessage()));
        }
        return response;
    }

    @Override
    @Transactional
    public Response<AssociateDto> createNewAssociate(CreateNewAssociateRequest request) {
        var response = new Response<AssociateDto>();
        try {
            if(request.getAssociateId() != null) {
                var associateId = new AssociateId(request.getAssociateId(), request.getLocationId(), request.getOrgId());
                var associateAlreadyExists = repo.existsById(associateId);
                if(associateAlreadyExists) {
                    return response
                            .withSuccess(false)
                            .addMessage(new Message("400", "An associate with this id already exists"));
                }
            }
            var associate = AssociateUtils.createNewAssociate(request);
            associate.setNew(true);
            associate = repo.saveAndFlush(associate);
            response
                    .withSuccess(true)
                    .with(AssociateUtils.associateDto(associate));
        } catch (Throwable e) {
            response
                    .withSuccess(false)
                    .addMessage(new Message("500", e.getMessage()));
        }
        return response;
    }
}

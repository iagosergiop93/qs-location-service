package com.booking.qs_location_service.services;

import com.booking.qs_location_service.domain.location.Address;
import com.booking.qs_location_service.domain.location.Location;
import com.booking.qs_location_service.domain.location.LocationId;
import com.booking.qs_location_service.dtos.Message;
import com.booking.qs_location_service.dtos.MessageType;
import com.booking.qs_location_service.dtos.Response;
import com.booking.qs_location_service.dtos.location.AddressDto;
import com.booking.qs_location_service.dtos.location.CreateLocationRequest;
import com.booking.qs_location_service.dtos.location.GetLocationByIdRequest;
import com.booking.qs_location_service.dtos.location.LocationDto;
import com.booking.qs_location_service.repositories.AddressRepository;
import com.booking.qs_location_service.repositories.LocationRepository;
import com.booking.qs_location_service.services.interfaces.LocationService;
import com.booking.qs_location_service.utils.AddressUtils;
import com.booking.qs_location_service.utils.LocationUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private AddressRepository addressRepo;

    public Response<Location> getLocationById(GetLocationByIdRequest request) {
        var response = new Response<Location>();
        try {
            var locationId = new LocationId(request.getId(), request.getOrgId());
            var locationOptional = locationRepo.findById(locationId);
            locationOptional.ifPresentOrElse(
                    location -> response.with(location),
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

    public Response<List<LocationDto>> listLocationsByOrg(String orgId) {
        var response = new Response<List<LocationDto>>();
        try {
            var locationList = locationRepo.findByOrgId(orgId);
            if(locationList != null && !locationList.isEmpty()) {
                response.with(locationList).withSuccess(true);
            }
            else {
                response.addMessage(new Message("400", "No data found", MessageType.INFO));
            }
        } catch (Exception e) {
            response
                    .withSuccess(false)
                    .addMessage(new Message("500", e.getMessage()));
        }
        return response;
    }

    @Transactional
    public Response<Location> createNewLocation(CreateLocationRequest request) {
        var response = new Response<Location>();
        try {
            var locationId = new LocationId(request.getLocationId(), request.getOrgId());
            var locationAlreadyExists = locationRepo.existsById(locationId);
            if(locationAlreadyExists) {
                return response
                        .withSuccess(false)
                        .addMessage(new Message("400", "A location with this id already exists"));
            }
            var location = LocationUtils.createLocation(request);
            location.setNew(true);
            if(request.getAddress() != null) {
                Address address = this.createAddressForNewLocation(request);
                location.setAddress(address);
            }
            location = locationRepo.save(location);
            response
                    .withSuccess(true)
                    .with(location);
        } catch (Throwable e) {
            response
                    .withSuccess(false)
                    .addMessage(new Message("500", e.getMessage()));
        }
        return response;
    }

    private Address createAddressForNewLocation(CreateLocationRequest request) throws Exception {
        Address address = null;
        var addrDto = request.getAddress();
        if(addrDto.getId() == null) {
            this.generateNewAddressId(addrDto);
            address = this.saveAddress(addrDto);
        }
        else {
            var addressOptional = addressRepo.findById(addrDto.getId());
            address = addressOptional.orElseGet(() -> this.saveAddress(addrDto));
        }
        return address;
    }

    private void generateNewAddressId(AddressDto addressDto) throws Exception {
        var addressAlreadyExists = true;
        var id = "";
        for (int i=0; i<3; i++) {
            id = AddressUtils.generateNewAddressId();
            addressAlreadyExists = addressRepo.existsById(id);
            if(!addressAlreadyExists) {
                addressDto.setId(id);
                return;
            }
        }
        throw new Exception("Error generating Address ID: " + id);
    }

    private Address saveAddress(AddressDto addrDto) {
        Address address = AddressUtils.createAddress(addrDto);
        address.setNew(true);
        return addressRepo.saveAndFlush(address);
    }

}

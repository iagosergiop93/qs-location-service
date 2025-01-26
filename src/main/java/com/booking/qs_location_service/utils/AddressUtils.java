package com.booking.qs_location_service.utils;

import com.booking.qs_location_service.domain.location.Address;
import com.booking.qs_location_service.dtos.location.AddressDto;

import java.util.UUID;

public class AddressUtils {
    public static Address createAddress(AddressDto addressDto) {
        var addr = new Address();
        addr.setId(addressDto.getId());
        addr.setCity(addressDto.getCity());
        addr.setState(addressDto.getState());
        addr.setCountry(addressDto.getCountry());
        addr.setStreet1(addressDto.getStreet1());
        addr.setStreet2(addressDto.getStreet2());
        addr.setZipCode(addressDto.getZipCode());

        return addr;
    }

    public static String generateNewAddressId() {
        var uuid = UUID.randomUUID();
        return "addr-" + uuid.toString().substring(0,7);
    }

}

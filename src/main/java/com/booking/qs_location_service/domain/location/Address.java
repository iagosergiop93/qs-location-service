package com.booking.qs_location_service.domain.location;

import com.booking.qs_location_service.domain.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity<String> {
    @Id
    private String id;
    private String street1;
    private String street2;
    private String zipCode;
    private String city;
    private String state;
    private String country;
}

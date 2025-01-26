package com.booking.qs_location_service.domain.associate;

import com.booking.qs_location_service.domain.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "associate_roles")
public class AssociateRole extends AbstractEntity<String> {
    @Id
    private String id;
    private String name;
}

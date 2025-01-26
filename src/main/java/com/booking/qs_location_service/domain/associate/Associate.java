package com.booking.qs_location_service.domain.associate;

import com.booking.qs_location_service.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "associates")
public class Associate extends AbstractEntity<AssociateId> {
    @EmbeddedId
    private AssociateId id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "associaterole_id", referencedColumnName = "id")
    private AssociateRole associateRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Associate associate = (Associate) o;
        return Objects.equals(id, associate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}

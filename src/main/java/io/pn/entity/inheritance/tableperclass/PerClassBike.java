package io.pn.entity.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PerClassBike extends PerClassEngine {

    private String mileage;

}

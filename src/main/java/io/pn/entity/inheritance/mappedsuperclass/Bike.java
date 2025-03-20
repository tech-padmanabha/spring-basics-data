package io.pn.entity.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Bike extends Engine {
    private String mileage;

}

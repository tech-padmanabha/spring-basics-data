package io.pn.entity.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Jeep extends Engine {
    private String wheelSize;
    private String color;
}

package io.pn.entity.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class JoinedBike extends JoinedEngine {

    private String mileage;

}

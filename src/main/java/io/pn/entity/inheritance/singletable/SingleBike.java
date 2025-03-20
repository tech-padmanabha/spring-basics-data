package io.pn.entity.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity

//It defines as value in table engine columns engine_type
@DiscriminatorValue("Bike")
public class SingleBike extends SingleEngine{

    private String mileage;

}

package io.pn.entity.inheritance.singletable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "single_engine")

// there are optional, if we don't define then hibernate take the column_name as DTYPE
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "engine_type",discriminatorType = DiscriminatorType.STRING)
public abstract class SingleEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}

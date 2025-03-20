package io.pn.entity.inheritance.tableperclass;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "robot_engine")
// If table TABLE_PER_CLASS is here then GeneratorType should be GenerationType.TABLE
// It creates a sequence generator table and maintain the sequence with thread safe manner
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PerClassEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}

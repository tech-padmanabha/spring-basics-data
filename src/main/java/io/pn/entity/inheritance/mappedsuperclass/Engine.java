package io.pn.entity.inheritance.mappedsuperclass;

import jakarta.persistence.*;
import lombok.Data;

@Data

/*
* It won't create parent table, but inject field into child tables
* first remove @Entity,@Table and @Inheritance
* add @MappedSuperclass in parent class
* use @Entity in subclasses
* */

//@Entity
//@Table(name = "ai_engine")
// @Inheritance(strategy = InheritanceType.JOINED)

@MappedSuperclass
public abstract class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}

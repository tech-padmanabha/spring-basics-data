package io.pn.entity.inheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ai_engine")
//  InheritanceType.JOINED help us to map relation between parent and child,
//  Parent Primary key act as foreign key in child table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class JoinedEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}

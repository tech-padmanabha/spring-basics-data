package io.pn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentName;

    @ElementCollection
    @CollectionTable(name = "subject_price")
    @MapKeyColumn(name = "subject")
    @Column(name = "price")
    private Map<String, Double> subjectPrice = new HashMap<>();

    @Embedded
    private Address currentAddress;

    // if you want to override the column name/details
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "state", column = @Column(name = "bill_state")),
            @AttributeOverride(name = "dist", column = @Column(name = "bill_dist")),
            @AttributeOverride(name = "zip", column = @Column(name = "bill_zip")),
            @AttributeOverride(name = "addLine", column = @Column(name = "bill_line"))
    })
    private Address billingAddress;
}

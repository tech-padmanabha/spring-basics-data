package io.pn.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    private String state;
    private String dist;
    private String zip;

    private String addLine;
}

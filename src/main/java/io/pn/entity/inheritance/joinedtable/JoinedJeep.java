package io.pn.entity.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class JoinedJeep extends JoinedEngine {

    private String wheelSize;
    private String color;
}

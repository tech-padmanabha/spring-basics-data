package io.pn.entity.enumuration;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class AadharCard {
    @Id
    @GeneratedValue(generator = "adid_gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "adid_gen", initialValue = 10000000)
    private Long aadharId;
    private String personName;

//    This option persists the enum value as its string representation like enum('FEMALE','MALE','OTHERS')
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;

//    This option persists as tinyint (0 and 1) from order wise
    @Enumerated(EnumType.ORDINAL)
    private AadharStatus status;
}

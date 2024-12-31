package io.pn.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeachersDto {
    private Long id;
    private String name;
    private Double fee;
    private Long courseId;
}

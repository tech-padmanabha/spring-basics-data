package io.pn.report;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExcelDataBo {
    private Long Id;
    private String name;
    private Integer age;
    private Boolean status;
    private LocalDate dob;
    private Double salary;
    private BigDecimal comm;
    private String fixedSal;
}

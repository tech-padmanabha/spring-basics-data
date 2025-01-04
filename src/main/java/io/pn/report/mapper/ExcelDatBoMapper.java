package io.pn.report.mapper;

import io.pn.report.ExcelDataBo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ExcelDatBoMapper {
    public static ExcelDataBo mapToObject(List<String> extractedData){
        ExcelDataBo dbo = new ExcelDataBo();
        dbo.setId((long)Double.parseDouble(extractedData.getFirst()));
        dbo.setName(extractedData.get(1));
        dbo.setAge((int)Double.parseDouble(extractedData.get(2)));
        dbo.setStatus(Boolean.parseBoolean(extractedData.get(3)));
        dbo.setDob(dateFormated(extractedData.get(4)));
        dbo.setSalary(Double.parseDouble(extractedData.get(5)));
        dbo.setComm(BigDecimal.valueOf(Double.parseDouble(extractedData.get(6))));
        dbo.setFixedSal(extractedData.get(7));
        return dbo;
    }

    public static List<String> mapToStringList(ExcelDataBo bo){
        List<String> listData = new LinkedList<>();
        listData.add(bo.getId()+"");
        listData.add(bo.getName());
        listData.add(bo.getAge()+"");
        listData.add(bo.getStatus()+"");
        listData.add(bo.getDob()+"");
        listData.add(bo.getSalary()+"");
        listData.add(bo.getComm()+"");
        listData.add(bo.getFixedSal());
        return listData;
    }

    private static LocalDate dateFormated(String inputDate){
        // Create a DateTimeFormatter with the specified pattern and locale Text 'Sat Jan 04 00:00:00 IST 2025'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        // Parse the string into a LocalDate object
        return LocalDate.parse(inputDate,formatter);
    }
}

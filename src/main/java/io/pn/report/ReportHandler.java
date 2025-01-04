package io.pn.report;

import io.pn.report.excel.ExcelFile;
import io.pn.report.excel.ReadExcel;
import io.pn.report.excel.WriteExcel;
import io.pn.report.mapper.ExcelDatBoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Slf4j
@Component
public class ReportHandler {

    @Autowired
    private ReadExcel excelFile;

    @Autowired
    private WriteExcel writeExcel;
    List<ExcelDataBo> result =null;

    public void readExcelDoc(){

        try {
            // Here we can specify any InputStream
            FileInputStream file = new FileInputStream(new File("C:\\Users\\Self_\\IdeaProjects\\spring-basics-data\\src\\main\\resources\\employee.xlsx"));
           var data =  excelFile.readData(file);

             result = new ArrayList<>();
           for(Integer i :data.keySet()){
               if(i != 0){
                 var model =  ExcelDatBoMapper.mapToObject(data.get(i));
                 result.add(model);
               }
           }
            System.out.println(result);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void writeExceDoc() throws IOException {

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

        // Here we can specify any OutputStream
        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        // headers
        List<String> headerList = Arrays.asList("Id","Name","Age","Status","Dob","Salary","Comm","FixedSal");

        Map<Integer,List<String>> dataToPrint = new HashMap<>();
        if(result != null){
            for(int i=0;i<result.size();i++){
                dataToPrint.put(i,ExcelDatBoMapper.mapToStringList(result.get(i)));
            }
        }
        writeExcel.writeExcel("SomeData",headerList,dataToPrint,outputStream);
    }
}

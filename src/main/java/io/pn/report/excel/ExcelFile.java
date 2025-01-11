package io.pn.report.excel;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class ExcelFile implements ReadExcel,WriteExcel{

    @Override
    public Map<Integer, List<String>> readData(InputStream inputStream) throws IOException {

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING -> data.get(i).add(cell.getRichStringCellValue() + "");
                    case NUMERIC ->{
                        if (DateUtil.isCellDateFormatted(cell)) {
                            data.get(i).add(cell.getDateCellValue() + "");
                        } else {
                            data.get(i).add(cell.getNumericCellValue() + "");
                        }
                    }
                    case BOOLEAN -> data.get(i).add(cell.getBooleanCellValue() + "");
                    // If you don't want formula and replacement of data then you can use appropriate data
                    case FORMULA -> data.get(i).add(cell.getCellFormula() + "");
                    default -> data.get(i).add("");
                }
            }
            i++;
        }

        return data;
    }

    // we can represent in generic we will do in next part
    @Override
    public byte[] writeExcel(String heading, List<String> headerList, Map<Integer,List<String>> databody, OutputStream outputStream) throws IOException {

        int startingPoints = 0;
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");

        for(int i=0;i<headerList.size();i++){
            sheet.autoSizeColumn(i,true);
        }

//        sheet.setColumnWidth(0, 6000);
//        sheet.setColumnWidth(1, 4000);

        if(!heading.isBlank()){
            Row headingLine = sheet.createRow(startingPoints);
            Cell headerCell = headingLine.createCell(startingPoints);
            headerCell.setCellValue(heading);
            CellStyle headingStyle = BaseExcel.setHeadIngStyle(workbook);
            headingStyle.setAlignment(HorizontalAlignment.CENTER);
            headingStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            // Merge the header cell across the columns (e.g., length columns)
            sheet.addMergedRegion(new CellRangeAddress(0, 3, startingPoints, (headerList.size()-1))); // Merging from row
            headerCell.setCellStyle(headingStyle);
            startingPoints+=4;
        }

        Row header = sheet.createRow(startingPoints);

        CellStyle headerStyle = BaseExcel.setHeaderStyle(workbook);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        for(int i=0;i<headerList.size();i++){
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(headerList.get(i));
            headerCell.setCellStyle(headerStyle);

        }
        startingPoints+=1;

        CellStyle cellStyle = BaseExcel.setDataStyle(workbook);
      //  cellStyle.setWrapText(true);;
        Set<Integer> keyData= databody.keySet();

        for (Integer key:keyData){
            List<String> body = databody.get(key);

            Row row = sheet.createRow(startingPoints);
            row.setHeightInPoints(40); // Adjust row height

            for(int i=0;i<body.size();i++){
                Cell cell = row.createCell(i);
                // Adjust column width
                sheet.setColumnWidth(i, 20 * 256);
                // here we can provide directly the string,number and boolean values replacement of only String
                cell.setCellValue(body.get(i));
                cell.setCellStyle(cellStyle);
            }
            startingPoints++;
        }

        workbook.write(outputStream);
        workbook.close();
        return new byte[0];
    }


}

package io.pn.report.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseExcel {

    public static CellStyle setHeaderStyle(Workbook workbook){
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        applyBoarders(headerStyle);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        font.setColor(IndexedColors.WHITE1.getIndex());
        headerStyle.setFont(font);
        return headerStyle;
    }
    public static CellStyle setHeadIngStyle(Workbook workbook){
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        headerStyle.setFillPattern(FillPatternType.DIAMONDS);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Algerian");
        font.setFontHeightInPoints((short) 30);
        font.setBold(true);
        headerStyle.setFont(font);
        return headerStyle;
    }

    public static CellStyle setDataStyle(Workbook workbook){
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        // wrap text to true
        dataStyle.setWrapText(true);
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Consolas");
        dataStyle.setFont(font);
        applyBoarders(dataStyle);
        return dataStyle;
    }

    public static void applyBoarders(CellStyle style){
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
    }
}

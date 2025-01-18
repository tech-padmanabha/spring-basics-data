package io.pn.report.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Component
public class WriteInPdf {

    public byte[] write(OutputStream outputStream,String logo) throws DocumentException {
        String path= "";
        // Document Creation
        Document document = new Document();

        // Pdf Writer to write in Pdf
        PdfWriter writer = PdfWriter.getInstance(document,outputStream);

        //open the document to present the data
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER,20,BaseColor.BLUE);

        //Additionally, we can combine Chunks with other elements, like Paragraphs, Section, etc
        Chunk chunk = new Chunk("Here are some data",font);

        document.add(chunk);
        document.top(2);
        document.bottom(10);
        document.close();
        return new byte[1];
    }

    public byte[] writeInTable(OutputStream outputStream,List<String> headersList,List<List<String>> rowsList) throws DocumentException {

        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document,outputStream);
        document.open();
        PdfPTable tableData = addTable(headersList.size(),headersList,rowsList);
        document.addTitle("Here are the Table Details");
        document.addSubject("Emp-Details-subject");
        document.addHeader("HeaderPart","Name of the HeaderPart");
        document.addCreator("papina");
        document.addAuthor("Padmanabha");
        document.add(tableData);
        document.close();

        return new byte[1];
    }

    public PdfPTable addTable(int numberOfColumn,List<String> headerList,List<List<String>> rowData){
        PdfPTable pdfTable = new PdfPTable(numberOfColumn);
        if(numberOfColumn == headerList.size()){
         addHeaders(pdfTable,headerList);
         addRows(pdfTable,rowData);
        }
        return pdfTable;
    }

    private void addRows(PdfPTable pdfTable, List<List<String>> rowData) {
        rowData.forEach(dataList ->{
            dataList.forEach(pdfTable::addCell);
        });
    }

    private void addHeaders(PdfPTable pdfTable,List<String> headerList) {
        headerList.forEach(title -> {
            PdfPCell headerCell = new PdfPHeaderCell();
            headerCell.setBackgroundColor(BaseColor.GRAY);
            headerCell.setBorderWidth(2);

            // here we can change the font of text
            Font font = new Font(Font.FontFamily.COURIER);
            font.setColor(BaseColor.WHITE);
            font.setSize(20);
            headerCell.setPhrase(new Phrase(title,font));
            pdfTable.addCell(headerCell);
        });
    }
}

package io.pn.report.pdf;

import com.github.javafaker.Faker;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PdfFileExecutor {

    @Autowired
    private WriteInPdf writeInPdf;

    @Autowired
    private PdfFileEncrypt pdfFileEncrypt;

    public void dataMapToPdf() throws FileNotFoundException, DocumentException {
        FileOutputStream fio = new FileOutputStream("C:\\Users\\Self_\\IdeaProjects\\spring-basics-data\\src\\main\\resources\\employee.pdf");
       writeInPdf.write(fio,"somelogo");
    }

    public void dataMapToPdfWithTable() throws FileNotFoundException, DocumentException {
        FileOutputStream fio = new FileOutputStream("C:\\Users\\Self_\\IdeaProjects\\spring-basics-data\\src\\main\\resources\\employeeTable.pdf");
        List<String> headerList = Arrays.asList("Name","SuperHero","Address");
        List<List<String>> rowDetails = new ArrayList<>();

        for(int i=0;i<27;i++){
            Faker faker = new Faker();
            List<String> oneRow = new ArrayList<>();
            oneRow.add(faker.name().firstName());
            oneRow.add(faker.superhero().name());
            oneRow.add(faker.address().cityName());
            rowDetails.add(oneRow);
        }
        writeInPdf.writeInTable(fio,headerList,rowDetails);
    }

    public void doFileEncrypt() throws IOException, DocumentException {
        String password = "password";
        FileOutputStream fio = new FileOutputStream("C:\\Users\\Self_\\IdeaProjects\\spring-basics-data\\src\\main\\resources\\employeeTableSecured.pdf");
        String path = new String("C:\\Users\\Self_\\IdeaProjects\\spring-basics-data\\src\\main\\resources\\employeeTable.pdf");

        pdfFileEncrypt.doFileEncrypt(path,fio,password);
    }
}

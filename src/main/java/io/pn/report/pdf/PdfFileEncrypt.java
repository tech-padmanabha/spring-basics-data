package io.pn.report.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

@Component
public class PdfFileEncrypt {

    public byte[] doFileEncrypt(String inputPdf, OutputStream outStreamPdf, String password) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(inputPdf);
        PdfStamper stamper = new PdfStamper(reader,outStreamPdf);

        // Set encryption
        // Parameters: user password, owner password, permissions, encryption type
        stamper.setEncryption(password.getBytes(),"owner".getBytes(),PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_MODIFY_CONTENTS, PdfWriter.ENCRYPTION_AES_128);
        stamper.close();
        return new byte[0];
    }
}
//Keep in mind that when using iText to set access permissions, we’re also creating a temporary pdf, which should be deleted. If we don’t delete it, it could be fully accessible to anyone.
package io.pn.service.impls;

import io.pn.dto.BookLogDto;
import io.pn.dto.BookPictureDto;
import io.pn.entity.BookLog;
import io.pn.entity.BookPicture;
import io.pn.exception.ResourceNotFoundException;
import io.pn.repository.BookLogRepository;
import io.pn.service.BookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookLogServiceImpl implements BookLogService {

    @Autowired
    private BookLogRepository bookLogRepository;

    @Override
    public BookLogDto addBookLog(MultipartFile file, String isbn){
        BookLog bl = new BookLog();
        try {
            bl.setIsbn(isbn);
            BookPicture bp = new BookPicture();
            bp.setFileType(file.getContentType());
            bp.setFileName(file.getOriginalFilename());
            bp.setContent(new SerialBlob(file.getBytes()));
            bl.setBookPicture(bp);
            BookLog bl2 = bookLogRepository.save(bl);
            BookLogDto dto = new BookLogDto();
            dto.setBookId(bl2.getBookId());
            dto.setIsbn(bl2.getIsbn());
            dto.setFile(bl2.getBookPicture().getFileName());
            return dto;
        }catch(IOException | SQLException e){
            throw  new RuntimeException("Storing error: "+e.getMessage());
        }
    }
    public BookPictureDto getDetailsByBookId(Long bookLogId){
        BookPictureDto dto  = new BookPictureDto();
        var bookLog = bookLogRepository.findById(bookLogId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Available"));
        var content = bookLog.getBookPicture().getContent();
        var fileName = bookLog.getBookPicture().getFileName();
        try {
           var pic =  content.getBinaryStream().readAllBytes();
            dto.setFileName(fileName);
            dto.setContent(pic);
            return dto;
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}

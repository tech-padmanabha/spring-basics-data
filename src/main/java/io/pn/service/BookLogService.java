package io.pn.service;

import io.pn.dto.BookLogDto;
import io.pn.dto.BookPictureDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface BookLogService {
    public BookLogDto addBookLog(MultipartFile file,String isbn);
    public BookPictureDto getDetailsByBookId(Long bookLogId);
}

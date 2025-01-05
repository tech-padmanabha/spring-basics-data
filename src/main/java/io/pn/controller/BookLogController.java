package io.pn.controller;

import io.pn.dto.BookLogDto;
import io.pn.service.BookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v2/backlog")
public class BookLogController {

    @Autowired
    private BookLogService bookLogService;

    // if you want to work with multiple files then MultipartFile mark as array
    @PostMapping("/{isbn}")
    public BookLogDto provideBookDetails(@RequestParam("file") MultipartFile file,@PathVariable String isbn){
            return bookLogService.addBookLog(file,isbn);
    }

    @GetMapping("/picture")
    public ResponseEntity<byte[]> getPictureByBookLogId(@RequestParam Long id){
        var resp = bookLogService.getDetailsByBookId(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resp.getFileName());
        return new ResponseEntity<>(resp.getContent(),headers, HttpStatus.OK);
    }
}

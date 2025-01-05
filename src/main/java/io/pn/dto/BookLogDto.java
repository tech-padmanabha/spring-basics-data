package io.pn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BookLogDto {
    private Long bookId;
    private String isbn;
    private String file;
}

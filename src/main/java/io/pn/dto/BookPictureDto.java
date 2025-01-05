package io.pn.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookPictureDto {
    private Long id;
    private String fileName;
    private String fileType;
    private byte[] content;
}

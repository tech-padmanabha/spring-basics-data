package io.pn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class BookPicture {
    @Id
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private String content;

    @OneToOne(mappedBy = "bookPicture")
    private BookLog bookLog;
}

package io.pn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Setter
@Getter
@Entity
@Table
public class BookPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private Blob content;

    @OneToOne(mappedBy = "bookPicture")
    private BookLog bookLog;
}

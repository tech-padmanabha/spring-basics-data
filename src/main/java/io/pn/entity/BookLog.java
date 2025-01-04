package io.pn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book_log")
public class BookLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long bookId;
    private String isbn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private BookPicture bookPicture;

    @OneToOne(mappedBy = "bookLog")
    private Courses courses;
}

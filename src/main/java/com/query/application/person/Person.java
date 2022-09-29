package com.query.application.person;

import com.query.application.book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String firstName;

    @Column
    @NonNull
    private String lastName;

    @Column
    @NonNull
    private Integer age;

    @OneToMany(mappedBy = "person")
    private List<Book> books;
}

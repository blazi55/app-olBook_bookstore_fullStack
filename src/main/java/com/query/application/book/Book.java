package com.query.application.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.query.application.person.Person;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}

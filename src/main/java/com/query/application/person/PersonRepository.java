package com.query.application.person;

import com.query.application.book.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByFirstNameAndLastName(String firstname, String lastName);
}

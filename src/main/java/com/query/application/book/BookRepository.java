package com.query.application.book;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByName(String bookName);
}

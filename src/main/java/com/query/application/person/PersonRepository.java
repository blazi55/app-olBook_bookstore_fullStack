package com.query.application.person;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByFirstNameAndLastName(String firstname, String lastName);
}

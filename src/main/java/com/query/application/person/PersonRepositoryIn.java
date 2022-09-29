package com.query.application.person;

import java.util.List;

public interface PersonRepositoryIn {

    List<Person> getAllPerson();

    List<Person> checkAge(Integer age);
}

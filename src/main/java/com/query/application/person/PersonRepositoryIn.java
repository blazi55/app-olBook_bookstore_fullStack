package com.query.application.person;

import java.util.List;
import java.util.Map;

public interface PersonRepositoryIn {

    List<Person> getAllPerson();

    List<Person> checkAge(Integer age);

    List<Long> countFirstName();

    List<Person> sortFirstNameAndLastName();

    Map<Long, String> getFullNameWithAge();

}

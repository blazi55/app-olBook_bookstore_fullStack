package com.query.application.person;

import com.query.application.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final BookRepository bookRepository;
    private final PersonRepositoryInImpl personRepositoryInImpl;

    public Person createPerson(CreatePersonDto createPersonDto) {
        Person person = Person.builder()
                .firstName(createPersonDto.getFirstName())
                .lastName(createPersonDto.getLastName())
                .age(createPersonDto.getAge())
                .build();
        personRepository.save(person);
        return person;
    }

    public Person updatePerson(CreatePersonDto createPersonDto, Long id) {
        Person person = personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        person.setFirstName(createPersonDto.getFirstName());
        person.setLastName(createPersonDto.getLastName());
        person.setAge(createPersonDto.getAge());
        personRepository.save(person);
        return person;
    }

    public List<Person> getAll() {
        return personRepositoryInImpl.getAllPerson();
    }

    public List<Person> checkAge(Integer age) {
        return personRepositoryInImpl.checkAge(age);
    }

    public List<Long> countFirstName() {
        return personRepositoryInImpl.countFirstName();
    }

    public Map<Long, String> getFullNameWithAge() {
        return personRepositoryInImpl.getFullNameWithAge();
    }

    public List<Person> sortFirstNameAndLastName() {
        return personRepositoryInImpl.sortFirstNameAndLastName();
    }
}

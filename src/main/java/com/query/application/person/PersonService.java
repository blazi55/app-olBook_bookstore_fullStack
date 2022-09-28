package com.query.application.person;

import com.query.application.book.Book;
import com.query.application.book.BookRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

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

    public Person updatePersonBook(String nameBook, String firstName, String lastName) {
        Book book = bookRepository.findByName(nameBook).orElseThrow(IllegalArgumentException::new);
        Person person = personRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(IllegalArgumentException::new);
        List<Book> listNewBooks = new ArrayList<>();
        listNewBooks.add(book);

        for (Book singleBook : person.getBooks()) {
            listNewBooks.add(singleBook);
        }

        person.setBooks(listNewBooks);
        personRepository.save(person);
        return person;
    }

    public List<Person> getAll() {
        return personRepositoryInImpl.getAllPerson();
    }
}

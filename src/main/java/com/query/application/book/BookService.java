package com.query.application.book;

import com.query.application.person.Person;
import com.query.application.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;

    private final BookRepositoryIntImpl bookRepositoryInt;

    public Book createBook(CreateBookDto createBookDto) {
        Book book = Book.builder()
                .name(createBookDto.getName())
                .price(createBookDto.getPrice())
                .build();
        bookRepository.save(book);
        return book;
    }

    public Book updatePerson(String bookName, String firstName, String lastName) {
        Person person = personRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(IllegalArgumentException::new);
        Book book = bookRepository.findByName(bookName).orElseThrow(IllegalArgumentException::new);
        book.setPerson(person);
        bookRepository.save(book);
        return book;
    }

    public Book getBook(String bookName) {
        return bookRepository.findByName(bookName).orElseThrow(IllegalArgumentException::new);
    }

    public List<Book> getAllBook() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> getBooksBySortPriceDesc() {
        return (List<Book>) bookRepositoryInt.getBooksBySortPriceDesc();
    }

    public List<Book> getBooksAlphabet() {
        return (List<Book>) bookRepositoryInt.getBooksAlphabet();
    }

    public Book updateBook(CreateBookDto createBookDto, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        book.setName(createBookDto.getName());
        book.setPrice(createBookDto.getPrice());
        bookRepository.save(book);
        return book;
    }
}

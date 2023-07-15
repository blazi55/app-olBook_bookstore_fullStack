package com.query.application.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bookQuery")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody CreateBookDto createBookDto) {
        return bookService.createBook(createBookDto);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestParam String bookName, @RequestParam String firstName,
                           @RequestParam String lastName) {
        return bookService.updatePerson(bookName, firstName, lastName);
    }

    @GetMapping("/singleBook")
    public Book getBook(@RequestParam String bookName) {
        return bookService.getBook(bookName);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @GetMapping("/sortDesc")
    public List<Book> getBooksSortByPriceDesc() {
        return bookService.getBooksBySortPriceDesc();
    }

    @GetMapping("/alphabet")
    public List<Book> getBooksAlphabet() {
        return bookService.getBooksAlphabet();
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody CreateBookDto createBookDto, @RequestParam Long id) {
        return bookService.updateBook(createBookDto, id);
    }
}

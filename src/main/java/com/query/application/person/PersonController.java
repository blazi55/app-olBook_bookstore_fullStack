package com.query.application.person;

import com.query.application.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("personQuery")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody CreatePersonDto createPersonDto) {
        return personService.createPerson(createPersonDto);
    }

    @PutMapping("/update")
    public Person updatePersonBooks(@RequestParam String nameBook, @RequestParam String firstName,
                                    @RequestParam String lastName) {
        return personService.updatePersonBook(nameBook, firstName, lastName);
    }

    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personService.getAll();
    }
}

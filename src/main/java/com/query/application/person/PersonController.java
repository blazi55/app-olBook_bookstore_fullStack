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
    public Person updatePerson(@RequestBody CreatePersonDto createPersonDto, @RequestParam Long id) {
        return personService.updatePerson(createPersonDto, id);
    }

    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personService.getAll();
    }

    @GetMapping("/checkAge")
    public List<Person> checkAge(@RequestParam Integer age) {
        return personService.checkAge(age);
    }
}

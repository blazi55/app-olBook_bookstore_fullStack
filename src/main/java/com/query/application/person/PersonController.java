package com.query.application.person;

import com.query.application.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/countFirstName")
    public List<Long> countFirstName() {
        return personService.countFirstName();
    }

    @GetMapping("/sortFirstNameAndLastName")
    public List<Person> sortFirstNameAndLastName() {
        return personService.sortFirstNameAndLastName();
    }

    @GetMapping("/getFullNameWithAge")
    public Map<Long, String> getFullNameWithAge() {
        return personService.getFullNameWithAge();
    }
}

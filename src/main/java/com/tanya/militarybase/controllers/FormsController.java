package com.tanya.militarybase.controllers;

import com.tanya.militarybase.dao.persons.PersonRepository;
import com.tanya.militarybase.model.persons.Person;
import com.tanya.militarybase.service.FormsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FormsController {
    private final FormsService service;

    private final PersonRepository personRepo;

    @PostMapping("/person")
    public String postPerson(
            @RequestParam(name="firstName") String firstName,
            @RequestParam(name="lastName") String lastName,
            @RequestParam(name="thirdName") String thirdName,
            Map<String, Object> model
    ) {
        boolean isOk = service.postPerson(firstName,  lastName, thirdName);

//        Iterable<Person> persons = personRepo.getAll();
//        model.put("persons", persons);
        return "redirect:/forms";
    }

}

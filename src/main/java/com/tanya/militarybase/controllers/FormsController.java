package com.tanya.militarybase.controllers;

import com.tanya.militarybase.dao.persons.PersonRepository;
import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.model.RyadovoySostav;
import com.tanya.militarybase.model.persons.Person;
import com.tanya.militarybase.service.FormsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FormsController {
    private final FormsService service;
    private final PersonRepository personRepository;

    @GetMapping("/voennosluzhashie")
    public String getVoennosluzhashie(Map<String, Object> model) {
        model.put("persons", personRepository.findAll());
        return "voennosluzhashie";
    }

    @PostMapping("/person")
    public String postPerson(
            @RequestParam(name="firstName") String firstName,
            @RequestParam(name="lastName") String lastName,
            @RequestParam(name="thirdName") String thirdName,
            @RequestParam(name="sostav_name") String sostavName,
            @RequestParam(name="specialnost_name") String specialnostName,
            @RequestParam(name="character1") Boolean character1,
            @RequestParam(name="character2") String character2,
            @RequestParam(name="character3") Integer character3
    ) {
        Person person = service.postPerson(firstName,  lastName, thirdName);

        switch (sostavName) {
            case "OFICER":
                OficerSostav oficerSostav = service.postOficerSostav(person);
                service.postOficerSpecialnost(oficerSostav, specialnostName, character1, character2, character3);
                break;
            case "RYADOVOY":
                RyadovoySostav ryadovoySostav = service.postRyadovoySostav(person);
                service.postRyadovoySpecialnost(ryadovoySostav, specialnostName, character1, character2, character3);
                break;
        }

        return "redirect:/voennosluzhashie";
    }

}

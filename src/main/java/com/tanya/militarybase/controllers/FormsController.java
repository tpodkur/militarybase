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
    private OficerSostav oficerSostav;
    private RyadovoySostav ryadovoySostav;

    @GetMapping("/voennosluzhashie")
    public String getVoennosluzhashie(Map<String, Object> model) {
        model.put("persons", personRepository.findByActive(true));
        return "voennosluzhashie";
    }

    @PostMapping("/person")
    public String postPerson(
            @RequestParam(name="firstName") String firstName,
            @RequestParam(name="lastName") String lastName,
            @RequestParam(name="thirdName") String thirdName,
            @RequestParam(name="sostav_name") String sostavName,
            @RequestParam(name="specialnost_name") String specialnostName,

            @RequestParam(name="general_character1") Boolean general_character1,
            @RequestParam(name="general_character2") String general_character2,
            @RequestParam(name="general_character3") Integer general_character3,

            @RequestParam(name="polkovnik_character1") Boolean polkovnik_character1,
            @RequestParam(name="polkovnik_character2") String polkovnik_character2,
            @RequestParam(name="polkovnik_character3") Integer polkovnik_character3,

            @RequestParam(name="podpolkovnik_character1") Boolean podpolkovnik_character1,
            @RequestParam(name="podpolkovnik_character2") String podpolkovnik_character2,
            @RequestParam(name="podpolkovnik_character3") Integer podpolkovnik_character3,

            @RequestParam(name="mayor_character1") Boolean mayor_character1,
            @RequestParam(name="mayor_character2") String mayor_character2,
            @RequestParam(name="mayor_character3") Integer mayor_character3,

            @RequestParam(name="kapitan_character1") Boolean kapitan_character1,
            @RequestParam(name="kapitan_character2") String kapitan_character2,
            @RequestParam(name="kapitan_character3") Integer kapitan_character3,

            @RequestParam(name="leytenant_character1") Boolean leytenant_character1,
            @RequestParam(name="leytenant_character2") String leytenant_character2,
            @RequestParam(name="leytenant_character3") Integer leytenant_character3,

            @RequestParam(name="starshina_character1") Boolean starshina_character1,
            @RequestParam(name="starshina_character2") String starshina_character2,
            @RequestParam(name="starshina_character3") Integer starshina_character3,

            @RequestParam(name="retzhant_character1") Boolean retzhant_character1,
            @RequestParam(name="retzhant_character2") String retzhant_character2,
            @RequestParam(name="retzhant_character3") Integer retzhant_character3,

            @RequestParam(name="praporshik_character1") Boolean praporshik_character1,
            @RequestParam(name="praporshik_character2") String praporshik_character2,
            @RequestParam(name="praporshik_character3") Integer praporshik_character3,

            @RequestParam(name="efreytor_character1") Boolean efreytor_character1,
            @RequestParam(name="efreytor_character2") String efreytor_character2,
            @RequestParam(name="efreytor_character3") Integer efreytor_character3,

            @RequestParam(name="ryadovoy_character1") Boolean ryadovoy_character1,
            @RequestParam(name="ryadovoy_character2") String ryadovoy_character2,
            @RequestParam(name="ryadovoy_character3") Integer ryadovoy_character3
            ) {
        Person person = service.postPerson(firstName,  lastName, thirdName);

        switch (sostavName) {
            case "OFICER":
                oficerSostav = service.postOficerSostav(person);
                break;
            case "RYADOVOY":
                ryadovoySostav = service.postRyadovoySostav(person);
                break;
        }

        switch (specialnostName) {
            case "GENERAL":
                service.postOficerSpecialnost(oficerSostav, specialnostName, general_character1, general_character2, general_character3);
                break;
            case "POLKOVNIK":
                service.postOficerSpecialnost(oficerSostav, specialnostName, polkovnik_character1, polkovnik_character2, polkovnik_character3);
                break;
            case "PODPOLKOVNIK":
                service.postOficerSpecialnost(oficerSostav, specialnostName, podpolkovnik_character1, podpolkovnik_character2, podpolkovnik_character3);
                break;
            case "MAIOR":
                service.postOficerSpecialnost(oficerSostav, specialnostName, mayor_character1, mayor_character2, mayor_character3);
                break;
            case "KAPITAN":
                service.postOficerSpecialnost(oficerSostav, specialnostName, kapitan_character1, kapitan_character2, kapitan_character3);
                break;
            case "LEYTENANT":
                service.postOficerSpecialnost(oficerSostav, specialnostName, leytenant_character1, leytenant_character2, leytenant_character3);
                break;
            case "STARSHINA":
                service.postRyadovoySpecialnost(ryadovoySostav, specialnostName, starshina_character1, starshina_character2, starshina_character3);
                break;
            case "SERZHANT":
                service.postRyadovoySpecialnost(ryadovoySostav, specialnostName, retzhant_character1, retzhant_character2, retzhant_character3);
                break;
            case "PRAPORSHIK":
                service.postRyadovoySpecialnost(ryadovoySostav, specialnostName, praporshik_character1, praporshik_character2, praporshik_character3);
                break;
            case "EFREYTOR":
                service.postRyadovoySpecialnost(ryadovoySostav, specialnostName, efreytor_character1, efreytor_character2, efreytor_character3);
                break;
            case "RYADOVOY":
                service.postRyadovoySpecialnost(ryadovoySostav, specialnostName, ryadovoy_character1, ryadovoy_character2, ryadovoy_character3);
                break;
        }

        return "redirect:/voennosluzhashie";
    }

}

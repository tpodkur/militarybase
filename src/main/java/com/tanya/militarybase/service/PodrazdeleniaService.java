package com.tanya.militarybase.service;

import com.tanya.militarybase.dao.OficerSostavRepository;
import com.tanya.militarybase.dao.persons.PersonRepository;
import com.tanya.militarybase.dao.podrazdelenia_repo.ArmiaRepository;
import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.model.join_entities.OficerSostavPerson;
import com.tanya.militarybase.model.persons.Oficer;
import com.tanya.militarybase.model.persons.Person;
import com.tanya.militarybase.model.podrazdelenia.Armia;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PodrazdeleniaService {

    private final PersonRepository personRepository;
    private final OficerSostavRepository oficerSostavRepository;
    private final ArmiaRepository armiaRepository;

    public List<OficerSostavPerson> getAllOficerSostav() {
        List<Person> allPersons = personRepository.findAll();

        List<OficerSostavPerson> oficerPersons = new ArrayList<>();

        for(int i=0; i<allPersons.size(); i++) {
            Person currentPerson = allPersons.get(i);
            OficerSostav oficer = oficerSostavRepository.findByPerson(currentPerson);
            if (null == oficer) {
                System.out.println("null");
                continue;
            }
            OficerSostavPerson tmp = new OficerSostavPerson();
            tmp.setFirstName(currentPerson.getFirstName());
            tmp.setLastName(currentPerson.getLastName());
            tmp.setThirdName(currentPerson.getThirdName());
            tmp.setOficerId(oficer.getId());

            oficerPersons.add(tmp);
        }
        return oficerPersons;
    }

    public Armia postArmia(OficerSostav kapitan) {
        Armia armia = new Armia();
        armia.setKapitan(kapitan);
        armiaRepository.save(armia);
        return armia;
    }

}

package com.tanya.militarybase.service;

import com.tanya.militarybase.dao.persons.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FormsService {
    private final PersonRepository repository;

    public boolean postPerson(String firstName, String lastName, String thirdName) {
        return this.repository.postPerson(firstName, lastName, thirdName);
    }
}

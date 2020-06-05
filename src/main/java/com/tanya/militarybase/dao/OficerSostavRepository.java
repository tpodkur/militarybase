package com.tanya.militarybase.dao;

import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.model.persons.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OficerSostavRepository extends JpaRepository<OficerSostav, Integer> {
    OficerSostav findByPerson(Person person);
    Optional<OficerSostav> findById(Integer id);
}

package com.tanya.militarybase.dao.persons;

import com.tanya.militarybase.model.User;
import com.tanya.militarybase.model.persons.Oficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OficerRepository extends JpaRepository<Oficer, Integer> {
    Oficer findByUser(User user);
}

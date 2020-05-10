package com.tanya.militarybase.dao.persons;

import com.tanya.militarybase.model.User;
import com.tanya.militarybase.model.persons.Ryadovoy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RyadovoyRepository extends JpaRepository<Ryadovoy, Integer> {
    Ryadovoy findByUser(User user);
}

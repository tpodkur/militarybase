package com.tanya.militarybase.dao.persons;

import com.tanya.militarybase.model.User;
import com.tanya.militarybase.model.persons.RyadovoyRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RyadovoyRoleRepository extends JpaRepository<RyadovoyRole, Integer> {
    RyadovoyRole findByUser(User user);
}

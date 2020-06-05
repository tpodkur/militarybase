package com.tanya.militarybase.dao.oficer_persons_repo;

import com.tanya.militarybase.model.oficer_persons.Polkovnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolkovnikRepository extends JpaRepository<Polkovnik, Integer> {
}

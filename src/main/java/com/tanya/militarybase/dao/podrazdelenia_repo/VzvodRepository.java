package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Vzvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VzvodRepository extends JpaRepository<Vzvod, Integer> {
    Optional<Vzvod> findById(Integer id);
}

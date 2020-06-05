package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Armia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmiaRepository extends JpaRepository<Armia, Integer> {
    Optional<Armia> findById(Integer id);
}

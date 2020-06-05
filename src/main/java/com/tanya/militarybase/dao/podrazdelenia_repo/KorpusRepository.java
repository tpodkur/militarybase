package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Korpus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorpusRepository extends JpaRepository<Korpus, Integer> {
    Optional<Korpus> findById(Integer id);
}

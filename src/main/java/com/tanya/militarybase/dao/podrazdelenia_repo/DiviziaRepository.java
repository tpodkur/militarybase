package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Divizia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiviziaRepository extends JpaRepository<Divizia, Integer> {
    Optional<Divizia> findById(Integer id);
}

package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Otdelenie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtdelenieRepository extends JpaRepository<Otdelenie, Integer> {
    Optional<Otdelenie> findById(Integer id);
}

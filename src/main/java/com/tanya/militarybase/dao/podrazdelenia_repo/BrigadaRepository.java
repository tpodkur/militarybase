package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Armia;
import com.tanya.militarybase.model.podrazdelenia.Brigada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrigadaRepository extends JpaRepository<Brigada, Integer> {
    Optional<Brigada> findById(Integer id);
    List<Brigada> findAllByArmia(Armia armia);
}

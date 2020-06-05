package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RotaRepository extends JpaRepository<Rota, Integer> {
    Optional<Rota> findById(Integer id);
}

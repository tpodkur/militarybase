package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.VoinskayaChast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoinskayaChastRepository extends JpaRepository<VoinskayaChast, Integer> {
    Optional<VoinskayaChast> findById(Integer id);
}

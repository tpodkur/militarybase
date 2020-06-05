package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Armia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmiaRepository extends JpaRepository<Armia, Integer> {
}

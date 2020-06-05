package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Korpus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorpusRepository extends JpaRepository<Korpus, Integer> {
}

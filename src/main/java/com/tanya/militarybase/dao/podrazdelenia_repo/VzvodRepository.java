package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Vzvod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VzvodRepository extends JpaRepository<Vzvod, Integer> {
}

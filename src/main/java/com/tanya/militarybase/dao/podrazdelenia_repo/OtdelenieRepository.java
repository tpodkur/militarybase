package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Otdelenie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtdelenieRepository extends JpaRepository<Otdelenie, Integer> {
}

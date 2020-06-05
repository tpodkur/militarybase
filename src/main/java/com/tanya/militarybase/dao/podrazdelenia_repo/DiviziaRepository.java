package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Divizia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiviziaRepository extends JpaRepository<Divizia, Integer> {
}

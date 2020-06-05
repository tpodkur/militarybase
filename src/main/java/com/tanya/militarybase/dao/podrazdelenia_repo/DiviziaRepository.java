package com.tanya.militarybase.dao.podrazdelenia_repo;

import com.tanya.militarybase.model.podrazdelenia.Divizia;
import com.tanya.militarybase.model.podrazdelenia.Korpus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiviziaRepository extends JpaRepository<Divizia, Integer> {
    Optional<Divizia> findById(Integer id);
    List<Divizia> findAllByKorpus(Korpus korpus);
}

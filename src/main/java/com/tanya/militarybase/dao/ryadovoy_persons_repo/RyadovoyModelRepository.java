package com.tanya.militarybase.dao.ryadovoy_persons_repo;

import com.tanya.militarybase.model.ryadovoy_persons.RyadovoyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RyadovoyModelRepository extends JpaRepository<RyadovoyModel, Integer> {
}

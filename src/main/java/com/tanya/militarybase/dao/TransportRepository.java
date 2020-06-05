package com.tanya.militarybase.dao;

import com.tanya.militarybase.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
}

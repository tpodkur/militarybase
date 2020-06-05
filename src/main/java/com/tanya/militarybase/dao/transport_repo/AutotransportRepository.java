package com.tanya.militarybase.dao.transport_repo;

import com.tanya.militarybase.model.transport.Autotransport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutotransportRepository extends JpaRepository<Autotransport, Integer> {
}

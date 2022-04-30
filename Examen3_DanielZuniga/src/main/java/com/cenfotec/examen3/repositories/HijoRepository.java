package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.entities.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HijoRepository extends JpaRepository<Hijo, Long> {
}

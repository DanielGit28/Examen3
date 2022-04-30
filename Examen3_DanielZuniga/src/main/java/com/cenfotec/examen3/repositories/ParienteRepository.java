package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.entities.Pariente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParienteRepository extends JpaRepository<Pariente, Long> {
    Pariente findParienteByNombre(String nombre);
}

package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Pariente;

import java.util.List;
import java.util.Optional;


public interface ParienteService {

    public List<Pariente> getAll();
    public Optional<Pariente> findById(long id);
    public Optional<Pariente> findByNombre(String nombre);
    public  Optional<Pariente> save(Pariente pariente);
    public  Optional<Pariente> update(Pariente pariente);
    public boolean delete(Long id);

}

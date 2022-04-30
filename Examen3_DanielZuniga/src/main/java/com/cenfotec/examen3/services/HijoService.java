package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Hijo;
import com.cenfotec.examen3.entities.Pariente;

import java.util.List;
import java.util.Optional;

public interface HijoService {
    public List<Hijo> getAll();
    public Optional<Hijo> findById(long id);
    public  Optional<Hijo> save(Hijo hijo);
    public  Optional<Hijo> update(Hijo hijo);
    public boolean delete(Long id);
}

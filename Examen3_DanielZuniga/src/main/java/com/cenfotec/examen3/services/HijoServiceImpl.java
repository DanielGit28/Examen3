package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Hijo;
import com.cenfotec.examen3.entities.Pariente;
import com.cenfotec.examen3.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HijoServiceImpl implements HijoService{
    @Autowired
    HijoRepository hijoRepository;

    @Override
    public List<Hijo> getAll() {
        return hijoRepository.findAll();
    }

    @Override
    public Optional<Hijo> findById(long id) {
        return hijoRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Hijo> save(Hijo hijo) {
        return Optional.of(hijoRepository.save(hijo));
    }

    @Override
    public  Optional<Hijo> update(Hijo hijo) {
        Optional<Hijo> record = hijoRepository.findById(hijo.getId());
        if (record.isPresent()) {
            Hijo data = record.get();
            data.setTipoUsuario(hijo.getTipoUsuario());
            data.setAlergias(hijo.getAlergias());
            data.setPadres(hijo.getPadres());
            data.setLibros(hijo.getLibros());
            return Optional.of(hijoRepository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Hijo> result = hijoRepository.findById(id);
        if (result.isPresent()){
            hijoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

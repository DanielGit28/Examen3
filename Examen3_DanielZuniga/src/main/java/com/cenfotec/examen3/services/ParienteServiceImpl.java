package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Pariente;
import com.cenfotec.examen3.repositories.ParienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParienteServiceImpl implements ParienteService {
    @Autowired
    ParienteRepository parienteRepository;

    @Override
    public List<Pariente> getAll() {
        return parienteRepository.findAll();
    }

    @Override
    public Optional<Pariente> findById(long id) {
        return parienteRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Pariente> findByNombre(String nombre) {
        return Optional.ofNullable(parienteRepository.findParienteByNombre(nombre));
    }

    @Override
    public  Optional<Pariente> save(Pariente pariente) {
        return Optional.of(parienteRepository.save(pariente));
    }

    @Override
    public  Optional<Pariente> update(Pariente pariente) {
        Optional<Pariente> record = parienteRepository.findById(pariente.getId());
        if (record.isPresent()) {
            Pariente data = record.get();
            data.setNombre(pariente.getNombre());
            data.setCedula(pariente.getCedula());
            data.setDireccion(pariente.getDireccion());
            data.setTelefonoPrimario(pariente.getTelefonoPrimario());
            data.setTelefonoSecundario(pariente.getTelefonoSecundario());
            data.setRelacionPariente(pariente.getRelacionPariente());
            return Optional.of(parienteRepository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Pariente> result = parienteRepository.findById(id);
        if (result.isPresent()){
            parienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

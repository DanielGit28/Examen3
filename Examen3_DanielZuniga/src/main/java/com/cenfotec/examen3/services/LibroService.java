package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepository;
    public List<Libro> getAllLibros(int count) {
        return
                this.libroRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    public Optional<Libro> getLibro(int id) {
        return this.libroRepository.findById(id);
    }
    public Libro createLibro(String nombre, String
            autor, String editorial, String fechaPublicacion) {

        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setFechaPublicacion(LocalDate.parse(fechaPublicacion));

        return this.libroRepository.save(libro);
    }

}

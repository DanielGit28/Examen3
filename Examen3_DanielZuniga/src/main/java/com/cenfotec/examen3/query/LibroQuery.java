package com.cenfotec.examen3.query;

import java.util.List;
import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.services.LibroService;



@Component
public class LibroQuery implements GraphQLQueryResolver {
    @Autowired
    private LibroService libroService;

    public List<Libro> getLibros(int count) {
        return this.libroService.getAllLibros(count);
    }

    public Optional<Libro> getLibro(int id) {
        return this.libroService.getLibro(id);
    }
}

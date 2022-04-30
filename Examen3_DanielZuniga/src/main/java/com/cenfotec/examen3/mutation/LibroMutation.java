package com.cenfotec.examen3.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class LibroMutation implements GraphQLMutationResolver {
    @Autowired
    private LibroService libroService;

    public Libro createLibro(String nombre, String
                                 autor, String fechaPublicacion,
                               String editorial) {
        return this.libroService.createLibro(nombre, autor,
                fechaPublicacion, editorial);
    }

}

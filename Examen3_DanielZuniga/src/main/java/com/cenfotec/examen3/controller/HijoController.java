package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.entities.Hijo;
import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.services.HijoService;
import com.cenfotec.examen3.services.LibroService;
import com.google.j2objc.annotations.AutoreleasePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/biblioteca/hijo")
public class HijoController {

    @Autowired
    private HijoService hijoService;
    @Autowired
    private LibroService libroService;

    @GetMapping(value = "/hola")
    public String funciona(){
        return "funciona hijo";
    }

    @GetMapping
    public List getAll(){
        return hijoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Hijo> findById(@PathVariable long id){
        Optional<Hijo> result = hijoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // endpoint que listA los libros que ha leído un niño
    @GetMapping(path = {"/libros/{id}"})
    public ResponseEntity<List> findLibrosById(@PathVariable long id){
        Optional<Hijo> result = hijoService.findById(id);
        List<Libro> libros = new ArrayList<>();

        if (result.isPresent()){
            for (Libro libro : libroService.getAllLibros(10) ) {
                for (Long cont : result.get().getLibros())
                if(libro.getId() == cont) {
                    libros.add(libro);
                }
            }

            return ResponseEntity.ok().body(libros);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // endpoint que lista los nombres de los niños y cuantos libros ha leído
    @GetMapping(path = {"/info/{id}"})
    public ResponseEntity<List> infoHijos(@PathVariable long id){
        List<Hijo> results = hijoService.getAll();
        List<Hijo> info = new ArrayList<>();
        for (Hijo hijo : results) {
            Hijo def = new Hijo(hijo.getNombre(),hijo.getLibros().size());
            info.add(def);
        }
        return ResponseEntity.ok().body(info);
    }

    @PostMapping
    public Hijo create(@RequestBody Hijo hijo){
        return hijoService.save(hijo).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Hijo> update(@PathVariable("id") long id,
                                          @RequestBody Hijo hijo){
        hijo.setId(id);
        Optional<Hijo> result = hijoService.update(hijo);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (hijoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

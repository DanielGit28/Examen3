package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.entities.Hijo;
import com.cenfotec.examen3.entities.Pariente;
import com.cenfotec.examen3.services.HijoService;
import com.cenfotec.examen3.services.ParienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/biblioteca/pariente")
public class ParienteController {

    @Autowired
    private ParienteService parienteService;
    @Autowired
    private HijoService hijoService;

    @GetMapping(value = "/hola")
    public String funciona(){
        return "funciona pariente";
    }

    @GetMapping
    public List getAll(){
        return parienteService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Pariente> findById(@PathVariable long id){
        Optional<Pariente> result = parienteService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //buscar los datos de un padre o madre por aproximación sobre el nombre y/o
    //apellidos
    @GetMapping(path = {"/nombre/{nombre}"})
    public ResponseEntity<Pariente> findByNombre(@PathVariable String nombre){
        Optional<Pariente> result = parienteService.findByNombre(nombre);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //dado el id de un padre o madre liste sus datos y sus hijos o hijas
    //Devuelve una lista de objetos combinados, en este caso el pariente y luego los hijos respectivos que hayan hecho match
    @GetMapping(path = {"/info/{id}"})
    public ResponseEntity<List> findParientesEHijos(@PathVariable long id){
        List<Object> results = new ArrayList<>();
        Optional<Pariente> result = parienteService.findById(id);
        List<Hijo> hijos = hijoService.getAll();
        if (result.isPresent() && hijos != null){
            results.add(result);
            //return ResponseEntity.ok().body(result.get());

            for( Hijo hijo : hijos) {
                if(hijo.getPadres().get(0).equals(result.get().getId())) {
                    System.out.println("Primer padre");
                    results.add(hijo);
                } else if(hijo.getPadres().get(1).equals(result.get().getId())) {
                    results.add(hijo);
                    System.out.println("Segundo padre");
                }
            }
        }

        return ResponseEntity.ok().body(results);
    }


    @PostMapping
    public Pariente create(@RequestBody Pariente pariente){
        return parienteService.save(pariente).get();
    }


    @PutMapping(value="/{id}")
    public ResponseEntity<Pariente> update(@PathVariable("id") long id,
                                       @RequestBody Pariente pariente){
        pariente.setId(id);
        Optional<Pariente> result = parienteService.update(pariente);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (parienteService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


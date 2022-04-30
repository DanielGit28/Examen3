package com.cenfotec.examen3.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipoUsuario;
    private String alergias;
    @ElementCollection
    private List<Long> padres;
    @ElementCollection
    private List<Long> libros;
    private int cantidadLibros;


    public Hijo() {
    }

    public Hijo(String nombre, int cantidadLibros) {
        this.nombre = nombre;
        this.cantidadLibros = cantidadLibros;
    }

    public Hijo(Long id, String nombre, String tipoUsuario, String alergias, List<Long> padres) {
        this.id = id;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.alergias = alergias;
        this.padres = padres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public List<Long> getPadres() {
        return padres;
    }

    public void setPadres(List<Long> padres) {
        this.padres = padres;
    }

    public List<Long> getLibros() {
        return libros;
    }

    public void setLibros(List<Long> libros) {
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }
}

package com.cenfotec.examen3.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
    private transient String formattedDate;
    public String getFormattedDate() {
        return getFechaPublicacion().toString();
    }
}

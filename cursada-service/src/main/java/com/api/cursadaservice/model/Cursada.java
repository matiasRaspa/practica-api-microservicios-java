package com.api.cursadaservice.model;

import com.api.cursadaservice.model.dto.EstudianteDTO;
import com.api.cursadaservice.model.dto.MateriaDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursadas")
public class Cursada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double nota;
    private Long estudiante_id;
    private Long materia_id;

    public Cursada() {
        //No-args constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Long getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Long estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public Long getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(Long materia_id) {
        this.materia_id = materia_id;
    }

    @Override
    public String toString() {
        return "Cursada{" +
                "id=" + id +
                ", nota=" + nota +
                ", estudiante_id=" + estudiante_id +
                ", materia_id=" + materia_id +
                '}';
    }
}

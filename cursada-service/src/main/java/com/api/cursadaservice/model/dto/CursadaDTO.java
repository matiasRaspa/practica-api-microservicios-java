package com.api.cursadaservice.model.dto;

public class CursadaDTO {

    private Long id;
    private double nota;
    private Long estudiante_id;
    private Long materia_id;

    public CursadaDTO() {
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
        return "CursadaDTO{" +
                "id=" + id +
                ", nota=" + nota +
                ", estudiante_id=" + estudiante_id +
                ", materia_id=" + materia_id +
                '}';
    }
}

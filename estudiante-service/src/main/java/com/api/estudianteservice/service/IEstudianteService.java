package com.api.estudianteservice.service;

import com.api.estudianteservice.model.dto.EstudianteDTO;

import java.util.List;

public interface IEstudianteService {

    void crearEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO leerEstudiantePorId(Long id);
    void modificarEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiantePorId(Long id);
    List<EstudianteDTO> listarTodos();
}

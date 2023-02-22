package com.api.estudianteservice.service.impl;

import com.api.estudianteservice.model.Estudiante;
import com.api.estudianteservice.model.dto.EstudianteDTO;
import com.api.estudianteservice.repository.IEstudianteRepository;
import com.api.estudianteservice.service.IEstudianteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService implements IEstudianteService {

    private final IEstudianteRepository estudianteRepository;
    private final ObjectMapper mapper;

    @Autowired
    public EstudianteService(IEstudianteRepository estudianteRepository, ObjectMapper mapper) {
        this.estudianteRepository = estudianteRepository;
        this.mapper = mapper;
    }

    @Override
    public void crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public EstudianteDTO leerEstudiantePorId(Long id) {
        EstudianteDTO estudianteDTO = null;
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if (estudiante.isPresent()){
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }

        return estudianteDTO;
    }

    @Override
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiantePorId(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public List<EstudianteDTO> listarTodos() {
        return estudianteRepository.findAll().stream().map(estudiante -> mapper.convertValue(estudiante, EstudianteDTO.class)).toList();
    }
}

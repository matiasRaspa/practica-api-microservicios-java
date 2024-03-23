package com.api.cursadaservice.service;

import com.api.cursadaservice.model.dto.EstudianteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "estudiante-service", url = "http://localhost:8081")
public interface IEstudianteService {

    @GetMapping("/estudiantes/{id}")
    EstudianteDTO obtenerEstudiantePorId(@PathVariable("id") Long id);
}

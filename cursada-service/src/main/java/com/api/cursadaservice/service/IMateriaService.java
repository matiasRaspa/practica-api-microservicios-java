package com.api.cursadaservice.service;

import com.api.cursadaservice.model.dto.MateriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "materia-service", url = "http://localhost:8082")
public interface IMateriaService {

    @GetMapping("/materias/{id}")
    MateriaDTO obtenerMateriaPorId(@PathVariable("id") Long id);
}

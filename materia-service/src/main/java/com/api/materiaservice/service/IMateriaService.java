package com.api.materiaservice.service;

import com.api.materiaservice.model.dto.MateriaDTO;

import java.util.List;

public interface IMateriaService {

    void crearMateria(MateriaDTO materiaDTO);
    MateriaDTO leerMateriaPorId(Long id);
    void modificarMateria(MateriaDTO materiaDTO);
    void eliminarMateriaPorId(Long id);
    List<MateriaDTO> listarTodas();
}

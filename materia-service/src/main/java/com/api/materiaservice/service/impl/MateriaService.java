package com.api.materiaservice.service.impl;

import com.api.materiaservice.model.Materia;
import com.api.materiaservice.model.dto.MateriaDTO;
import com.api.materiaservice.repository.IMateriaRepository;
import com.api.materiaservice.service.IMateriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService implements IMateriaService {

    private final IMateriaRepository materiaRepository;
    private final ObjectMapper mapper;

    @Autowired
    public MateriaService(IMateriaRepository materiaRepository, ObjectMapper mapper) {
        this.materiaRepository = materiaRepository;
        this.mapper = mapper;
    }

    @Override
    public void crearMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public MateriaDTO leerMateriaPorId(Long id) {
        MateriaDTO materiaDTO = null;
        Optional<Materia> materia = materiaRepository.findById(id);
        if (materia.isPresent()){
            materiaDTO = mapper.convertValue(materia, MateriaDTO.class);
        }

        return materiaDTO;
    }

    @Override
    public void modificarMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public void eliminarMateriaPorId(Long id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public List<MateriaDTO> listarTodas() {
        return materiaRepository.findAll().stream().map(materia -> mapper.convertValue(materia, MateriaDTO.class)).toList();
    }
}

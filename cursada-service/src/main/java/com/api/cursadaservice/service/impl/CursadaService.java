package com.api.cursadaservice.service.impl;

import com.api.cursadaservice.model.Cursada;
import com.api.cursadaservice.model.dto.CursadaDTO;
import com.api.cursadaservice.model.dto.EstudianteDTO;
import com.api.cursadaservice.model.dto.MateriaDTO;
import com.api.cursadaservice.repository.ICursadaRepository;
import com.api.cursadaservice.service.ICursadaService;
import com.api.cursadaservice.service.IEstudianteService;
import com.api.cursadaservice.service.IMateriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CursadaService implements ICursadaService {

    private final ICursadaRepository cursadaRepository;
    private final ObjectMapper mapper;

    @Autowired
    public CursadaService(ICursadaRepository cursadaRepository, ObjectMapper mapper) {
        this.cursadaRepository = cursadaRepository;
        this.mapper = mapper;
    }

    @Override
    public void crearCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public CursadaDTO leerCursadaPorId(Long id) {
        CursadaDTO cursadaDTO = null;
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        if (cursada.isPresent()){
            cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
        }

        return cursadaDTO;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public void eliminarCursadaPorId(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public List<CursadaDTO> listarTodas() {
        return cursadaRepository.findAll().stream().map(cursada -> mapper.convertValue(cursada, CursadaDTO.class)).toList();
    }
}

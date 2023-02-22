package com.api.cursadaservice.service;

import com.api.cursadaservice.model.dto.CursadaDTO;

import java.util.List;

public interface ICursadaService {

    void crearCursada(CursadaDTO cursadaDTO);
    CursadaDTO leerCursadaPorId(Long id);
    void modificarCursada(CursadaDTO cursadaDTO);
    void eliminarCursadaPorId(Long id);
    List<CursadaDTO> listarTodas();
}

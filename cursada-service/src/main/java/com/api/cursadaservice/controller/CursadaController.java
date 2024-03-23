package com.api.cursadaservice.controller;

import com.api.cursadaservice.model.dto.CursadaDTO;
import com.api.cursadaservice.model.dto.EstudianteDTO;
import com.api.cursadaservice.model.dto.MateriaDTO;
import com.api.cursadaservice.service.ICursadaService;
import com.api.cursadaservice.service.IEstudianteService;
import com.api.cursadaservice.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/cursadas")
public class CursadaController {

    private final ICursadaService cursadaService;
    private final IEstudianteService estudianteService;
    private final IMateriaService materiaService;

    @Autowired
    public CursadaController(ICursadaService cursadaService, IEstudianteService estudianteService, IMateriaService materiaService) {
        this.cursadaService = cursadaService;
        this.estudianteService = estudianteService;
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<List<CursadaDTO>> listarTodas(){
        List<CursadaDTO> buscandoListaDeCursadas = cursadaService.listarTodas();
        if(buscandoListaDeCursadas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscandoListaDeCursadas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursadaDTO> buscarCursadaPorId(@PathVariable(name = "id") Long id){
        CursadaDTO buscandoCursada = cursadaService.leerCursadaPorId(id);
        if(buscandoCursada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscandoCursada);
    }

    @PostMapping
    public ResponseEntity<CursadaDTO> crearCursada(@RequestBody CursadaDTO cursadaDTO){
        EstudianteDTO estudianteDTO = estudianteService.obtenerEstudiantePorId(cursadaDTO.getEstudiante_id());
        MateriaDTO materiaDTO = materiaService.obtenerMateriaPorId(cursadaDTO.getMateria_id());
        if(cursadaDTO.getNota() < 0.0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        cursadaService.crearCursada(cursadaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CursadaDTO> modificarCursada(@RequestBody CursadaDTO cursadaDTO){
        CursadaDTO buscandoCursada = cursadaService.leerCursadaPorId(cursadaDTO.getId());
        if(buscandoCursada == null || cursadaDTO.getNota() < 0.0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        cursadaService.modificarCursada(cursadaDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CursadaDTO> eliminarCursadaPorId(@PathVariable(name = "id") Long id){
        CursadaDTO buscandoCursada = cursadaService.leerCursadaPorId(id);
        if(buscandoCursada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        cursadaService.eliminarCursadaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

package com.api.estudianteservice.controller;

import com.api.estudianteservice.model.dto.EstudianteDTO;
import com.api.estudianteservice.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> listarTodos(){
        List<EstudianteDTO> buscandoListaDeEstudiantes = estudianteService.listarTodos();
        if(buscandoListaDeEstudiantes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscandoListaDeEstudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> buscarEstudiantePorId(@PathVariable(name = "id") Long id){
        EstudianteDTO buscandoEstudiante = estudianteService.leerEstudiantePorId(id);
        if(buscandoEstudiante == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscandoEstudiante);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        if(estudianteDTO.getNombre() == null || estudianteDTO.getApellido() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<EstudianteDTO> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        EstudianteDTO buscandoEstudiante = estudianteService.leerEstudiantePorId(estudianteDTO.getId());
        if(buscandoEstudiante == null || estudianteDTO.getNombre() == null || estudianteDTO.getApellido() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        estudianteService.modificarEstudiante(estudianteDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstudianteDTO> eliminarEstudiantePorId(@PathVariable(name = "id") Long id){
        EstudianteDTO buscandoEstudiante = estudianteService.leerEstudiantePorId(id);
        if(buscandoEstudiante == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        estudianteService.eliminarEstudiantePorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

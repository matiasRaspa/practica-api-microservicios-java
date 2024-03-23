package com.api.materiaservice.controller;

import com.api.materiaservice.model.dto.MateriaDTO;
import com.api.materiaservice.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/materias")
public class MateriaController {

    private final IMateriaService materiaService;

    @Autowired
    public MateriaController(IMateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<List<MateriaDTO>> listarTodas(){
        List<MateriaDTO> buscandoListaDeMaterias = materiaService.listarTodas();
        if(buscandoListaDeMaterias.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscandoListaDeMaterias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> buscarMateriaPorId(@PathVariable(name = "id") Long id){
        MateriaDTO buscandoMateria = materiaService.leerMateriaPorId(id);
        if(buscandoMateria == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscandoMateria);
    }

    @PostMapping
    public ResponseEntity<MateriaDTO> crearMateria(@RequestBody MateriaDTO materiaDTO){
        if(materiaDTO.getNombre() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        materiaService.crearMateria(materiaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<MateriaDTO> modificarMateria(@RequestBody MateriaDTO materiaDTO){
        MateriaDTO buscandoMateria = materiaService.leerMateriaPorId(materiaDTO.getId());
        if(buscandoMateria == null || materiaDTO.getNombre() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        materiaService.modificarMateria(materiaDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MateriaDTO> eliminarMateriaPorId(@PathVariable(name = "id") Long id){
        MateriaDTO buscandoMateria = materiaService.leerMateriaPorId(id);
        if(buscandoMateria == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        materiaService.eliminarMateriaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

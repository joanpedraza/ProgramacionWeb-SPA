package net.javaguides.springboot.controller;

import net.javaguides.springboot.exeption.ResourceNotFoundException;
import net.javaguides.springboot.model.Materia;
import net.javaguides.springboot.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class MateriaController {
        @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping("/materias")
    public List<Materia> getAllMaterias(){
        return materiaRepository.findAll();
    }

    @GetMapping("/materias/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable(value = "id") long materiaID)
        throws ResourceNotFoundException{
        Materia materia = materiaRepository.findById(materiaID)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró materia por esta Id::" + materiaID));
        return ResponseEntity.ok().body(materia);
    }

    @PostMapping("/materias")
    public Materia createMateria(@RequestBody Materia materia){
        return materiaRepository.save(materia);
    }

    @PutMapping("/materias/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable(value = "id") Long materiaId, @RequestBody Materia materiaDetalles)
        throws ResourceNotFoundException {
        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró materia por esta Id::" + materiaId));
        materia.setNombre(materiaDetalles.getNombre());
        materia.setCreditos(materiaDetalles.getCreditos());
        final Materia materiaActualizada = materiaRepository.save(materia);
        return ResponseEntity.ok(materiaActualizada);
    }

    @DeleteMapping("/materias/{id}")
    public Map<String, Boolean> deleteMateria(@PathVariable(value = "id") Long materiaId)
            throws ResourceNotFoundException {
        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró materia por esta Id::" + materiaId));

        materiaRepository.delete(materia);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Borrado", Boolean.TRUE);
        return response;
    }
}

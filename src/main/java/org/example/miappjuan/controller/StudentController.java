package org.example.miappjuan.controller;

import jakarta.validation.Valid;
import org.example.miappjuan.model.Stundent;
import org.example.miappjuan.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    // Volvemos a usar Inyección de Dependencias para traer el Service
    @Autowired
    private StudentService service;

    // Endpoint para guardar (POST: http://localhost:8080/api/estudiantes)
    @PostMapping
    public Stundent create(@RequestBody Stundent stundent){
        return service.saveStudent(stundent);
    }

    // Endpoint para listar (GET: http://localhost:8080/api/estudiantes)
    @GetMapping
    public List<Stundent> listAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Stundent getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Stundent update(@PathVariable Long id, @Valid @RequestBody Stundent stundent) {
        return service.updateStudent(id, stundent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build(); // devuelve 204
    }
}

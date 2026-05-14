package org.example.miappjuan.controller;

import org.example.miappjuan.model.Stundent;
import org.example.miappjuan.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
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
}

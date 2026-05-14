package org.example.miappjuan.services;

import org.example.miappjuan.model.Stundent;
import org.example.miappjuan.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Crear un estudiante en base de datos
    public Stundent saveStudent(Stundent stundent){
        return repository.save(stundent);
    }

    // Obtener todos los estudiantes de la base de datos
    public List<Stundent> findAll(){
        return repository.findAll();
    }
}

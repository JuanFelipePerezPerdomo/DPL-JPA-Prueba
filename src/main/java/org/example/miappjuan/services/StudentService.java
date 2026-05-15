package org.example.miappjuan.services;

import org.example.miappjuan.exception.StudentNotFoundException;
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

    public Stundent findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Stundent updateStudent(Long id, Stundent data) {
        Stundent existing = findById(id); // lanza 404 si no existe
        existing.setName(data.getName());
        existing.setEmail(data.getEmail());
        existing.setAge(data.getAge());
        return repository.save(existing);
    }

    public void deleteStudent(Long id) {
        findById(id); // lanza 404 si no existe
        repository.deleteById(id);
    }
}

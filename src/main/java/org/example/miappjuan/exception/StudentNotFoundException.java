package org.example.miappjuan.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("Estudiante con id:"+id+" no encontrado");
    }
}

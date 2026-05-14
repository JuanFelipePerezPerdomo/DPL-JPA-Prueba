package org.example.miappjuan.repository;

import org.example.miappjuan.model.Stundent;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Stundent, Long>{
    // Al extender JpaRepository, ya tenemos métodos como save(), findAll(), findById(), deleteById()
}

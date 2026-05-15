package org.example.miappjuan.services;

import org.example.miappjuan.model.Stundent;
import org.example.miappjuan.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import  static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService service;

    private Stundent stundent;

    @BeforeEach
    void setUp(){
        stundent = new Stundent();
        stundent.setId(2L);
        stundent.setName("Becomo Alonso");
        stundent.setEmail("becomo.alonso@gmail.com");
        stundent.setAge(20);
    }

    @Test
    void testSaveStudent(){
        when(repository.save(any(Stundent.class))).thenReturn(stundent);
        Stundent save = service.saveStudent(new Stundent());
        assertNotNull(save);
        assertEquals("Joana Santana", save.getName());
        verify(repository, times(1)).save(any(Stundent.class));
    }

    @Test
    void  testFindAll() {
        when(repository.findAll()).thenReturn(List.of(stundent));

        List<Stundent> lista = service.findAll();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        verify(repository, times(1)).findAll();
    }
}

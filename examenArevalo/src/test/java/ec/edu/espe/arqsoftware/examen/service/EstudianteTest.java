/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.service;

/**
 *
 * @author Diana
 */
import ec.edu.espe.arqsoftware.examen.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.examen.exception.CreateException;
import ec.edu.espe.arqsoftware.examen.model.Estudiante;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EstudianteTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteService service;
    private Estudiante estudianteSample1;
    private Estudiante estudianteSample2;
    private List<Estudiante> estudianteList;

    @BeforeEach
    public void setUp() {
        this.estudianteSample1 = new Estudiante();
        estudianteSample1.setId("1011");
        estudianteSample1.setNombre("Juan");
        estudianteSample1.setApellido("Perez");
        estudianteSample1.setEmail("ejemplo1@gmail.com");
        estudianteSample1.setPais("001ARG");
        estudianteSample1.setFechaNacimiento(new Date());
        estudianteSample1.setFechaCreacion(new Date());
        estudianteSample1.setEstado("ACT");

        this.estudianteSample2 = new Estudiante();
        estudianteSample2.setId("2022");
        estudianteSample2.setNombre("Pedro");
        estudianteSample2.setApellido("Lopez");
        estudianteSample2.setEmail("ejemplo2@gmail.com");
        estudianteSample2.setPais("002ECU");
        estudianteSample2.setFechaNacimiento(new Date());
        estudianteSample2.setFechaCreacion(new Date());
        estudianteSample2.setEstado("ACT");

        this.estudianteList = new ArrayList<>();
        this.estudianteList.add(estudianteSample1);
        this.estudianteList.add(estudianteSample2);
    }

    @Test
    public void GivenEmailReturnCliente() {
        when(estudianteRepository.findByEmail("ejemplo1@gmail.com")).thenReturn(estudianteSample1);
        try {
            Assertions.assertEquals(estudianteSample1, service.getByEmail("ejemplo1@gmail.com"));
        } catch (Exception e) {
            Logger.getLogger(EstudianteTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void GivenNonExistantEmailThrowCreateException() {

        when(estudianteRepository.findByEmail("ejemplo1@gmail.com")).thenReturn(null);
        try {
            Assertions.assertThrows(CreateException.class, () -> service.getByEmail("ejemplo1@gmail.com"));
        } catch (Exception e) {
            Logger.getLogger(EstudianteTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void GivenEstudianteCreateEstudiante() {
        when(this.estudianteRepository.findByEmail("ejemplo1@gmail.com")).thenReturn(null);
        when(this.estudianteRepository.save(estudianteSample1)).thenReturn(estudianteSample1);
        try {
            Assertions.assertEquals(estudianteSample1.getId(), service.createEstudante(estudianteSample1));
        } catch (Exception e) {
            Logger.getLogger(EstudianteTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void GivenEstudianteThatExistThrowCreateException() {
        when(this.estudianteRepository.findByEmail("ejemplo2@gmail.com")).thenReturn(estudianteSample2);
        try {
            Assertions.assertThrows(CreateException.class, () -> service.createEstudante(estudianteSample2));
        } catch (Exception e) {
            Logger.getLogger(EstudianteTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

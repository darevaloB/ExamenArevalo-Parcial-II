/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.service;

import ec.edu.espe.arqsoftware.examen.dao.CursoRepository;
import ec.edu.espe.arqsoftware.examen.model.Curso;
import ec.edu.espe.arqsoftware.examen.model.Estudiante;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Diana
 */
@ExtendWith(MockitoExtension.class)
public class CursoTest {

    @Mock
    private CursoRepository cursoRepository;
    
      @InjectMocks
    private CursoService service;
    private Curso cursoSample1;
    private Curso cursoSample2;
    private List<Curso> cursoList;

    @BeforeEach
    public void setUp() {
        this.cursoSample1 = new Curso();
        cursoSample1.setId("01");
        cursoSample1.setCodigoCurso("C01");
        cursoSample1.setArea("Computacion");
        cursoSample1.setNombre("Programacion");
        cursoSample1.setDuracionHoras("6");
        cursoSample1.setFechaInicio(new Date());
        cursoSample1.setCosto(50.00);
        
            
        
    }
    
 @Test
    public void GivenAreaAndFechaInicioReturnListCursos() {
        when(this.cursoRepository.findByAreaAndFechaInicio("Computacion", new Date())).thenReturn(cursoList);
        try {
            Assertions.assertEquals(cursoList, this.service.getByArea("Computacion"));
        } catch (Exception e) {
            Logger.getLogger(CursoTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void GivenNombreAndFechaInicioReturnCursos() {
        when(this.cursoRepository.findByNombreAndFechaInicio("Programacion", new Date())).thenReturn(cursoList);
        try {
            Assertions.assertEquals(cursoList, this.service.getByNombre("Programacion"));
        } catch (Exception e) {
            Logger.getLogger(CursoTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.service;

import ec.edu.espe.arqsoftware.examen.dao.CursoRepository;
import ec.edu.espe.arqsoftware.examen.model.Curso;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana
 */
@Service
@Slf4j
public class CursoService {

    private final CursoRepository cursoRepo;

    public CursoService(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

     public List<Curso> getByArea(String area) {
        return this.cursoRepo.findByAreaAndFechaInicio(area, new Date());
    }
     
      public List<Curso> getByNombre(String nombre) {
        return this.cursoRepo.findByNombreAndFechaInicio(nombre, new Date());
    }
}

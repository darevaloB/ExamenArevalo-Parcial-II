/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.dao;

import ec.edu.espe.arqsoftware.examen.model.Curso;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Diana
 */
public interface CursoRepository extends MongoRepository<Curso, String> {

    List<Curso> findByAreaAndFechaInicio(String area, Date fechaInicio);

    List<Curso> findByNombreAndFechaInicio(String nombre,Date fechaInicio);
    Curso findByCodigo(String codigoCurso);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.dao;

import ec.edu.espe.arqsoftware.examen.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Diana
 */
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    Estudiante findByEmail(String email);
}

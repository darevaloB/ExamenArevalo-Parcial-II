/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.service;

import ec.edu.espe.arqsoftware.examen.dao.CursoRepository;
import ec.edu.espe.arqsoftware.examen.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.examen.dto.InformacionMatriculaDTO;
import ec.edu.espe.arqsoftware.examen.dto.MatriculaRQ;
import ec.edu.espe.arqsoftware.examen.exception.CreateException;
import ec.edu.espe.arqsoftware.examen.model.Curso;
import ec.edu.espe.arqsoftware.examen.model.Estudiante;
import ec.edu.espe.arqsoftware.examen.model.Matricula;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana
 */
@Service
@Slf4j
public class EstudianteService {

    private final EstudianteRepository estudianteRepo;
    private final CursoRepository cursoRepo;

    public EstudianteService(EstudianteRepository estudianteRepo, CursoRepository cursoRepo) {
        this.estudianteRepo = estudianteRepo;
        this.cursoRepo = cursoRepo;
    }

    public Estudiante getByEmail(String email) {
        Estudiante estudiante = this.estudianteRepo.findByEmail(email);
        if (estudiante == null) {
            throw new CreateException("Estudiante no encontrado con ese Correo electronico  ");
        }
        return estudiante;
    }

    public String createEstudante(Estudiante estudiante) {

        Estudiante estudianteAux = this.estudianteRepo.findByEmail(estudiante.getEmail());
        log.info("Datos Emmail: {}", estudianteAux);
        java.util.Date fecha = new Date();
        if (estudianteAux == null) {
            estudiante.setFechaCreacion(fecha);
            estudiante.setEstado("ACT");
            return this.estudianteRepo.save(estudiante).getId();

        } else {
            throw new CreateException("El estudiante con correo: " + estudiante.getEmail() + " ya existe");
        }

    }

    public InformacionMatriculaDTO matricularEstudiante(MatriculaRQ matriculaRQ) {
        Estudiante estudianteAux = this.estudianteRepo.findByEmail(matriculaRQ.getIdEstudiante());
        if (estudianteAux == null) {
            throw new CreateException("No se encontro un estudiante con el id enviado");
        }

        Curso cursoAux = this.cursoRepo.findByCodigo(matriculaRQ.getIdCurso());
        if (cursoAux == null) {
            throw new CreateException("No se encontro un curso con el id enviado");
        }

        Estudiante estudiante = estudianteAux;

        Curso curso = cursoAux;

        if (estudiante.getMatricula().stream().filter(m -> m.getEstado()).collect(Collectors.toList()).size() > 0) {
            throw new CreateException("El estudiante ingresado ya tiene un curso ACTIVO");
        }

        Matricula matricula = Matricula.builder()
                .curso(curso)
                .estado(true)
                .fechaMatricula(new Date())
                .build();
        
        List<Matricula> matriculas = estudiante.getMatricula();
        matriculas.add(matricula);
        estudiante.setMatricula(matriculas);
        this.estudianteRepo.save(estudiante);
        return InformacionMatriculaDTO.builder()
                .matricula(matricula)
                .nombreEstudiante(estudiante.getNombre())
                .build();
    }

}

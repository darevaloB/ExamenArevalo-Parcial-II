/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.controller;

import ec.edu.espe.arqsoftware.examen.dto.EstudianteRQ;
import ec.edu.espe.arqsoftware.examen.dto.GenericDetailSerializer;
import ec.edu.espe.arqsoftware.examen.dto.InformacionMatriculaDTO;
import ec.edu.espe.arqsoftware.examen.dto.MatriculaRQ;
import ec.edu.espe.arqsoftware.examen.exception.CreateException;
import ec.edu.espe.arqsoftware.examen.model.Estudiante;
import ec.edu.espe.arqsoftware.examen.service.CursoService;
import ec.edu.espe.arqsoftware.examen.service.EstudianteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diana
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    public EstudianteController(EstudianteService estudianteService, CursoService cursoService) {
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @PostMapping
    @ApiOperation(value = "Crea un estudiante", notes = "Crea un nuevo estudiante")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Estudiante creado correctamente"),
        @ApiResponse(code = 404, message = "Estudiante recibido con error")
    })
    public ResponseEntity createEstudiante(@RequestBody EstudianteRQ estudianteRQ) {
        String errorMessage = "Error al crear el Estudiante";
        try {
            log.info("Va a crear el estudiante con la siguiente informacion: {}",
                    estudianteRQ);
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(estudianteRQ.getNombre());
            estudiante.setNombre(estudianteRQ.getApellido());
            estudiante.setEmail(estudianteRQ.getEmail());
            estudiante.setPais(estudianteRQ.getPais());
            estudiante.setFechaNacimiento(estudianteRQ.getFechaNacimiento());

            this.estudianteService.createEstudante(estudiante);

            return ResponseEntity.ok().build();
        } catch (CreateException e) {
            GenericDetailSerializer errorResponse;
            errorResponse = new GenericDetailSerializer(
                    errorMessage, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    
    
    @PostMapping
     @ApiOperation(value = "Crea Matricula", notes = "Matricular a estudiante ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Estudiante matriculado correctamente"),
        @ApiResponse(code = 404, message = "Estudiante no se pudo matrocular error")
    })
    public ResponseEntity<InformacionMatriculaDTO> matricularEstudiante(@RequestBody MatriculaRQ matriculaRQ) {
        try {
            return ResponseEntity.ok().body(this.estudianteService.matricularEstudiante(matriculaRQ));
        } catch (CreateException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

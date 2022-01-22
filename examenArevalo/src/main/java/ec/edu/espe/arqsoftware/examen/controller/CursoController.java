/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.controller;

import ec.edu.espe.arqsoftware.examen.dto.GenericDetailSerializer;
import ec.edu.espe.arqsoftware.examen.model.Curso;
import ec.edu.espe.arqsoftware.examen.service.CursoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diana
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v2/cursos")
public class CursoController {
    
    private final CursoService service;
    
    public CursoController(CursoService service) {
        this.service = service;
    }
    
    @GetMapping(value = "area/{area}")
    @ApiOperation(value = "Buscar curso por area", notes = "buscar curso por area")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Cursos encontrados correctamente"),
        @ApiResponse(code = 404, message = "No se ha encontrado cursos - error")
    })
    public ResponseEntity getByArea(@PathVariable("area") String area) {
        String errorMessage = "Error de Busqueda de Curso por Area";
        try {
            List<Curso> cursos = this.service.getByArea(area);
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            GenericDetailSerializer errorResponse;
            errorResponse = new GenericDetailSerializer(
                    errorMessage, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    
    @GetMapping(value = "nombre/{nombre}")
    @ApiOperation(value = "Buscar curso por nombre", notes = "buscar curso por nombre")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Cursos encontrados correctamente"),
        @ApiResponse(code = 404, message = "No se ha encontrado cursos - error")
    })
    public ResponseEntity getByNombre(@PathVariable("nombre") String nombre) {
        String errorMessage = "Error de Busqueda de Curso por Nombre";
        try {
            List<Curso> cursos = this.service.getByNombre(nombre);
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            GenericDetailSerializer errorResponse;
            errorResponse = new GenericDetailSerializer(
                    errorMessage, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    
}

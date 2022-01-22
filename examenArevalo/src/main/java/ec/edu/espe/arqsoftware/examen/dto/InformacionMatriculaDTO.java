/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.dto;

import ec.edu.espe.arqsoftware.examen.model.Matricula;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Diana
 */
@Data
@Builder
public class InformacionMatriculaDTO {
       private String nombreEstudiante;
    private Matricula matricula;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.dto;

import ec.edu.espe.arqsoftware.examen.model.Curso;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Diana
 */
@Data
public class EstudianteRQ {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String pais;
    private Date fechaNacimiento;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Diana
 */
@Data
@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String pais;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private String estado;
    
   private List<Matricula> matricula;;

    

}

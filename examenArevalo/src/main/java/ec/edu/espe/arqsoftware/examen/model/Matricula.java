/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Diana
 */
@Data
@Builder
@Document(collection = "matricula")
public class Matricula {

    private Matricula matricula;
    @DBRef(lazy = true)
    private Curso curso;
    private Boolean estado;
    private Date fechaMatricula;
}

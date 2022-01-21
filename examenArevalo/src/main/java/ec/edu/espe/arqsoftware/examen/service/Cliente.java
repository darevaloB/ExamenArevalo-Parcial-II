/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.service;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Diana
 */
@Data
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;
    private String tipoIdentificacion;
    private String identificacion;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre1;
    private String nombre2;
    private String provincia;
    private String canton;
    private String parroquia;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    @Indexed(name = "idx_cliente_estadoCivil")
    private String estadoCivil;
    private String estadoBancaWeb;
    private String estado;
    private String tipoCuenta;

}

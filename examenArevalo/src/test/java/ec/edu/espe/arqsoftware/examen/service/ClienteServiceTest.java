/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.service;

/**
 *
 * @author Diana
 */
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//import ec.edu.espe.distribuidas.corebancariocliente.dao.ClienteRepository;
//import ec.edu.espe.distribuidas.corebancariocliente.exception.CreateException;
//import ec.edu.espe.distribuidas.corebancariocliente.exception.DeleteException;
//import ec.edu.espe.distribuidas.corebancariocliente.model.Cliente;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

//    @Mock
//    private ClienteRepository clienteRepository;
//
//    @InjectMocks
//    private ClienteService service;
//    private Cliente clienteSample1;
//    private Cliente clienteSample2;
//    private List<Cliente> clienteList;
//
//    @BeforeEach
//    public void setUp() {
//        this.clienteSample1 = new Cliente();
//        clienteSample1.setId("101");
//        clienteSample1.setApellidoMaterno("Sanchez");
//        clienteSample1.setApellidoPaterno("Gonzales");
//        clienteSample1.setCanton("Mejia");
//        clienteSample1.setDireccion("De los pinos y Armenia");
//        clienteSample1.setEmail("ejemplo1@gmail.com");
//        clienteSample1.setEstado("ACT");
//        clienteSample1.setEstadoBancaWeb("ACT");
//        clienteSample1.setEstadoCivil("SOLTERO");
//        clienteSample1.setFechaNacimiento(new Date());
//        clienteSample1.setIdentificacion("1707707145");
//        clienteSample1.setNombre1("Pablo");
//        clienteSample1.setNombre2("Julian");
//        clienteSample1.setParroquia("San Juan");
//        clienteSample1.setProvincia("Pichincha");
//        clienteSample1.setTelefono("022345678");
//        clienteSample1.setTipoIdentificacion("CED");
//
//        this.clienteSample2 = new Cliente();
//        clienteSample2.setId("102");
//        clienteSample2.setApellidoMaterno("Andrade");
//        clienteSample2.setApellidoPaterno("Pinos");
//        clienteSample2.setCanton("Quito");
//        clienteSample2.setDireccion("Shyris y Naciones Unidas");
//        clienteSample2.setEmail("ejemplo2@gmail.com");
//        clienteSample2.setEstado("ACT");
//        clienteSample2.setEstadoBancaWeb("ACT");
//        clienteSample2.setEstadoCivil("SOLTERO");
//        clienteSample2.setFechaNacimiento(new Date());
//        clienteSample2.setIdentificacion("1801915818");
//        clienteSample2.setNombre1("María");
//        clienteSample2.setNombre2("José");
//        clienteSample2.setParroquia("La Carolina");
//        clienteSample2.setProvincia("Pichincha");
//        clienteSample2.setTelefono("0212345678");
//        clienteSample2.setTipoIdentificacion("CED");
//        this.clienteList = new ArrayList<>();
//        this.clienteList.add(clienteSample1);
//        this.clienteList.add(clienteSample2);
//    }
//
//    @Test
//    public void GivenListReturnListOfAllClients() {
//        when(clienteRepository.findAll()).thenReturn(clienteList);
//        try {
//            Assertions.assertEquals(clienteList, service.getAll());
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenTipoIdentificacionAndIdentificacionReturnCliente() {
//        when(clienteRepository.findByTipoIdentificacionAndIdentificacion("CED", "1707707145")).thenReturn(clienteSample1);
//        try {
//            Assertions.assertEquals(clienteSample1, service.getByTipoIdentificacionAndIdentifiacion("CED", "1707707145"));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenNonExistantTipoIdentificacionAndIdentificacionThrowCreateException() {
//
//        when(clienteRepository.findByTipoIdentificacionAndIdentificacion("CED", "1724217367")).thenReturn(null);
//        try {
//            Assertions.assertThrows(CreateException.class, () -> service.getByTipoIdentificacionAndIdentifiacion("CED", "1724217367"));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenClienteCreateClienteAndReturnId() {
//        when(this.clienteRepository.findByTipoIdentificacionAndIdentificacion("CED", "1707707145")).thenReturn(null);
//        when(this.clienteRepository.save(clienteSample1)).thenReturn(clienteSample1);
//        try {
//            Assertions.assertEquals(clienteSample1.getId(), service.createCliente(clienteSample1));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenClienteThatExistThrowCreateException() {
//        when(this.clienteRepository.findByTipoIdentificacionAndIdentificacion("CED", "1801915818")).thenReturn(clienteSample2);
//        try {
//            Assertions.assertThrows(CreateException.class, () -> service.createCliente(clienteSample2));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenInvalidIdentificationThrowCreateException() {
//        clienteSample2.setIdentificacion("1801915819");
//        when(this.clienteRepository.findByTipoIdentificacionAndIdentificacion("CED", "1801915819")).thenReturn(null);
//        try {
//            Assertions.assertThrows(CreateException.class, () -> service.createCliente(clienteSample2));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//        clienteSample2.setIdentificacion("1801915818");
//    }
//
//    @Test
//    public void GivenClienteIdReturnCliente() {
//        when(this.clienteRepository.findById("101")).thenReturn(Optional.of(clienteSample1));
//        try {
//            Assertions.assertEquals(clienteSample1, this.service.getById("101"));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenClienteIdThatNotExistReturnNull() {
//        when(this.clienteRepository.findById("103")).thenReturn(Optional.empty());
//        try {
//            Assertions.assertEquals(null, this.service.getById("103"));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenEstadoBancaWebReturnListClientes() {
//        when(this.clienteRepository.findByEstadoBancaWeb("ACT")).thenReturn(clienteList);
//        try {
//            Assertions.assertEquals(clienteList, this.service.getByEstadoBancaWeb("ACT"));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenEstadoBancaWebReturnCountClientes() {
//        when(this.clienteRepository.countByEstadoBancaWeb("ACT")).thenReturn(2);
//        try {
//            Assertions.assertEquals(2, this.service.getCountEstadoBancaWeb("ACT"));
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    @Test
//    public void GivenClienteModifyCliente() {
//        when(this.clienteRepository.findById("101")).thenReturn(Optional.of(clienteSample1));
//        when(this.clienteRepository.save(clienteSample1)).thenReturn(clienteSample1);
//        try {
//            this.service.modifyCliente(clienteSample1);
//        } catch (Exception e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
////    @Test
////    public void GivenClienteThatNotExistThrowCreateException() {
////        clienteSample1.setId("103");
////        when(this.clienteRepository.findById("103")).thenReturn(null);
////        try {
////            Assertions.assertThrows(CreateException.class, () -> this.service.modifyCliente(clienteSample1));
////        } catch (Exception e) {
////            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
////        }
////    }
//
//    @Test
//    public void GivenClienteDeleteCliente() {
//        when(this.clienteRepository.findById("101")).thenReturn(Optional.of(clienteSample1));
//        try {
//            this.service.deleteCliente(clienteSample1.getId());
//        } catch (DeleteException e) {
//            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
////    @Test
////    public void GivenDeleteClienteThatNotExistThrowCreateException() {
////        clienteSample1.setId("103");
////        when(this.clienteRepository.findById("103")).thenReturn(null);
////        try {
////            Assertions.assertThrows(CreateException.class, () -> this.service.deleteCliente(clienteSample1.getId()));
////        } catch (Exception e) {
////            Logger.getLogger(ClienteServiceTest.class.getName()).log(Level.SEVERE, null, e);
////        }
////    }

}

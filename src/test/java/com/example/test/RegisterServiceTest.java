/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.easyconference.access.ConferenceArrayListRepository;
import com.easyconference.domain.entities.Conference;
import com.easyconference.domain.service.ConferenceService;
import com.easyconference.domain.service.UserService;

public class RegisterServiceTest {

    private UserService registerService;
    private ConferenceArrayListRepository repository;

    @BeforeEach
    public void setup() {
        repository = new ConferenceArrayListRepository();
        registerService = new UserService(repository);
    }

    @Test
    public void testRegistroUsuarioExitoso() {
        String name = "Juan";
        String lastName = "Pérez";
        String email = "juan.perez@example.com";
        String password = "password123";
        String country = "Colombia";
        String organization = "UniCauca";
        String fields = "Machine Learning";

        boolean resultado = registerService.registerUser(name, lastName, email, password, country, organization, fields);

        assertTrue(resultado, "El usuario debería registrarse exitosamente.");
        assertEquals(1, repository.listUsuario().size(), "Debería haber un usuario registrado.");
    }

    @Test
    public void testRegistroUsuarioEmailDuplicado() {
        String name = "Ana";
        String lastName = "Lopez";
        String email = "ana.lopez@example.com";
        String password = "password123";
        String country = "Mexico";
        String organization = "UniMex";
        String fields = "Data Science";

        // Registrar el primer usuario
        registerService.registerUser(name, lastName, email, password, country, organization, fields);

        // Intentar registrar otro usuario con el mismo email
        boolean resultadoDuplicado = registerService.registerUser(name, lastName, email, password, country, organization, fields);

        assertFalse(resultadoDuplicado, "No debería permitirse registrar un usuario con un email duplicado.");
        assertEquals(1, repository.listUsuario().size(), "Debería haber solo un usuario registrado.");
    }

    @Test
    public void testValidacionNombreInvalido() {
        String name = "12345";  // Nombre no válido
        String lastName = "Pérez";
        String email = "juan.perez@example.com";
        String password = "password123";
        String country = "Colombia";
        String organization = "UniCauca";
        String fields = "Machine Learning";

        boolean resultado = registerService.registerUser(name, lastName, email, password, country, organization, fields);

        assertFalse(resultado, "No debería permitirse registrar un usuario con un nombre inválido.");
        assertEquals(0, repository.listUsuario().size(), "No debería haber usuarios registrados.");
    }

    @Test
    public void testValidacionEmailInvalido() {
        String name = "Juan";
        String lastName = "Pérez";
        String email = "juan.perez.com";  // Email inválido
        String password = "password123";
        String country = "Colombia";
        String organization = "UniCauca";
        String fields = "Machine Learning";

        boolean resultado = registerService.registerUser(name, lastName, email, password, country, organization, fields);

        assertFalse(resultado, "No debería permitirse registrar un usuario con un email inválido.");
        assertEquals(0, repository.listUsuario().size(), "No debería haber usuarios registrados.");
    }

    @Test
    public void testValidacionContrasenaInvalida() {
        String name = "Juan";
        String lastName = "Pérez";
        String email = "juan.perez@example.com";
        String password = "12345";  // Contraseña inválida
        String country = "Colombia";
        String organization = "UniCauca";
        String fields = "Machine Learning";

        boolean resultado = registerService.registerUser(name, lastName, email, password, country, organization, fields);

        assertFalse(resultado, "No debería permitirse registrar un usuario con una contraseña inválida.");
        assertEquals(0, repository.listUsuario().size(), "No debería haber usuarios registrados.");
    }

    @Test
    public void testValidacionCamposObligatoriosFaltantes() {
        String name = "Juan";
        String lastName = "";  // Falta el apellido
        String email = "juan.perez@example.com";
        String password = "password123";
        String country = "Colombia";
        String organization = "UniCauca";
        String fields = "Machine Learning";

        boolean resultado = registerService.registerUser(name, lastName, email, password, country, organization, fields);

        assertFalse(resultado, "No debería permitirse registrar un usuario con campos faltantes.");
        assertEquals(0, repository.listUsuario().size(), "No debería haber usuarios registrados.");
    }
    
    @Test
    public void testListarConferencias (){
        ConferenceArrayListRepository objConference = new ConferenceArrayListRepository();
        ConferenceService Services = new ConferenceService(objConference);
        Conference conferencia = new Conference("Energia Nuclear", "Ciencia", "UNO", "USA", "ACTIVO", "MAYAMI", "EJEMPLO", "11-11-2025", "11-11-2026", "11-10-2025", "11-10-2025", 2, 1, 1);
        Services.almacenarConferencia(conferencia);
        int resultado = objConference.listConference().size();
        System.out.println(""+objConference.listConference().get(0).getName());
        assertFalse(resultado>0, "La lista se creo Exitosamente");
        assertEquals(resultado==0, repository.listUsuario().size(), "No debería haber usuarios registrados.");
    }
}


package com.example.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.easyconference.access.ConferenceArrayListRepository;
import com.easyconference.domain.entities.Conference;
import com.easyconference.domain.entities.Usuario;
import com.easyconference.domain.service.ConferenceService;
import com.easyconference.domain.service.UserService;

/**
 * Clase de pruebas unitarias para el registro
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */
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
        String lastName = "Perez";
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
    public void testLogin(){
        String correo = "example@gamil.com";
        String contrasenia = "12345678";
        Usuario us = new Usuario("Carla","Constain",correo,contrasenia,"colombia","unicauca","algo1,algo2");
        repository.agregarUsuario(us); 
        Usuario result = registerService.login(correo, contrasenia);
        
        assertTrue(us.equals(result), "El login fue exitosos");
    }
}

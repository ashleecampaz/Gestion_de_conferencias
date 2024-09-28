package com.example.test;
import com.easyconference.access.Conference.ConferenceArrayListRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.easyconference.domain.service.ConferenceService;
import com.easyconference.domain.entities.Conference;
import com.easyconference.access.Conference.ConferenceLinkedListRepository;
/**
 * Clase e pruebas unitarias para conferencia 
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */
public class ConferenceTest {

    private ConferenceService conferenceService;
    private ConferenceLinkedListRepository repository;

    @BeforeEach
    public void setUp() {
        // Inicializa el repositorio y el servicio antes de cada prueba
        repository = new ConferenceLinkedListRepository();
        conferenceService = new ConferenceService(repository);
    }

    @Test
    public void testAlmacenarConferencia() {
        // Crea un objeto Conference para almacenar
        Conference conference = new Conference(
            "Tech Conference 2024", "Technology", "Tech Org",
            "Colombia", "Antioquia", "Medellín", "123 Tech Street",
            "01-01-2024", "03-01-2024", "25-12-2023", "15-12-2023",
            100, 50, 7.5f
        );
        
        // Almacena la conferencia y comprueba que el resultado sea true
        boolean resultado = conferenceService.almacenarConferencia(conference);
        assertTrue(resultado, "La conferencia debería haberse almacenado correctamente.");

        // Verifica que la conferencia se haya almacenado en el repositorio
        assertEquals(1, repository.listConference().size(), "El repositorio debería contener una conferencia.");
        assertEquals(conference, repository.listConference().get(0), "La conferencia almacenada no coincide.");
    }
    
    @Test
    public void testListarConferencias (){
        Conference conferencia = new Conference("Energia Nuclear", "Ciencia", "UNO", "USA", "ACTIVO", "MAYAMI", "EJEMPLO", "11-11-2025", "11-11-2026", "11-10-2025", "11-10-2025", 2, 1, 1);
        conferenceService.almacenarConferencia(conferencia);
        int resultado = conferenceService.listarConferencias().size();
        
        assertTrue(resultado>0, "La lista se creo Exitosamente");
    }
}

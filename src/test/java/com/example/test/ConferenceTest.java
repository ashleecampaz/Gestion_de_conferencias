
package com.example.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.easyconference.access.ConferenceArrayListRepository;
import com.easyconference.domain.entities.Usuario;
import com.easyconference.domain.service.ConferenceService;
import com.easyconference.domain.service.UserService;
import com.easyconference.presentation.GUIcreateConference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JTextField;
/**
 *
 * @author Moni
 */
class ConferenceTest {
    
    // Simulación de componentes del formulario
    private JTextField txtfNombre, txtfTemas, txtfEntOrganizadora, txtfFechaInicio, txtfFechaFin, txtfPlazoMaxRec,
            txtfMaxArt, txtfPlazoMaxEva, txtfMaxCalAcep, txtfMaxArtAcep, txtfPais, txtfCiudad, txtfEstado, txtfDireccion;

    private GUIcreateConference conferenceForm;

    @BeforeEach
    public void setUp() {
        // Inicializar textboxes con Mockito (simulaciones)
        txtfNombre = new JTextField();
        txtfTemas = new JTextField();
        txtfEntOrganizadora = new JTextField();
        txtfFechaInicio = new JTextField();
        txtfFechaFin = new JTextField();
        txtfPlazoMaxRec = new JTextField();
        txtfMaxArt = new JTextField();
        txtfPlazoMaxEva = new JTextField();
        txtfMaxCalAcep = new JTextField();
        txtfMaxArtAcep = new JTextField();
        txtfPais = new JTextField();
        txtfCiudad = new JTextField();
        txtfEstado = new JTextField();
        txtfDireccion = new JTextField();

        // Instancia del formulario que contiene el método pnlBotonGuardarMouseClicked
        ConferenceArrayListRepository r = new ConferenceArrayListRepository();
        Usuario u = new Usuario("Test", "Test", "Test", "Test", "Test", "Test", "Test");
        ConferenceService c = new ConferenceService(r);
        conferenceForm = new GUIcreateConference(c,u);
    }

    @Test
    public void testCreacionConferenciaValida() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Establecer valores válidos en los campos
        txtfNombre.setText("Conferencia Ejemplo");
        txtfTemas.setText("Tecnología");
        txtfEntOrganizadora.setText("Organización A");
        txtfFechaInicio.setText("25-10-2024");
        txtfFechaFin.setText("28-10-2024");
        txtfPlazoMaxRec.setText("15-10-2024");
        txtfMaxArt.setText("100");
        txtfPlazoMaxEva.setText("18-10-2024");
        txtfMaxCalAcep.setText("7.5");
        txtfMaxArtAcep.setText("80");
        txtfPais.setText("España");
        txtfCiudad.setText("Madrid");
        txtfEstado.setText("Comunidad de Madrid");
        txtfDireccion.setText("Calle Falsa 123");

        // Ejecutar la función
       
        // Usar Reflection para acceder al método privado
        Method method = GUIcreateConference.class.getDeclaredMethod("pnlBotonGuardarMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);  // Permitir el acceso

        // Invocar el método
        method.invoke(conferenceForm, (java.awt.event.MouseEvent) null);

        // Verificar que la conferencia se registró exitosamente
        assertEquals("Conferencia registrada exitosamente.", conferenceForm.getLastDialogMessage());
    }

    @Test
    public void testCamposVacios() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Dejar campos vacíos
        txtfNombre.setText("");
        txtfTemas.setText("Tecnología");
        txtfEntOrganizadora.setText("Organización A");
        txtfFechaInicio.setText("25-10-2024");
        txtfFechaFin.setText("28-10-2024");
        
        // Ejecutar la función
       
        // Usar Reflection para acceder al método privado
        Method method = GUIcreateConference.class.getDeclaredMethod("pnlBotonGuardarMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);  // Permitir el acceso

        // Invocar el método
        method.invoke(conferenceForm, (java.awt.event.MouseEvent) null);



        // Verificar que se muestra el mensaje de campos vacíos
        assertEquals("Todos los campos deben ser completados.", conferenceForm.getLastDialogMessage());
    }

    @Test
    public void testFechasIncorrectas() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Establecer una fecha de inicio incorrecta (menor a un mes después de la fecha actual)
        txtfNombre.setText("Conferencia Ejemplo");
        txtfTemas.setText("Tecnología");
        txtfEntOrganizadora.setText("Organización A");
        txtfFechaInicio.setText("01-10-2024");
        txtfFechaFin.setText("28-10-2024");
        txtfPlazoMaxRec.setText("15-09-2024");
        txtfMaxArt.setText("100");
        txtfPlazoMaxEva.setText("20-09-2024");
        txtfMaxCalAcep.setText("7.5");
        txtfMaxArtAcep.setText("80");
        txtfPais.setText("España");
        txtfCiudad.setText("Madrid");
        txtfEstado.setText("Comunidad de Madrid");
        txtfDireccion.setText("Calle Falsa 123");
        
        // Ejecutar la función
       
        // Usar Reflection para acceder al método privado
        Method method = GUIcreateConference.class.getDeclaredMethod("pnlBotonGuardarMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);  // Permitir el acceso

        // Invocar el método
        method.invoke(conferenceForm, (java.awt.event.MouseEvent) null);


       
        // Verificar que se muestra el mensaje de error de fecha de inicio
        assertEquals("La fecha de inicio debe ser al menos un mes después de la actual.", conferenceForm.getLastDialogMessage());
    }
}
package com.example.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.easyconference.access.ArticuloArrayListRepository;
import com.easyconference.access.ConferenceArrayListRepository;
import com.easyconference.domain.entities.Conference;
import com.easyconference.domain.entities.Usuario; // Importar Usuario para el Dummy
import com.easyconference.domain.service.ArticuloService;
import com.easyconference.domain.service.ConferenceService; // Importar ConferenceService para el Dummy
import com.easyconference.domain.service.IConferenceService;
import com.easyconference.presentation.GUIcreateArticle;
import com.example.test.DummyGUIcontainer; // Importar tu clase Dummy
import java.lang.reflect.Field;
import javax.swing.JTextField;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author sonhuila
 *
 */
class ArticuloTest {

    // Simulación de componentes del formulario
    private JTextField txtfTitulo, txtfPalabrasClaves;
    private JTextArea txtaResumen;
    private GUIcreateArticle articuloForm;

    @BeforeEach
    public void setUp() {
        // Inicializar componentes del formulario
        txtfTitulo = new JTextField();
        txtaResumen = new JTextArea();
        txtfPalabrasClaves = new JTextField();

        // Instancia del repositorio y servicio de artículos
        ArticuloArrayListRepository r = new ArticuloArrayListRepository();
        ArticuloService a = new ArticuloService(r);

        // Instancia del repositorio de conferencias
        ConferenceArrayListRepository conferenceRepository = new ConferenceArrayListRepository();

        // Instancia del servicio de conferencias, utilizando el repositorio de conferencias
        ConferenceService conferenceService = new ConferenceService(conferenceRepository);

        // Crear una conferencia de ejemplo para pasar al formulario
        Conference conference = new Conference("Conferencia Ejemplo", "Tecnología", "Organización A",
                "25-10-2024", "28-10-2024", "15-10-2024", "Comunidad de Madrid",
                "18-10-2024", "Calle Falsa 123", "Madrid", "España",
                80, 100, 7.5f);

        // Crear una instancia del DummyGUIcontainer
        Usuario usuario = new Usuario("Test", "Test", "Test", "Test", "Test", "Test", "Test");

        DummyGUIcontainer dummyContainer = new DummyGUIcontainer(usuario, conferenceService, a);

        // Pasar la conferencia al formulario y crear la instancia de la GUI
        articuloForm = new GUIcreateArticle(a, conference, dummyContainer);

        // Usar Reflection para acceder a los campos privados de GUIcreateArticle
        setPrivateField("txtfTitulo", txtfTitulo, articuloForm);
        setPrivateField("txtaResumen", txtaResumen, articuloForm);
        setPrivateField("txtfPalabrasClaves", txtfPalabrasClaves, articuloForm);
    }

    /**
     * Método helper para modificar un campo privado usando Reflection.
     */
    private void setPrivateField(String fieldName, Object value, Object targetObject) {
        try {
            Field field = targetObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(targetObject, value);
        } catch (Exception e) {
            e.printStackTrace();
            fail("No se pudo acceder al campo privado: " + fieldName);
        }
    }

    @Test
    public void testCreacionArticuloValido() throws Exception {
        // Establecer valores válidos en los campos
        txtfTitulo.setText("Título del Artículo");
        txtaResumen.setText("Contenido del artículo aquí.");
        txtfPalabrasClaves.setText("palabra1, palabra2");

        // Ejecutar el método en el hilo de eventos de Swing
        invokeMouseClick("lbEnviarMouseClicked");

        // Verificar que el artículo se registró exitosamente
        assertEquals("Artículo enviado exitosamente.", articuloForm.getLastDialogMessage());
    }

    @Test
    public void testCamposVacios() throws Exception {
        // Dejar el título vacío para probar validación
        txtfTitulo.setText("");
        txtaResumen.setText("Contenido del artículo aquí.");
        txtfPalabrasClaves.setText("palabra1, palabra2");

        // Ejecutar el método en el hilo de eventos de Swing
        invokeMouseClick("lbEnviarMouseClicked");

        // Verificar que se muestra el mensaje de error "El título es obligatorio."
        assertEquals("El título es obligatorio.", articuloForm.getLastDialogMessage());
    }

    @Test
    public void testContenidoInvalido() throws Exception {
        // Establecer un contenido inválido (por ejemplo, resumen vacío)
        txtfTitulo.setText("Título");
        txtaResumen.setText(""); // Resumen vacío
        txtfPalabrasClaves.setText("palabra1");

        // Ejecutar el método en el hilo de eventos de Swing
        invokeMouseClick("lbEnviarMouseClicked");

        // Verificar que se muestra el mensaje de error por campo vacío en el resumen
        assertEquals("El resumen es obligatorio.", articuloForm.getLastDialogMessage());
    }

    /**
     * Método helper para invocar un método privado en el hilo de eventos de
     * Swing.
     */
    private void invokeMouseClick(String methodName) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            try {
                Method method = GUIcreateArticle.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
                method.setAccessible(true);
                method.invoke(articuloForm, (java.awt.event.MouseEvent) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

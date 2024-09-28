package com.example.test;

import com.easyconference.domain.entities.Usuario;
import com.easyconference.domain.service.ArticleService;
import com.easyconference.domain.service.ConferenceService;
import com.easyconference.presentation.GUIcontainer;

/**
 * La clase DummyGUIcontainer es una implementación de la clase GUIcontainer
 * que se utiliza como una versión de prueba o simulada de la interfaz de usuario.
 * 
 * <p>
 * Esta clase es útil para pruebas, ya que permite crear un contenedor GUI 
 * sin implementar toda la funcionalidad del GUIcontainer original.
 * </p>
 * 
 * <p>
 El constructor de DummyGUIcontainer recibe un objeto Usuario, un 
 ConferenceService y un ArticleService, y los pasa al constructor 
 de la clase padre GUIcontainer.
 </p>
 * 
 * @author sonhuila
 */
class DummyGUIcontainer extends GUIcontainer {

    /**
     * Constructor que inicializa DummyGUIcontainer con un usuario,
     * un servicio de conferencias y un servicio de artículos.
     *
     * @param us El usuario asociado al contenedor.
     * @param con El servicio de conferencias.
     * @param artService El servicio de artículos.
     */
    public DummyGUIcontainer(Usuario us, ConferenceService con, ArticleService artService) {
        super(us, con, artService);
    }

    /**
     * Método que lista artículos. 
     * 
     * Esta implementación es vacía y puede ser sobrescrita en 
     * futuras implementaciones según se necesite.
     */
    @Override
    public void listArticles() {
        // Implementación vacía o básica
    }
}



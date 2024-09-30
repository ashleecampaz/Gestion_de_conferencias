package com.easyconference.access.Conference;

import com.easyconference.domain.entities.Conference;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase representa una Repositorio basado en LinkedList
 * Permite almacenar y recuperar información sobre conferencias.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 */

public class ConferenceLinkedListRepository implements IConferenceRepository {

    private LinkedList<Conference> listConference;

    /**
     * Constructor que inicializa la lista de conferencias como una LinkedList vacía.
     */
    public ConferenceLinkedListRepository() {
        this.listConference = new LinkedList<>();
    }

    /**
     * Almacena una conferencia en el repositorio.
     *
     * @param objConference La conferencia a almacenar.
     * @return true si la conferencia fue agregada correctamente, false en caso de error.
     * @throws IllegalArgumentException si la conferencia proporcionada es null.
     */
    @Override
    public boolean storeConference(Conference objConference) {
        if (objConference == null) {
            throw new IllegalArgumentException("La conferencia no puede ser null.");
        }
        boolean bandera = this.listConference.add(objConference);
        return bandera;
    }

    /**
     * Retorna la lista de conferencias almacenadas.
     *
     * @return Una lista de conferencias.
     */
    @Override
    public List<Conference> listConference() {
        return this.listConference;
    }
    @Override
    public List<Conference> SearchConferenciasForName(String searchText){
        return this.listConference;
    }
}
package com.easyconference.access.Conference;

import com.easyconference.domain.entities.Conference;
import java.util.List;
/**
 * Interfaz IConferenceRepository que define los métodos para manejar
 * el almacenamiento y la recuperación de conferencias.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */

public interface IConferenceRepository {
    public boolean storeConference(Conference objConference);
    public List<Conference> listConference();
    public List<Conference> SearchConferenciasForName(String searchText);
}

package com.easyconference.domain.service;

import com.easyconference.domain.entities.Conference;
import java.util.List;
/**
 * Esta clase representa la interfaz para los servicios de la conferencia
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */

public interface IConferenceService {
    public boolean storeConference(Conference objConference);
    public List<Conference> listConference();
    public List<Conference> SearchConferenciasForName(String searchText);
}

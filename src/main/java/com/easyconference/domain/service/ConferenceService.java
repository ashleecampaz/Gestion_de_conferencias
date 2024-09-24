package com.easyconference.domain.service;
import java.util.List;
import com.easyconference.domain.entities.Conference;
/**
 * Esta clase contiene los metodos de la clase conferencia, especialmente de almacenamiento y listado
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */

public class ConferenceService {
    
    private IConferenceService referenceRepositoryConferency;
    
    //puedo enviar objetos que pertenecen a clases que implementan la interface

    public ConferenceService(IConferenceService referenceRepositoryConferency) {
        this.referenceRepositoryConferency = referenceRepositoryConferency;
    }
 
    public boolean almacenarConferencia(Conference objConfererence) {
        boolean bandera=this.referenceRepositoryConferency.storeConference(objConfererence);
        return bandera;
    }

    public List<Conference> listarConferencias() {
        return this.referenceRepositoryConferency.listConference();
    }
}

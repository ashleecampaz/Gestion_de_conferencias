package com.easyconference.domain.service;
import com.easyconference.access.Conference.IConferenceRepository;
import com.easyconference.access.Factory;
import java.util.List;
import com.easyconference.domain.entities.Conference;
import com.easyconference.infra.Subject;
/**
 * Esta clase contiene los metodos de la clase conferencia, especialmente de almacenamiento y listado
 * 
 *@author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 * @version 1.0
 * @since 2024
 */

public class ConferenceService extends Subject {
    
    private IConferenceRepository referenceRepositoryConferency;
    
    //puedo enviar objetos que pertenecen a clases que implementan la interface

    public ConferenceService(IConferenceRepository referenceRepositoryConferency) {
        this.referenceRepositoryConferency = referenceRepositoryConferency;
    }
    
     public ConferenceService(String typeRepositoy) {
        this.referenceRepositoryConferency = Factory.getInstance().getConferenceRepository(typeRepositoy);
    }
 
    public boolean almacenarConferencia(Conference objConfererence) {
        boolean bandera=this.referenceRepositoryConferency.storeConference(objConfererence);
        return bandera;
    }

    public List<Conference> listarConferencias() {
        return this.referenceRepositoryConferency.listConference();
    }
    
    public List<Conference> search(String searchText){
        return this.referenceRepositoryConferency.SearchConferenciasForName(searchText);
    }
    
    public IConferenceRepository getReferenceRepositoryConferency() {
        return referenceRepositoryConferency;
    }
    
}

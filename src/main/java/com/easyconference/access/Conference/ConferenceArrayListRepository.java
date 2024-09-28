
package com.easyconference.access.Conference;

import com.easyconference.domain.entities.Conference;
import com.easyconference.domain.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import com.easyconference.access.User.IUserRepository;
/**
 * Esta clase representa una Repositorio basado en ArrayList
 * Permite almacenar y recuperar información sobre conferencias,
 * como tambien de usuarios, ademas de realizar algunas validaciones 
 * a la clase usuario
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */

public class ConferenceArrayListRepository implements IConferenceRepository{

    

    private ArrayList<Conference> listConference;
     

    /**
     * Constructor que inicializa las listas de conferencias y usuarios.
     */
    public ConferenceArrayListRepository() {
        this.listConference = new ArrayList<>();
        
    }

    /**
     * Almacena una conferencia en el repositorio.
     *
     * @param objConference La conferencia a almacenar.
     * @return true si la conferencia fue agregada correctamente, false en caso contrario.
     */
    @Override
    public boolean storeConference(Conference objConference) {
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
    public List<Conference> SearchConferenciasForName(String searchText) {
        List<Conference> result = new ArrayList<>();
        for (Conference conference : listConference) {
            if (conference.getName().toLowerCase().contains(searchText.toLowerCase())) {
                result.add(conference);
            }
        }
        return result;
    }
}
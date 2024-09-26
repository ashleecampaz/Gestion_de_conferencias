
package com.easyconference.access;

import com.easyconference.domain.service.IArticuloService;
import com.easyconference.domain.service.IConferenceService;
/**
 * Esta clase implementa el patrón Singleton para proporcionar una instancia única
 * de la clase Factory, la cual se encarga de crear repositorios de conferencias.
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */
public class Factory {
    
     private static Factory instance;
      /**
     * Constructor privado para evitar la creación de instancias adicionales.
     */
    private Factory() {
    }

 /**
     * Obliga a factory a ser singleton
     *
     * @return La instancia de Factory.
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }
      /**
     * Crea un repositorio de conferencias según el tipo especificado.
     *
     * @param type El tipo de repositorio a crear. Puede ser "default" para
     *             un repositorio basado en ArrayList o "list" para uno basado
     *             en LinkedList.
     * @return Una instancia de IConferenceService correspondiente al tipo
     *         solicitado, o null si el tipo no es reconocido.
     */
    public IConferenceService getRepository(String type) {

        IConferenceService result = null;

        switch (type) {
            case "default":
                result = new ConferenceArrayListRepository();
                break;
            case "list":
                result = new ConferenceLinkedListRepository();
                break;
        }
        return result;
    }
    
    public IArticuloService getArticuloRepository(String type) {

        IArticuloService result = null;

        switch (type) {
            case "default":
                result = new ArticuloArrayListRepository();
                break;
            case "list":
                result = new ArticuloLinkedListRepository();
                break;
        }
        return result;
    }
   
}


package com.easyconference.access;

import com.easyconference.access.Article.ArticleLinkedListRepository;
import com.easyconference.access.Article.ArticleArrayListRepository;
import com.easyconference.access.Conference.ConferenceArrayListRepository;
import com.easyconference.access.Conference.ConferenceLinkedListRepository;
import com.easyconference.access.Conference.IConferenceRepository;
import com.easyconference.access.User.IUserRepository;
import com.easyconference.access.User.UserArrayListRepository;
import com.easyconference.access.User.UserLinkedListRepository;
import com.easyconference.access.Article.IArticleRepository;
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
     * @return Una instancia de IConferenceRepository correspondiente al tipo
         solicitado, o null si el tipo no es reconocido.
     */
    public IConferenceRepository getConferenceRepository(String type) {

        IConferenceRepository result = null;

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
    
    public IArticleRepository getArticleRepository(String type) {

        IArticleRepository result = null;

        switch (type) {
            case "default":
                result = new ArticleArrayListRepository();
                break;
            case "list":
                result = new ArticleLinkedListRepository();
                break;
        }
        return result;
    }
    
    public IUserRepository getUserRepository(String type) {

        IUserRepository result = null;

        switch (type) {
            case "default":
                result = new UserArrayListRepository();
                break;
            case "list":
                result = new UserLinkedListRepository();
                break;
        }
        return result;
    }
   
   
}

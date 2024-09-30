
package com.easyconference.gestion_conferencias;


import com.easyconference.access.Article.IArticleRepository;
import com.easyconference.access.Conference.IConferenceRepository;
import com.easyconference.access.Factory;
import com.easyconference.domain.service.UserService;

import com.easyconference.presentation.GUIlogin;

import com.easyconference.access.User.IUserRepository;
import com.easyconference.domain.service.ArticleService;
import com.easyconference.domain.service.ConferenceService;

/**
 * Esta es la clase principal
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
public class Gestion_conferencias {

    public static void main(String[] args) {
        IUserRepository repoUser = Factory.getInstance().getUserRepository("default");
        UserService userService = new UserService( repoUser);
        
        IConferenceRepository repoConference =  Factory.getInstance().getConferenceRepository("default");
        ConferenceService ConferenceService = new ConferenceService( repoConference);
        
        IArticleRepository repoArticle = Factory.getInstance().getArticleRepository("default");
        ArticleService ArticleService = new ArticleService( repoArticle);
        
        
        
        
        GUIlogin login = new GUIlogin(userService);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
        //Contedor de inicio despues de iniciar sesion
        //GUIcontainer inicio = new GUIcontainer();
        //inicio.setVisible(true);
    }
}


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
 * @author 
 * @version 1.0
 * @since 2024
 */
public class Gestion_conferencias {

    public static void main(String[] args) {
        IUserRepository repoUser = (IUserRepository) Factory.getInstance().getUserRepository("default");
        UserService userService = new UserService((IUserRepository) repoUser);
        
        IConferenceRepository repoConference = (IConferenceRepository) Factory.getInstance().getConferenceRepository("default");
        ConferenceService ConferenceService = new ConferenceService((IConferenceRepository) repoConference);
        
        IArticleRepository repoArticle = (IArticleRepository) Factory.getInstance().getArticleRepository("default");
        ArticleService ArticleService = new ArticleService((IArticleRepository) repoArticle);
        
        
        
        
        GUIlogin login = new GUIlogin(userService);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
        //Contedor de inicio despues de iniciar sesion
        //GUIcontainer inicio = new GUIcontainer();
        //inicio.setVisible(true);
    }
}

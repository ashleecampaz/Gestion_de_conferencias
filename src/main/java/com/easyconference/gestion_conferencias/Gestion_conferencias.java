
package com.easyconference.gestion_conferencias;

import com.easyconference.access.Factory;
import com.easyconference.domain.service.UserService;
import com.easyconference.presentation.GUIcontainer;
import com.easyconference.presentation.GUIlogin;
import com.easyconference.presentation.GUIregister;
import com.easyconference.domain.service.IUserService;

/**
 * Esta es la clase principal
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */
public class Gestion_conferencias {

    public static void main(String[] args) {
        IUserService repoPro = (IUserService) Factory.getInstance().getRepository("default");
        UserService userService = new UserService((IUserService) repoPro);
        GUIlogin login = new GUIlogin(userService);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
        //Contedor de inicio despues de iniciar sesion
        //GUIcontainer inicio = new GUIcontainer();
        //inicio.setVisible(true);
    }
}

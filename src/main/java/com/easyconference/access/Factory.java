/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.easyconference.access;

import com.easyconference.domain.service.IArticuloService;
import com.easyconference.domain.service.IConferenceService;

/**
 *
 * @author Ashlee Campaz
 */
public class Factory {
    
     private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    
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

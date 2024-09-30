package com.easyconference.infra;

import java.util.ArrayList;
/**
 * Clase abstracta que representa un sujeto en el patrón de diseño Observer.
 * Los sujetos mantienen una lista de observadores y les notifican sobre 
 * cambios en su estado.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */
public abstract class Subject {

    ArrayList<Observer> observers;

    public void Subject() {

    }


    
    /**
     * Agrega un observador
     *
     * @param obs El observador a agregar.
     */
    public void addObserver(Observer obs) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(obs);
    }

    /**
     * Notifica a todos los observadores que hubo un cambio en el modelo
     */
    public void notifyAllObserves() {
        if (observers!=null){
            for (Observer each : observers) {
                each.update(this);
            }
        }
    }

}

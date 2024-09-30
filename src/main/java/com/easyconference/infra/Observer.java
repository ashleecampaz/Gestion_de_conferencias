package com.easyconference.infra;
/**
 * Interfaz que define el comportamiento de un observador en el patrón 
 * de diseño Observer. Los observadores son notificados de cambios 
 * en el estado del objeto observado.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */
public interface Observer {

    public void update(Object o);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mvc.vistas.articulos;

import co.edu.unicauca.mvc.infraestructura.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author wsern
 */
public class Revisor implements Observer {
    private String nombre;

    // Constructor
    public Revisor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(Object o) {
        // Mostrar notificación en ventana emergente cuando se actualiza el estado del artículo
        JOptionPane.showMessageDialog(null, "Notificación para " + nombre + ": El estado ha cambiado.", 
                                      "Notificación de Cambio", JOptionPane.INFORMATION_MESSAGE);
    }
}
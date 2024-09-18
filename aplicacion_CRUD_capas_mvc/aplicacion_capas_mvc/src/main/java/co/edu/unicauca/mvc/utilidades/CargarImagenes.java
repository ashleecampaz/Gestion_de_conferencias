/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import javax.swing.ImageIcon;

/**
 *
 * @author LENOVO
 */
public class CargarImagenes {
    public ImageIcon CargarImagen(String ruta)
    {
        ImageIcon imagen= new javax.swing.ImageIcon(getClass().getResource(ruta));  
        return imagen;
    }
}

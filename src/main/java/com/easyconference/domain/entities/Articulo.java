package com.easyconference.domain.entities;

import java.util.ArrayList;


/**
 * La clase Articulo representa un artículo que contiene un nombre, una lista de autores,
 * un resumen y palabras clave asociadas.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */
public class Articulo {
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;

    public Articulo(String nombre,ArrayList<String> autores, String resumen, String palabrasClaves) {
        this.nombre = nombre;
        this.autores = autores; 
        this.resumen = resumen;
        this.palabrasClaves = palabrasClaves;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }
    
    public void setAutores(ArrayList<String> autores){
        this.autores = autores;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }    
}
